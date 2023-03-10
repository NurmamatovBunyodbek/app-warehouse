package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {

    private Integer wareHouseId;
    private Integer currencyId;
    private String facture_number;
    private String code;
    private Integer clientId;


}
