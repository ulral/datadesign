package com.datadesign.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
public class memberSampleController {
    @GetMapping("memberView")
    public String  memberView(){
        return "/member/memberView";
    }
}
