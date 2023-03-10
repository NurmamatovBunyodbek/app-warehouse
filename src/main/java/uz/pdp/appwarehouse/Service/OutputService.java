package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.model.OutputDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.ClientRepo;
import uz.pdp.appwarehouse.repository.CurrencyRepo;
import uz.pdp.appwarehouse.repository.OutputRepo;
import uz.pdp.appwarehouse.repository.WareHouseRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    OutputRepo outputRepo;

    @Autowired
    WareHouseRepo wareHouseRepo;
    @Autowired
    CurrencyRepo currencyRepo;
    @Autowired
    ClientRepo clientRepo;


    public List<Output> outputList() {
        List<Output> all = outputRepo.findAll();
        return all;
    }

    public Result addOutput(OutputDto outputDto) {

        Output output = new Output();
        LocalDateTime dateCheck = getDateCheck(outputDto);
        Timestamp timestamp = Timestamp.valueOf(dateCheck);
        output.setDate(timestamp);
        Optional<WareHouse> optionalWareHouse = wareHouseRepo.findById(outputDto.getWareHouseId());
        output.setWareHouse(optionalWareHouse.get());
        Optional<Currency> optionalCurrency = currencyRepo.findById(outputDto.getCurrencyId());
        output.setCurrency(optionalCurrency.get());
        output.setFactureNumber(outputDto.getFacture_number());
        Random random = new Random();
        output.setCode(random.getRandom());
        Optional<Client> optionalClient = clientRepo.findById(outputDto.getClientId());
        output.setClient(optionalClient.get());
      return new Result("Qo'shildi",true);

    }

    private LocalDateTime getDateCheck(OutputDto outputDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }


    public  Result updateOutput(Integer id , OutputDto outputDto){
        Optional<Output> optionalOutput = outputRepo.findById(id);
         if (optionalOutput.isPresent()){
             Output output = optionalOutput.get();
             Date date = new Date();
             LocalDateTime dateCheck = getDateCheck(outputDto);
             Timestamp timestamp = Timestamp.valueOf(dateCheck);
             output.setDate(timestamp);
             Optional<WareHouse> wareHouseOptional = wareHouseRepo.findById(outputDto.getWareHouseId());
             output.setWareHouse(wareHouseOptional.get());
             Optional<Currency> currencyOptional = currencyRepo.findById(outputDto.getCurrencyId());
             output.setCurrency(currencyOptional.get());
             output.setFactureNumber(outputDto.getFacture_number());
             Random random = new Random();
             output.setCode(random.getRandom());
             Optional<Client> clientOptional = clientRepo.findById(outputDto.getClientId());
             output.setClient(clientOptional.get());
             return new Result("Output update",true);
         }
         return new Result("Not Found",false);
    }


    public  Result deletedOutput(Integer id){
        outputRepo.deleteById(id);
        return  new Result("Output deleted" , true);
    }


}
