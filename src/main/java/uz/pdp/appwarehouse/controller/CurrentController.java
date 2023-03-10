package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.CurrencyService;
import uz.pdp.appwarehouse.model.CurrentDto;
import uz.pdp.appwarehouse.model.Result;

@RestController
@RequestMapping("/currency")
public class CurrentController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping
      public Result getAll(){
          Result currencyAll = currencyService.getCurrencyAll();
          return currencyAll;
      }
      @GetMapping("/{id}")
    public  Result getCurrencyId(@PathVariable Integer id){
          Result currencyId =
                  currencyService.getCurrencyId(id);
      return currencyId;
    }

   @PostMapping
    public  Result addCurrency(@RequestBody CurrentDto currentDto){
       Result result = currencyService.addCurrency(currentDto);
       return result;
   }
     @PutMapping("/{id}")
    public  Result updateCurrency(@PathVariable Integer id , @RequestBody CurrentDto currentDto){

         Result result = currencyService.updateCurrency(id, currentDto);
         return result;

     }

     @DeleteMapping("/{id}")
    public Result deletedCurrency(@PathVariable Integer id){
         Result result = currencyService.deletedCurrency(id);
         return result;
     }



}
