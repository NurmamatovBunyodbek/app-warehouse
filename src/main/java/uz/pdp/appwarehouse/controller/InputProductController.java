package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.InputProductService;
import uz.pdp.appwarehouse.model.InputProductDto;
import uz.pdp.appwarehouse.model.Result;

@RestController
@RequestMapping ("/inputProduct")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;


    @GetMapping
    public Result allInputProduct(){
        Result inputProduct = inputProductService.getInputProduct();
        return inputProduct;
    }

    @PostMapping
     public  Result addInputProduct(@RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.addInputProduct(inputProductDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateInputProduct(@PathVariable Integer id , @RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.updateInputProduct(id, inputProductDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public  Result deleted(@PathVariable Integer id){
        Result result = inputProductService.deletedInputProduct(id);
        return result;
    }
}
