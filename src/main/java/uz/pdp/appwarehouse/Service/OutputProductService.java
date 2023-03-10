package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.model.OutputProductDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.OutputProductRepo;
import uz.pdp.appwarehouse.repository.OutputRepo;
import uz.pdp.appwarehouse.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepo outputProductRepo;

    @Autowired
    ProductRepo productRepo;
    @Autowired
    OutputRepo outputRepo;

    public List<OutputProduct> getAllList() {
        List<OutputProduct> all = outputProductRepo.findAll();
        return all;
    }

    public Result addOutputProduct(OutputProductDto outputProductDto) {
        OutputProduct outputProduct = new OutputProduct();
        Optional<Product> optionalProduct = productRepo.findById(outputProduct.getId());
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        Optional<Output> optionalOutput = outputRepo.findById(outputProductDto.getOutputId());
        outputProduct.setOutput(optionalOutput.get());
        outputProductRepo.save(outputProduct);
        return new Result("Added", true);

    }

    public Result updateOutputProduct(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepo.findById(id);
        if (optionalOutputProduct.isPresent()) {
            OutputProduct outputProduct = optionalOutputProduct.get();
            Optional<Product> optionalProduct = productRepo.findById(outputProductDto.getProductId());
            outputProduct.setProduct(optionalProduct.get());
            outputProduct.setPrice(outputProductDto.getPrice());
            outputProduct.setAmount(outputProductDto.getAmount());
            Optional<Output> optionalOutput = outputRepo.findById(outputProductDto.getOutputId());
            outputProduct.setOutput(optionalOutput.get());
            outputProductRepo.save(outputProduct);
            return new Result("Update outputProduct", true);

        }
        return new Result("OutputProduct not found", false);
    }

    public Result deletedOutputProduct(Integer id) {
        outputProductRepo.deleteById(id);
        return new Result("OutputProduct deleted", true);
    }


}
