package com.datadesign.sample.controller;

import com.datadesign.sample.service.SampleMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
@RequiredArgsConstructor
public class SampleGridDataMasterDetailController {

    @GetMapping("sampleGridDataMasterDetailView.do")
    public String  sampleGridDataMasterDetailView(){
        return "/pages/sample/view/sampleGridDataMasterDetailView";
    }
    @RequestMapping("sampleGridDataAttrMasterLayout.do")
    public String sampleDataAttrMasterLayout() {
        return "/pages/sample/layout/masterDetail/sampleDataAttrMasterLayout";
    }
    @RequestMapping("sampleGridDataAttrItemDetailLayout.do")
    public String sampleDataAttrItemDetailLayout() {
        return "/pages/sample/layout/masterDetail/sampleDataAttrItemDetailLayout";
    }
}
