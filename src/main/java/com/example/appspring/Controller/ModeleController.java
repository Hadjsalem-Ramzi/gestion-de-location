package com.example.appspring.Controller;

import com.example.appspring.Services.ModeleServiceImp;
import com.example.appspring.Entity.Modele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ModeleController {

    @Autowired
    private ModeleServiceImp modeleServiceImp;

    @RequestMapping("/addModele")
    public String addModels(Model model) {

        Modele models=new Modele();
        model.addAttribute("ModelsForm",models);
        return "new_Modele";
    }

    @RequestMapping(value = "/savemodele",method = RequestMethod.POST)
    public  String saveModele(@ModelAttribute("ModelsForm") Modele modele){
        modeleServiceImp.createModele(modele);
        return "redirect:/allModele";
    }

    @RequestMapping("/allModele")
    public String ListModele(Model model){
        List<Modele> listModels = modeleServiceImp.getAllModele();
        model.addAttribute("ListModele",listModels);

        return "liste_models";
    }

    @GetMapping("editmodel/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Modele modele=modeleServiceImp.getModeleByID(id);
        model.addAttribute("modele",modele);
        return "update_Modele";
    }

    @PostMapping("updatemodel/{id}")
    public String updateModele(@PathVariable("id") long id, @Validated Modele modele, BindingResult result, Model model){
        if(result.hasErrors()) {
            modele.setId(id);
            return "update_Modele";
        }

        modeleServiceImp.createModele(modele);
        model.addAttribute("listModele", modeleServiceImp.getAllModele());
        return "redirect:/allModele";
    }

    @GetMapping("deletemodel/{id}")
    public String deleteModele(@PathVariable("id") long id,Model model) {
        modeleServiceImp.deleteModele(id);
        //model.addAttribute("listModele", modeleServiceImp.getAllModele());
        return "redirect:/allModele";

    }
}
