package com.datadesign.sample.controller;

import com.datadesign.sample.model.Member;
import com.datadesign.sample.service.SampleMemberService;
import com.datadesign.treegrid.model.TGDownloadForm;
import com.datadesign.treegrid.model.TGUploadForm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sample")
@RequiredArgsConstructor
public class SampleMemberController {
    private final SampleMemberService memberService;

    @GetMapping("memberView.do")
    public String  memberView(){
        return "/pages/sample/view/memberView";
    }
    @RequestMapping("memberData.do")
    @ResponseBody
    public TGDownloadForm<Member> memberData() {
        return TGDownloadForm.init(memberService.findAll());
    }
    @RequestMapping("memberLayout.do")
    public String memberLayout() {
        return "/pages/sample/layout/memberLayout";
    }
    @PostMapping("memberUpload.do")
    @ResponseBody
    public String treegridUpload(HttpServletRequest request, @RequestBody TGUploadForm<Member> json, @RequestParam(value = "Class", required = false) String type) {
        System.out.println(request);
        System.out.println(json);
        return "<Grid><IO Result='0' Message='저장되었습니다!'/></Grid>";
    }
}
