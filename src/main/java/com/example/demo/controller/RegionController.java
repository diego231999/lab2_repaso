package com.example.demo.controller;

import com.example.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/list")
    public String listRegion(Model model){
        model.addAttribute("lista",regionRepository.findAll());
        return "/regions/lista";
    }


    @GetMapping("/form")
    public String createRegion(){
        return "";
    }

    @PostMapping("/save")
    public String saveRegino(){
        return "";
    }

    @GetMapping("/edit")
    public String editRegion(@RequestParam("id") int id){
        return "/regions/edit";
    }

    @GetMapping("/delete")
    public  String deleteRegion(){
        return "";
    }
}
