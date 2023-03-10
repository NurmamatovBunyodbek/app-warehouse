package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.WareHouse;

public interface WareHouseRepo extends JpaRepository<WareHouse,Integer> {


    Boolean deleteWarehouseById(Integer id);

}
