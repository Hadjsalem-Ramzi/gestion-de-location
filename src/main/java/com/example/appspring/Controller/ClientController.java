package com.example.appspring.Controller;

import com.example.appspring.Services.ClientServiceImp;
import com.example.appspring.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ClientController {
    @Autowired
    private ClientServiceImp clientServiceImp;
/*

    @GetMapping("/getone/{Nom}")
    public Client getoneclient(@PathVariable("Nom") String nom) {
        return clientServiceImp.getClientByNom(nom);
    }

    @GetMapping("/all")
    public List<Client> getallClient() {
        return clientServiceImp.getAllClient();
    }


    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @RequestBody Client client) {

        Client cl = clientServiceImp.getClientByID(id);
        if (cl!= null) {
            client.setId(id);
            clientServiceImp.updateClient(client);
            return "update";
        } else {
            throw new RuntimeException("Failed");
        }

    }
@RequestMapping(value= "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client")Client client){
        clientServiceImp.createClient(client);
        return "redirect:/";
}
@GetMapping("delete/{id}")
    public void deleteVoiture(@PathVariable("id") long id){

               clientServiceImp.deleteClient(id);

}
*/
// Façon Thymleaf

    @RequestMapping("/addClient")
    public String addClient(Model model) {
       Client client=new Client();
       model.addAttribute("ClientForm",client);
       return "new_client";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  String saveClient(@ModelAttribute("ClientForm") Client client){
        clientServiceImp.createClient(client);
        return "redirect:/all";
    }

    @RequestMapping("/all")
    public String ListClients(Model model){
        List<Client> listClients = clientServiceImp.getAllClient();
        model.addAttribute("ListClients",listClients);

        return "liste_clients";
    }

@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Model model){
        Client client=clientServiceImp.getClientByID(id);
        model.addAttribute("client",client);
        return "update_client";
}

@PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id, @Validated Client client, BindingResult result,Model model){
        if(result.hasErrors()) {
            client.setId(id);
            return "update_client";
        }

        clientServiceImp.createClient(client);
        model.addAttribute("listClients", clientServiceImp.getAllClient());
         return "redirect:/all";
    }

  @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable("id") long id){
        clientServiceImp.deleteClient(id);
        return "redirect:/all";
  }




}












