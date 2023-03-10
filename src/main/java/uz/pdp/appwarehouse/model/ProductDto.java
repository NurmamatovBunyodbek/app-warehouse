package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private Integer categoryId;
    private Integer photoId;
    private String code;
    private boolean active = true;
    private Integer measurementId;

}
