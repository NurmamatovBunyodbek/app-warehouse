package uz.pdp.appwarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

private String massage;
private Boolean success;
private Object object;

    public Result(String massage, Boolean success) {
        this.massage = massage;
        this.success = success;
    }
}
