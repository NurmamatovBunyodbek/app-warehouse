package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.model.CategoryDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        Optional<Category> byId = categoryRepo.findById(categoryDto.getParent_category_id());
        if (byId.isPresent()) {
            category.setParentCategory(byId.get());
        }
        category.setActive(categoryDto.getActive());
        categoryRepo.save(category);
        return new Result("Category qo'shildi", true);
    }

    public List<Category> getCategoryList() {
        List<Category> all = categoryRepo.findAll();
        return all;

    }

    public Category getCategoryId(Integer id) {
        Optional<Category> byId = categoryRepo.findById(id);
        return byId.get();
    }

    public Result deletedCategory(Integer id) {
        categoryRepo.deleteById(id);

        return new Result("Categoriya o'chirildi", true);

    }

    public Result putCategory(Integer id, CategoryDto categoryDto) {

        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            Optional<Category> byId = categoryRepo.findById(categoryDto.getParent_category_id());
            category.setParentCategory(byId.get());
            if (categoryOptional.isPresent()) {
                category.setParentCategory(categoryOptional.get());

            }
            category.setActive(categoryDto.getActive());
            categoryRepo.save(category);
            return new Result("Categoryiga qoshildi ", true);

        }
        return new Result("Categoryiga qoshilmadi", false);
    }

}
