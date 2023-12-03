package com.example.appspring.RestController;
import com.example.appspring.Entity.Modele;
import com.example.appspring.Services.ModeleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/modele")
public class ModelesRestController {
    @Autowired
    private ModeleServiceImp modeleServiceImp;
    @PostMapping("/save")
    public Modele saveModele(@RequestBody Modele modele){
        return  modeleServiceImp.createModele(modele);
    }
    @PostMapping("/save2")
    public ResponseEntity<Modele> createModele(@RequestBody Modele modele){
        try {
            modeleServiceImp.createModele(modele);
            return new ResponseEntity<Modele>(modele, HttpStatus.CREATED);
        }catch(Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all")
    public List<Modele> getallModele(){
        return  modeleServiceImp.getAllModele();
    }

    @GetMapping("/all2")
    public ResponseEntity<List<Modele>> getAllModele(){
        try{
            List<Modele> modeles= modeleServiceImp.getAllModele();
            if(modeles.isEmpty()){
                return new ResponseEntity<List<Modele>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Modele>>(modeles,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Modele>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getone/{id}")
    public Modele getoneModele(@PathVariable Long id){
        return  modeleServiceImp.getModeleByID(id);
    }


    @GetMapping("/modeles/{id}")
    public ResponseEntity<Modele>getModeleById(@PathVariable("id") long id){
        Modele modele=modeleServiceImp.getModeleByID(id);
        if(modele!= null){
            return new ResponseEntity<Modele>(modele,HttpStatus.OK);
        } else {
            return new ResponseEntity<Modele>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public Modele updateModele(@PathVariable Long id,@RequestBody Modele modele){
        Modele c1=modeleServiceImp.getModeleByID(id);
        if(c1!=null){
            modele.setId(id);
            return modeleServiceImp.updateModele(modele);
        } else {
            throw new RuntimeException("Failed");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteModele(@PathVariable Long id){
        HashMap<String,String> message= new HashMap<>();
        if(modeleServiceImp.getModeleByID(id)==null){
            message.put("etat","modele not Found");
            return  message;
        }

        try{
            modeleServiceImp.deleteModele(id);
            message.put("etat","modele delete");
            return  message;
        }catch(Exception e){
            message.put("etat","modele not deleted");
            return  message;
        }


    }



}

