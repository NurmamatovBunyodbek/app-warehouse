package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Measurement;

public interface MeasurementRepo extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);
}
