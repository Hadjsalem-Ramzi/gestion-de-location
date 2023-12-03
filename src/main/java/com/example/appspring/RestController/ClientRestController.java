package com.example.appspring.RestController;

import com.example.appspring.Entity.Client;
import com.example.appspring.Services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestController {
    @Autowired
    private ClientServiceImp clientServiceImp;

    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client){
        return  clientServiceImp.createClient(client);
    }
  @PostMapping("/save2")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        try {
            clientServiceImp.createClient(client);
            return new ResponseEntity<Client>(client,HttpStatus.CREATED);
        }catch(Exception e){
         return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
@GetMapping("/all")
    public List<Client> getallClient(){
        return  clientServiceImp.getAllClient();
}

@GetMapping("/all2")
    public ResponseEntity<List<Client>> getAllClients(){
        try{
            List<Client> clients= clientServiceImp.getAllClient();
            if(clients.isEmpty()){
                return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
            }
             return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}

@GetMapping("/getone/{id}")
public Client getoneClient(@PathVariable Long id){
        return  clientServiceImp.getClientByID(id);
}


@GetMapping("/clients/{id}")
public ResponseEntity<Client>getClientById(@PathVariable("id") long id){
        Client client=clientServiceImp.getClientByID(id);
        if(client!= null){
            return new ResponseEntity<Client>(client,HttpStatus.OK);
        } else {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
}
@PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Long id,@RequestBody Client client){
        Client c1=clientServiceImp.getClientByID(id);
        if(c1!=null){
            client.setId(id);
            return clientServiceImp.updateClient(client);
        } else {
            throw new RuntimeException("Failed");
        }
}

@DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteClient(@PathVariable Long id){
        HashMap<String,String> message= new HashMap<>();
        if(clientServiceImp.getClientByID(id)==null){
            message.put("etat","client not Found");
            return  message;
        }

        try{
            clientServiceImp.deleteClient(id);
            message.put("etat","client delete");
            return  message;
        }catch(Exception e){
            message.put("etat","client not deleted");
            return  message;
    }


}


}
