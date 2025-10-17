package com.datadesign.treegrid.controller;

import com.datadesign.treegrid.model.*;
import com.datadesign.treegrid.service.*;
import com.datadesign.treegrid.util.TGConvertData;
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
    private final TGGridService tgGridService;
    private final TGDataService tgDataService;
    private final TGGridAttrService tgGridAttrService;
    private final TGDataAttrService tgDataAttrService;
    private final TGGridAttrItemService tgGridAttrItemService;
    private final TGDataAttrItemService tgDataAttrItemService;

    @GetMapping("TGGridView.do")
    public String TGGridView(Model model) {
        model.addAttribute("menu", "메뉴명");
        return "/pages/treegrid/TGGridView";
    }

    @GetMapping("TGDataView.do")
    public String TGDataView() {
        return "/pages/treegrid/TGDataView";
    }

    @GetMapping("TGGrid.do")
    @ResponseBody
    public TGDownloadForm<?> TGGrid( @RequestParam(value = "Class", required = false) String type) {

        return TGDownloadForm.init(tgGridService.findAll());
    }

    @GetMapping("TGGridAttr.do")
    @ResponseBody
    public TGDownloadForm<TGGridAttr> TGGridAttr() {
        return TGDownloadForm.init(tgGridAttrService.findAll());
    }

    @GetMapping("TGGridAttrItem.do")
    @ResponseBody
    public TGDownloadForm<TGGridAttrItem> TGGridAttrItem() {
        return TGDownloadForm.init(tgGridAttrItemService.findAll());
    }

    @GetMapping("TGData.do")
    @ResponseBody
    public TGDownloadForm<TGData> TGData() {
        return TGDownloadForm.init(tgDataService.findAll());
    }

    @GetMapping("TGDataAttr.do")
    @ResponseBody
    public TGDownloadForm<TGDataAttr> TGDataAttr() {
        return TGDownloadForm.init(tgDataAttrService.findAll());
    }

    @GetMapping("TGDataAttrItem.do")
    @ResponseBody
    public TGDownloadForm<TGDataAttrItem> TGDataAttrItem() {
        return TGDownloadForm.init(tgDataAttrItemService.findAll());
    }

    @GetMapping("treegridLayout.do")
    @ResponseBody
    public Map<String,Object> treegridLayout(
            @RequestParam(value = "Id", required = false, defaultValue = "id") String id,
            @RequestParam(value = "Grid", required = false, defaultValue = "Basic") String gridName,
            @RequestParam(value = "Data", required = false) String dataName
    ) {
        List<TGGridAttrItem> gridAttrItems = tgGridAttrItemService.findGridLayoutRaw(gridName);
        List<TGDataAttrItem> gridDataItems = tgDataAttrItemService.findDataLayoutRaw(dataName);

        Map<String, Map<String, Object>> grouped = TGConvertData.convertToGroupedMap(gridAttrItems);
        grouped.computeIfAbsent("Cfg", k -> new HashMap<>()).put("id", id);
        ;
        Map<String, List<Map<String, Object>>> layout = TGConvertData.convertGridDataItems(gridDataItems);

        return TGConvertData.mergeGridLayout(grouped, layout);
    }

    @PostMapping("treegridUpload.do")
    @ResponseBody
    public Map<String, Object> treegridUpload(
        @RequestBody TGUploadForm<TGGrid> json,
        @RequestParam(value = "Class", required = false) String type
    ) {
        System.out.println(json);
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> item = new HashMap<>();
        item.put("Result", "0");
        item.put("Message", "저장되었습니다!");
        result.put("IO", item);
        return result;
    }
}
