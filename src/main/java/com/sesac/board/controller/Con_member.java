package com.sesac.board.controller;

import com.sesac.board.entity.Study_member;
import com.sesac.board.service.StudyMemberService;
import com.sesac.board.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class Con_member {

    @Autowired
    StudyMemberService studyMemberService;

    /* 전체 멤버 조회 */
    @GetMapping("/list")
    public String doMemberList(Model model) throws Exception {

        List<Study_member> list = studyMemberService.doSelectAll();

        model.addAttribute("list", list);

        return "/member/member_list";
    }

    /* 입력 */
    @GetMapping("/insert")
    public String doIns(){
        return "/member/member_join";
    }

    /* 회원가입 */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Study_member study_member) throws Exception {
        studyMemberService.doInsert(study_member);
        return "redirect:/member/list";
    }

    /* 회원삭제 */
    @GetMapping("/delete")
    public String doDel(@RequestParam(value="key_id", defaultValue = "--") String strMemberId){
        studyMemberService.doDelete(Integer.parseInt(strMemberId));
        return "redirect:/member/list";
    }


}
