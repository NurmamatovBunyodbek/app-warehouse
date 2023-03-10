package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Client;

public interface ClientRepo extends JpaRepository<Client,Integer> {

}
