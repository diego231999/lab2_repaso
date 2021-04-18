package com.example.demo.controller;

import com.example.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/list")
    public String listRegion(){
        return "";
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
    public String editRegion(){
        return "";
    }

    @GetMapping("/delete")
    public  String deleteRegion(){
        return "";
    }
}
