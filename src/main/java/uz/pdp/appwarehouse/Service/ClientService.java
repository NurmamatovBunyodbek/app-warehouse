package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.model.ClientDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.ClientRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

   public List<Client> getClient()
   {
       List<Client> all = clientRepo.findAll();
       return all;
   }

   public Result postClient(ClientDto clientDto){
       List<Client> client =getClient();
       Stream<Boolean> stream = client.stream().map(client1 -> client1.getPhoneNumber().equals(clientDto.getPhoneNumber()));
       List<Boolean> booleans =stream.toList();
       int count=0;
       for (Boolean  aBoolean :booleans) {
      if (aBoolean){
          count++;
      }
       }
   if (count==0){
       Client client1 = new Client();
       client1.setName(clientDto.getName());
         client1.setPhoneNumber(clientDto.getPhoneNumber());
         clientRepo.save(client1);

          return new Result("Client qo'shildi",true);
   }
   return new Result("Client qo'shilmadi ",false);

   }

    public Result updateClient(Integer id, ClientDto clientDto){
        Optional<Client> optionalClient = clientRepo.findById(id);
         if (optionalClient.isPresent()){
             Client client = optionalClient.get();
            client.setName(clientDto.getName());
            client.setPhoneNumber(clientDto.getPhoneNumber());
          clientRepo.save(client);
            return new Result("Client o'zgartirildi",true);
         }
         return new Result("O'zgartirilmadi",false);
    }

   public Result deletedClient(Integer id){
          clientRepo.deleteById(id);
           return new Result("O'chirildi",true);
   }


}
