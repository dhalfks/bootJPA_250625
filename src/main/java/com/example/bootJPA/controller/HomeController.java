package com.example.bootJPA.controller;

import com.example.bootJPA.dto.BoardDTO;
import com.example.bootJPA.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {
    private final BoardService boardService;

    @RequestMapping("/")
    public String index(Model model){
        List<BoardDTO> bestList = boardService.getBestList();
        List<BoardDTO> bestCommentList = boardService.getBestCommentList();

        log.info(">>>> bestList >> {}", bestList);
        model.addAttribute("bestList",bestList);
        model.addAttribute("bestCommentList",bestCommentList);
        return "/index";
    }

}
