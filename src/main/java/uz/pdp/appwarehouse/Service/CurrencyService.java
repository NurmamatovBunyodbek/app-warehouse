package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.model.CurrentDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepo currencyRepo;

  public Result getCurrencyAll(){
      List<Currency> all = currencyRepo.findAll();
      return  new Result("Currency ro'yxat",true,all);
  }
  public Result getCurrencyId(Integer id){
      Optional<Currency> byId = currencyRepo.findById(id);
      return new Result("Currency id orqali :" ,true,byId.get());
  }

  public Result addCurrency(CurrentDto currentDto){
      Currency currency = new Currency();
      currency.setName(currentDto.getName());
       currency.setActive(currentDto.getActive());
       currencyRepo.save(currency);
     return new Result("Currency qo'shildi :)",true);
  }

  public Result updateCurrency(Integer id  , CurrentDto currentDto){
      Optional<Currency> optionalCurrency = currencyRepo.findById(id);
      if (optionalCurrency.isPresent()){
          Currency currency = optionalCurrency.get();
          currency.setName(currentDto.getName());
          currency.setActive(currentDto.getActive());
          currencyRepo.save(currency);
        return new Result("Currency o'zgartirildi",true);
      }
    return new Result("Currency not found",false);
  }

  public  Result deletedCurrency(Integer id){
      currencyRepo.deleteById(id);
      return  new Result("Currency deleted",true);
  }
}
