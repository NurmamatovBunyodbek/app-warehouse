package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProductDto {

    private Integer productId;
    private Double amount;
    private Double price;
    private Integer outputId;

}
