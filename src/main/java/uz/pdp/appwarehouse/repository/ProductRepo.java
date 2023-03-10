package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
