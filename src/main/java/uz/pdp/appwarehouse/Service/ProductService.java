package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.model.ProductDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    MeasurementService measurementService;

     public Result addProduct(ProductDto productDto){
         Product product = new Product();
        product.setName(productDto.getName());
         Category categoryId = categoryService.getCategoryId(productDto.getCategoryId());
           product.setCategory(categoryId);
         Attachment fileId = attachmentService.getFileId(productDto.getPhotoId());
       if (fileId==null){
           return  new Result("File not found",false);
       }

       product.setAttachment(fileId);
         Random random = new Random();
         String random1 = random.getRandom();
         product.setCode(random1);
         Measurement measurement = measurementService.getMeasurement(productDto.getMeasurementId());
           product.setMeasurement(measurement);
           productRepo.save(product);
           return new Result("Product Added",true);
     }

   public  Result updateProduct(Integer id , ProductDto productDto){
       Optional<Product> optionalProduct = productRepo.findById(id);
       if (optionalProduct.isPresent()){
           Product product = optionalProduct.get();
           product.setName(productDto.getName());
           Category categoryId = categoryService.getCategoryId(productDto.getCategoryId());
           product.setCategory(categoryId);
           Attachment fileId = attachmentService.getFileId(productDto.getPhotoId());
          if (fileId == null){
                return  new Result("File not found",false);
          }

          product.setAttachment(fileId);
           Random random = new Random();
           String random1 = random.getRandom();
           product.setCode(random1);

           Measurement measurement = measurementService.getMeasurement(productDto.getMeasurementId());
           product.setMeasurement(measurement);
           productRepo.save(product);
            return new Result("Product updated",true);
       }
       return new Result("Product not found", false);
   }


     public List<Product>  getproductList(){
         List<Product> all = productRepo.findAll();
         return all;
     }
     public  Result getProductId(Integer id){
         Optional<Product> optionalProduct = productRepo.findById(id);
         Product product = optionalProduct.get();
         return new Result("Product id boyicha olish",true,product);
     }

     public  Result deletedProduct(Integer id){
         productRepo.deleteById(id);
         return new Result("Product deleted",true);
     }
}
