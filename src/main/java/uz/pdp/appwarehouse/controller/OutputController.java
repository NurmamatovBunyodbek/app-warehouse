package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.OutputService;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.model.OutputDto;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService outputService;

    @GetMapping
    public List<Output> outputList(){
        List<Output> outputList = outputService.outputList();
        return outputList;
    }

    @PostMapping
    public Result addOutput(@RequestBody OutputDto outputDto){
        return outputService.addOutput(outputDto);
    }
    @PutMapping("/{id}")
    public Result updateOutput(@PathVariable Integer id , @RequestBody OutputDto outputDto){

        Result result = outputService.updateOutput(id, outputDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer  id){
        Result result = outputService.deletedOutput(id);
        return result;
    }


}
