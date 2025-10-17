package com.datadesign.sample.controller;

import com.datadesign.sample.service.SampleMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
@RequiredArgsConstructor
public class SampleGridDataPivotController {
    private final SampleMemberService memberService;

    @GetMapping("sampleDataPivotView.do")
    public String  sampleDataPivotView(){
        return "/pages/sample/view/sampleDataPivotView";
    }
    @RequestMapping("sampleDataAttrPivotLayout.do")
    public String sampleDataAttrPivotLayout() {
        return "/pages/sample/layout/pivot/sampleDataAttrPivotLayout";
    }
    @RequestMapping("sampleDataItemPivotLayout.do")
    public String sampleDataAttrItemPivotLayout() {
        return "/pages/sample/layout/pivot/sampleDataAttrItemPivotLayout";
    }
//    @PostMapping("sampleGridDataUpload.do")
//    @ResponseBody
//    public String sampleGridDataUpload(HttpServletRequest request, @RequestBody TGUploadForm<Member> json, @RequestParam(value = "Class", required = false) String type) {
//        System.out.println(request);
//        System.out.println(json);
//        return "<Grid><IO Result='0' Message='저장되었습니다!'/></Grid>";
//    }
}
