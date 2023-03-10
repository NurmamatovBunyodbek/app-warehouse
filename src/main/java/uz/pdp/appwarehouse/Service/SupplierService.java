package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.model.SupplierDto;
import uz.pdp.appwarehouse.repository.SupplierRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepo supplierRepo;

    public List<Supplier> supplierList(){
        List<Supplier> supplierList = supplierRepo.findAll();
        return supplierList;
    }
    public  Supplier getSupplierId(Integer id){
        Optional<Supplier> optionalSupplier = supplierRepo.findById(id);
        return optionalSupplier.get();
    }

    public Result addSupplier(SupplierDto supplierDto){
        Supplier aboolean = checkSupplier(supplierDto);
       if (aboolean == null){
           Supplier supplier = new Supplier();
           supplier.setName(supplierDto.getName());
           supplier.setPhoneNumber(supplierDto.getPhoneNumber());
          supplier.setActive(supplierDto.getActive());
           Supplier save = supplierRepo.save(supplier);
           return new Result("Added" + save.getName(),true);

       }

        return new Result("Qo'shildi",false);
    }

    private Supplier checkSupplier(SupplierDto supplierDto){
        return supplierRepo.findByNameOrPhoneNumber(supplierDto.getName(), supplierDto.getPhoneNumber());
    }

    public Result editingSupplier(Integer id , SupplierDto supplierDto){
        Optional<Supplier> optionalSupplier = supplierRepo.findById(id);
        if (optionalSupplier.isPresent()){
            Supplier supplier = optionalSupplier.get();
             supplier.setName(supplierDto.getName());
             supplier.setPhoneNumber(supplierDto.getPhoneNumber());
             supplier.setActive(supplierDto.getActive());
            Supplier save = supplierRepo.save(supplier);
           return  new Result("Update Supplier"+save.getName() , true);
        }
        return new Result("Supplier not found",false);
    }

    public  Result deletedSupplier(Integer id){
        supplierRepo.deleteById(id);
        return new Result("Deleted supplier",true);
    }

}
