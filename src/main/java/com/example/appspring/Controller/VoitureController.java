package com.example.appspring.Controller;


import com.example.appspring.Entity.Modele;
import com.example.appspring.Entity.Voiture;
import com.example.appspring.Services.ModeleServiceImp;
import com.example.appspring.Services.VoitureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VoitureController {
    @Autowired
    private VoitureServiceImp voitureServiceImp;
    @Autowired
    ModeleServiceImp modeleServiceImp;

    public VoitureController(VoitureServiceImp voitureServiceImp) {
        this.voitureServiceImp = voitureServiceImp;
    }

   @RequestMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        List<Modele>listeModele=modeleServiceImp.getAllModele();
        model.addAttribute("VoitureForm",voiture);
        model.addAttribute("ListeModel",listeModele);
        return "new_Voiture";
    }

    @RequestMapping(value = "/saveVoiture",method = RequestMethod.POST)
    public  String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture){
        voitureServiceImp.createVoiture(voiture);
        return "redirect:/allVoiture";
    }

    @RequestMapping("/allVoiture")
    public String ListVoiture(Model model){
        List<Voiture> listVoiture = voitureServiceImp.getAllVoiture();
        model.addAttribute("ListVoiture",listVoiture);

        return "liste_Voiture";
    }

    @GetMapping("editVoiture/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Voiture voiture=voitureServiceImp.getVoitureByID(id);
        model.addAttribute("voiture",voiture);
        return "update_Voiture";
    }

    @PostMapping("updateVoiture/{id}")
    public String updateVoiture(@PathVariable("id") long id, @Validated Voiture voiture, BindingResult result, Model model){
        if(result.hasErrors()) {
            voiture.setId(id);
            return "update_Voiture";
        }

        voitureServiceImp.createVoiture(voiture);
        model.addAttribute("listVoitures", voitureServiceImp.getAllVoiture());
        return "redirect:/allVoiture";
    }

    @GetMapping("deleteVoiture/{id}")
    public String deleteVoiture(@PathVariable("id") long id,Model model){
        voitureServiceImp.deleteVoiture(id);
        return "redirect:/allVoiture";
    }



}
