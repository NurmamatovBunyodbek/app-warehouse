package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String name;
    private String phoneNumber;
}
