package com.datadesign.grid.controller;

import com.datadesign.grid.model.DataAttrItem;
import com.datadesign.grid.model.GridAttrItem;
import com.datadesign.grid.service.DataAttrItemService;
import com.datadesign.grid.service.GridAttrItemService;
import com.datadesign.treegrid.config.TGRegistry;
import com.datadesign.treegrid.model.TGDownloadForm;
import com.datadesign.treegrid.model.TGUploadForm;
import com.datadesign.treegrid.service.TGService;
import com.datadesign.treegrid.util.TGConvertData;
import com.datadesign.treegrid.util.TGReflections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("treegrid")
@RequiredArgsConstructor
public class TreeGridController {
    private final TGReflections tgReflections;
    private final TGRegistry tgRegistry;
    private final DataAttrItemService dataAttrItemService;
    private final GridAttrItemService gridAttrItemService;

    @GetMapping("TGGridView.do")
    public String TGGridView(Model model) {
        model.addAttribute("menu", "메뉴명");
        return "/pages/treegrid/TGGridView";
    }

    @GetMapping("TGDataView.do")
    public String TGDataView() {
        return "/pages/treegrid/TGDataView";
    }

    @GetMapping("treegridData.do")
    @ResponseBody
    public TGDownloadForm<?> treegridData(
            @RequestParam(value = "Class", required = false) String type
    ) throws Exception {
        Class<?> clazz = tgReflections.getClass(type);
        TGService<?> service = tgRegistry.getService(clazz);
        return TGDownloadForm.init(service.findAll());
    }

    @GetMapping("treegridLayout.do")
    @ResponseBody
    public Map<String,Object> treegridLayout(
            @RequestParam(value = "Id", required = false, defaultValue = "id") String id,
            @RequestParam(value = "Grid", required = false, defaultValue = "Basic") String gridName,
            @RequestParam(value = "Data") String dataName
    ) {
        // 1. DB에 저장한 TreeGrid Layout의 속성값을 조회
        List<GridAttrItem> gridAttrItems = gridAttrItemService.findGridLayoutRaw(gridName);
        List<DataAttrItem> gridDataItems = dataAttrItemService.findDataLayoutRaw(dataName);
        // 2. layout Cfg태그의 id속성에 Layout_Param_Id에 지정한 값을 부여
        Map<String, Map<String, Object>> config = TGConvertData.convertToGroupedMap(gridAttrItems);
        config.computeIfAbsent("Cfg", k -> new HashMap<>()).put("id", id);
        // 3. TreeGrid 속성을 조회한 값들을 JSON 타입으로 변환
        Map<String, List<Map<String, Object>>> column = TGConvertData.convertGridDataItems(gridDataItems);

        return TGConvertData.mergeGridLayout(config, column);
    }

    @PostMapping("treegridUpload.do")
    @ResponseBody
    public Map<String, Object> treegridUpload(
        @RequestBody TGUploadForm<?> json,
        @RequestParam(value = "Class") String type
    ) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> out = new HashMap<>();
        
        try{
            Class<?> clazz = tgReflections.getClass(type);
            List<?> saved = tgRegistry.saveAll(clazz, json.getChanges());
            if(saved == null || saved.isEmpty()){
                out.put("Result", "-1");
                out.put("Message", "저장된 항목이 없습니다.");
            }
            else{
                out.put("Result", "0");
                out.put("Message", saved.size() + "건 저장되었습니다.");
            }
                result.put("IO", out);

        }catch (Exception e){
            e.printStackTrace();
            out.put("Result", "-1");
            out.put("Message", "오류가 발생했습니다!");
            result.put("IO", out);
        }
        return result;
    }

}
