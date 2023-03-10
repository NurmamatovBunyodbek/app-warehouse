package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.WareHouseService;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @GetMapping
    public List<WareHouse> wareHouseList(){
        List<WareHouse> wareHouses = wareHouseService.wareHouseList();
        return wareHouses;
    }
    @GetMapping("/{id}")
    public  WareHouse getWareHouse(@PathVariable Integer id){
        WareHouse wareHouseId = wareHouseService.getWareHouseId(id);
        return wareHouseId;
    }
    @PostMapping
    public Result addWareHouse(@RequestBody WareHouse wareHouseDto){
        Result result = wareHouseService.addWareHouse(wareHouseDto);
        return result;

    }
    @PutMapping("/{id}")
    public  Result editingWareHouse(@PathVariable Integer id , @RequestBody WareHouse wareHouseDto){
        Result result = wareHouseService.editingWareHouse(id, wareHouseDto);return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedWareHouse(@PathVariable Integer id){
        Result result = wareHouseService.deletedWareHouse(id);return result;
    }

}
