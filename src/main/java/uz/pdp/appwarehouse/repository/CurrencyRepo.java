package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.Currency;

public interface CurrencyRepo extends JpaRepository<Currency,Integer> {

}
