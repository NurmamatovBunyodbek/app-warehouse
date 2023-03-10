package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.ProductService;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.model.ProductDto;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProductAll(){
        List<Product> products = productService.getproductList();
        return products;
    }
    @GetMapping("/{id}")
    public Result getProduct(@PathVariable Integer id){
        return productService.getProductId(id);
    }
    @PostMapping
    public  Result addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }
    @PutMapping("/{id}")
    public  Result updateProduct(@PathVariable Integer id , @RequestBody ProductDto productDto){
        Result result = productService.updateProduct(id, productDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedProduct(@PathVariable Integer id){
        return productService.deletedProduct(id);
    }


}
