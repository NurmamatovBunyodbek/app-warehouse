package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.SupplierService;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.model.SupplierDto;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSupplierlist(){
        List<Supplier> suppliers = supplierService.supplierList();
         return  suppliers;
    }
    @GetMapping("/{id}")
    public  Supplier getSupplier(@PathVariable Integer id){
        return supplierService.getSupplierId(id);
    }
    @PostMapping
    public  Result addSupplier(@RequestBody SupplierDto supplierDto){
        Result result = supplierService.addSupplier(supplierDto);
        return result;
    }
    @PutMapping("/{id}")
    public  Result updateSubblier(@PathVariable Integer id , @RequestBody SupplierDto supplierDto){
        Result result = supplierService.editingSupplier(id, supplierDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedId(@PathVariable Integer id){
        return supplierService.deletedSupplier(id);
    }

}
