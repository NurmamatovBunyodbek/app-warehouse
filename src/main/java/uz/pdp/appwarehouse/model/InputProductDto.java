package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputProductDto {

    private Integer productId;
    private Double amount;
    private Double price;
    private Date expireDate;
    private String factureNumber;
    private Integer inputId;


}
