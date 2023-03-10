package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.OutputProductService;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.model.OutputProductDto;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

     @GetMapping
    public List<OutputProduct> getList(){
         List<OutputProduct> allList = outputProductService.getAllList();
         return allList;
     }

     @PostMapping
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto){
         Result result = outputProductService.addOutputProduct(outputProductDto);
         return result;
     }
     @PutMapping("/{id}")
    public  Result updateOutputProduct(@PathVariable Integer id , @RequestBody OutputProductDto outputProductDto){

         Result result = outputProductService.updateOutputProduct(id, outputProductDto);
         return result;
     }
     @DeleteMapping("/{id}")
    public  Result deletedOutputProduct(@PathVariable Integer id){
         Result result = outputProductService.deletedOutputProduct(id);
         return result;
     }
}
