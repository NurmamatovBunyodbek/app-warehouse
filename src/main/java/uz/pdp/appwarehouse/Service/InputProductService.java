package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.model.InputProductDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.InputProductRepo;
import uz.pdp.appwarehouse.repository.InputRepo;
import uz.pdp.appwarehouse.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    InputProductRepo inputProductRepo;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    InputRepo inputRepo;

    public Result getInputProduct() {
        List<InputProduct> all = inputProductRepo.findAll();
        return new Result("InputProduct List", true, all);
    }

    public Result addInputProduct(InputProductDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();
        Optional<Product> optional = productRepo.findById(inputProductDto.getInputId());
        inputProduct.setProduct(optional.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());
        Optional<Input> inputOptional = inputRepo.findById(inputProductDto.getProductId());
        inputProduct.setInput(inputOptional.get());
        return new Result("Qo'shildi", true);
    }

    public Result updateInputProduct(Integer id, InputProductDto inputProductDto) {
        Optional<InputProduct> byId = inputProductRepo.findById(id);
        if (byId.isPresent()) {
            InputProduct inputProduct = byId.get();
            Optional<Product> optionalProduct = productRepo.findById(inputProductDto.getInputId());
            inputProduct.setProduct(optionalProduct.get());
            inputProduct.setAmount(inputProductDto.getAmount());
            inputProduct.setPrice(inputProductDto.getPrice());
            inputProduct.setExpireDate(inputProductDto.getExpireDate());
            Optional<Input> optionalInput = inputRepo.findById(inputProductDto.getInputId());
            inputProduct.setInput(optionalInput.get());
            return new Result("O'zgartirildi", true);
        }
        return new Result("InputProduct not found", false);
    }

    public Result deletedInputProduct(Integer id) {
        inputProductRepo.deleteById(id);
        return new Result("InputProduct deleted", true);
    }

}
