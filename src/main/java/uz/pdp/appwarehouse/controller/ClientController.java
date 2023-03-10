package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.ClientService;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.model.ClientDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.ClientRepo;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

      @GetMapping
    public List<Client> clientList(){
          List<Client> clientList = clientService.getClient();
          return clientList;
      }
      @PostMapping
    public Result postClient(@RequestBody ClientDto clientDto){
          Result result = clientService.postClient(clientDto);
          return result;
      }
    @PutMapping("/{id}")
    public  Result  updateClient(@PathVariable Integer id , @RequestBody ClientDto clientDto){
        Result result = clientService.updateClient(id, clientDto);
      return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedClient(@PathVariable Integer id){
          clientService.deletedClient(id);
          return new Result("Client deleted" ,true);
    }

}
