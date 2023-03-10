package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.InputService;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.model.InputDto;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/input")

public class InputController {

    @Autowired
    InputService inputService;

    @GetMapping
    public List<Input> getList(){
        List<Input> inputList = inputService.getInput();
        return inputList;
    }

    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        Result result = inputService.addInput(inputDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateInput(@PathVariable Integer id , @RequestBody InputDto inputDto){
        Result result = inputService.updateInput(id, inputDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedInput(@PathVariable Integer id){
        Result result = inputService.deletedInput(id);
        return result;
    }


}
