package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.MeasurementService;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;


    @GetMapping
    public List<Measurement> measurementList()
    {
        List<Measurement> measurements = measurementService.getmeasurementList();
        return measurements;
    }
    @GetMapping("/{id}")
    public Measurement getId(@PathVariable Integer id){
        Measurement measurement = measurementService.getMeasurement(id);
        return measurement;
    }
    @PostMapping
    public  Result addMeasurement(@RequestBody Measurement measurement){
        Result result = measurementService.addMeasurement(measurement);
        return result;
    }

    @PutMapping("/{id}")
    public  Result updateMeasurement(@PathVariable Integer id , @RequestBody Measurement measurement){

        Result result = measurementService.updateMeasurement(id, measurement);
        return result;

    }
    @DeleteMapping("/{id}")
    public  Result deletedMeasurement(@PathVariable Integer id){
        Result result = measurementService.deletedMeasurement(id);
        return result;
    }


}
