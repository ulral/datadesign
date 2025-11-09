package com.datadesign.sample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
@RequiredArgsConstructor
public class SampleDataMasterDetailController {

    @GetMapping("sampleDataMasterDetailView.do")
    public String  sampleDataMasterDetailView(){
        return "/pages/sample/view/sampleDataMasterDetailView";
    }
    @RequestMapping("sampleDataAttrMasterLayout.do")
    public String sampleDataAttrMasterLayout() {
        return "/pages/sample/layout/masterDetail/sampleDataAttrMasterLayout";
    }
    @RequestMapping("sampleDataAttrItemDetailLayout.do")
    public String sampleDataAttrItemDetailLayout() {
        return "/pages/sample/layout/masterDetail/sampleDataAttrItemDetailLayout";
    }
}
