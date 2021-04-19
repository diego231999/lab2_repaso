package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
        return "regions/form";
    }

    @PostMapping("/save")
    public String saveRegino(Region region){
        regionRepository.save(region);
        return "redirect:/region/list";
    }

    @GetMapping("/edit")
    public String editRegion(@RequestParam("id") int id,
                             Model model){
        Optional<Region> regionOptional = regionRepository.findById(id);
        if(regionOptional.isPresent()){
            Region region = regionOptional.get();
            model.addAttribute("region",region);
            return "/regions/edit";
        }else {
            return "redirect:/region/list";
        }
    }

    @GetMapping("/delete")
    public  String deleteRegion(@RequestParam("id") int id){
        Optional<Region> regionOpt = regionRepository.findById(id);
        if(regionOpt.isPresent()){
            regionRepository.deleteById(id);
        }
        return "redirect:/region/list";
    }


    @PostMapping("/search")
    public  String searchRegion(@RequestParam("searchName") String txt,
                                RedirectAttributes attr,
                                Model model){
        List<Region> list = regionRepository.findByRegiondescriptionContainingOrderByRegiondescriptionDesc(txt);

        if(list.isEmpty()){
            attr.addFlashAttribute("msg","No hay anda gil");
            return "redirect:/region/list";
        }else{
            model.addAttribute("lista",list);
            return "/regions/lista";
        }


    }
}
