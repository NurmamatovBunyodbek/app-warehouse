package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.model.InputDto;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepo;
import uz.pdp.appwarehouse.repository.InputRepo;
import uz.pdp.appwarehouse.repository.SupplierRepo;
import uz.pdp.appwarehouse.repository.WareHouseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepo inputRepo;
    @Autowired
    WareHouseRepo wareHouseRepo;
    @Autowired
    SupplierRepo supplierRepo;
    @Autowired
    CurrencyRepo currencyRepo;

    public List<Input> getInput() {
        List<Input> inputList = inputRepo.findAll();
        return inputList;
    }

    public Result addInput(InputDto inputDto) {
        Input input = new Input();
        Random random = new Random();
        input.setDate(random.getDateNow());
        Optional<WareHouse> houseOptional = wareHouseRepo.findById(inputDto.getWareHouseId());
        input.setWareHouse(houseOptional.get());
        Optional<Supplier> supplierOptional = supplierRepo.findById(inputDto.getSupplierId());
        input.setSupplier(supplierOptional.get());
        Optional<Currency> currencyOptional = currencyRepo.findById(inputDto.getCurrencyId());
        input.setCurrency(currencyOptional.get());
        input.setFactureNumber(inputDto.getFacture_number());
        input.setCode(random.getRandom());
        inputRepo.save(input);
        return new Result("Added", true);
    }

    public Result updateInput(Integer id, InputDto inputDto) {
        Optional<Input> inputOptional = inputRepo.findById(id);
        if (inputOptional.isPresent()) {
            Input input = inputOptional.get();
            Random random = new Random();
            input.setDate(random.getDateNow());
            Optional<WareHouse> optionalWareHouse = wareHouseRepo.findById(inputDto.getWareHouseId());

            input.setWareHouse(optionalWareHouse.get());
            Optional<Supplier> optionalSupplier = supplierRepo.findById(inputDto.getSupplierId());
            input.setSupplier(optionalSupplier.get());
            Optional<Currency> optionalCurrency = currencyRepo.findById(inputDto.getCurrencyId());
            input.setCurrency(optionalCurrency.get());
            input.setFactureNumber(inputDto.getFacture_number());
            input.setCode(random.getRandom());
            inputRepo.save(input);
            return new Result("Update Input", true);
        }
        return new Result("Input not found", false);
    }

    public Result deletedInput(Integer id) {
        inputRepo.deleteById(id);
        return new Result("Input deleted", true);
    }
}
