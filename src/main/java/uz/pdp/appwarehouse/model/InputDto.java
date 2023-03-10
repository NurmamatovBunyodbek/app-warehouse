package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {

    private Integer wareHouseId;
    private Integer supplierId;
    private Integer currencyId;
    private String facture_number;
    private String code;

}
