package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWareHouseDto {

    private Integer userId;
    private Integer wareHouseId;
}
