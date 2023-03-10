package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.CategoryService;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.model.CategoryDto;
import uz.pdp.appwarehouse.model.Result;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
 public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result category = categoryService.addCategory(categoryDto);
        return category;
    }
    @GetMapping
    public List<Category> getCategory(){
        List<Category> categoryList = categoryService.getCategoryList();
        return categoryList;
    }
    @GetMapping("/{id}")
    public  Category getCategoryId(@PathVariable Integer id){
        Category categoryId = categoryService.getCategoryId(id);
        return categoryId;
    }

   @PutMapping("{id}")
    public  Result putCategory(@PathVariable Integer id , @RequestBody CategoryDto categoryDto){
       Result result = categoryService.putCategory(id, categoryDto);
       return result;
   }

   @DeleteMapping("{id}")
    public  Result deletedCategoryId(@PathVariable Integer id){
        categoryService.deletedCategory(id);
        return new Result("Category deleted" ,true);
   }



}
