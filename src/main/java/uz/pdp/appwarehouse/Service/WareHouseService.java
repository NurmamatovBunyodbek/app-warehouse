package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.WareHouseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService {

    @Autowired
    WareHouseRepo wareHouseRepo;

    public List<WareHouse > wareHouseList(){
        List<WareHouse> wareHouseList = wareHouseRepo.findAll();
        return wareHouseList;
    }
    public  WareHouse getWareHouseId(Integer id ){
        Optional<WareHouse> optionalWareHouse = wareHouseRepo.findById(id);
        return optionalWareHouse.get();
    }

    public Result addWareHouse(WareHouse wareHouseDto){
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(wareHouseDto.getName());
        wareHouse.setActive(wareHouseDto.isActive());
        wareHouseRepo.save(wareHouse);
        return new Result("Added WareHouse",true);
    }

    public  Result editingWareHouse(Integer id , WareHouse wareHouseDto){
        Optional<WareHouse> houseOptional = wareHouseRepo.findById(id);
        if (houseOptional.isPresent()){
            WareHouse wareHouse = houseOptional.get();
            wareHouse.setName(wareHouseDto.getName());
            wareHouse.setActive(wareHouseDto.isActive());
            wareHouseRepo.save(wareHouse);
            return new Result("Editing WareHouse",true);
        }
        return new Result("WareHouse not found",false);
    }

    public  Result deletedWareHouse(Integer id){
        Boolean aBoolean = wareHouseRepo.deleteWarehouseById(id);
        return new Result("Deleted",aBoolean);
    }
}
