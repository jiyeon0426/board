package com.sesac.board.controller;

import com.sesac.board.entity.Study_record;
import com.sesac.board.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/study")
public class Con_study {

    @Autowired
    StudyRecordService recordService;

    /* List 조회 */
    @GetMapping("/list")
    public String doStudyList(Model model){
        List<Study_record> list = recordService.doSelectAll();

        model.addAttribute("list", list);

        return "/study/study_list";

    }

    /* 입력 */
    @GetMapping("/insert")
    public String doIns(){ return "/study/study_ins";}

    /* 등록하기 실행 */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Study_record study_record){

        study_record.setReg_day(LocalDateTime.now());
        study_record.setMod_day(LocalDateTime.now());
        recordService.doInsert(study_record);

        return "redirect:/study/list";
    }

    /* 수정 */
    @GetMapping("/modify")
    public String doMod(HttpServletRequest request, Model model){
        String strKeyId= request.getParameter("key_id");

        Study_record study_record = recordService.doSelectOne(Integer.parseInt(strKeyId));

        //request.setAttribute("vo_study", study_record);

        /* 타임리프는 아래처럼 Model 을 사용하면 자동 인식이 됨*/
        model.addAttribute("vo_study",study_record);

        return "/study/study_mod";
    }

    /* 수정하기 실행 */
    @PostMapping("/modify_exe")
    public String doModExe(@ModelAttribute Study_record study_record){

        //study_record.setReg_day(LocalDateTime.now());
        //study_record.setMod_day(LocalDateTime.now());
        recordService.doInsert(study_record);

        return "redirect:/study/list";
    }

    /* 삭제 */
    @GetMapping("/delete")
    public String doDel(@RequestParam(value = "key_id", defaultValue = "--") String strKeyId){


        return "redirect: /study/list";
    }

}
