package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

   Supplier findByNameOrPhoneNumber(String name, String phoneNumber);

}
