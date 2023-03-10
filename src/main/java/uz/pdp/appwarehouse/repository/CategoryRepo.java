package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {


}
