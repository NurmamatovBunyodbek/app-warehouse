package uz.pdp.appwarehouse.Service;

import org.hibernate.type.descriptor.jdbc.InstantAsTimestampWithTimeZoneJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepo measurementRepo;

    public Result addMeasurement(Measurement measurement){
        boolean exists = measurementRepo.existsByName(measurement.getName());

     if (exists){
             return new Result("Bunday o'lchov birligi mavjud",false);
     }
             return new Result("O'lchov birligi qo'shildi",true);
    }

    public List<Measurement> getmeasurementList(){
        List<Measurement> measurementList = measurementRepo.findAll();

        return measurementList;
    }

    public Measurement getMeasurement(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepo.findById(id);
          return optionalMeasurement.get();
    }

 public Result deletedMeasurement(Integer id){
        measurementRepo.deleteById(id);
        return new Result("Measurement deleted " ,true);
 }


public Result updateMeasurement(Integer id,Measurement measurement){
    Optional<Measurement> optionalMeasurement = measurementRepo.findById(id);
    if (optionalMeasurement.isPresent()){
        Measurement measurement1 = optionalMeasurement.get();
        if (measurement.getName().length()!=0){
            measurement1.setName(measurement.getName());
        }
        measurement1.setActive(measurement.isActive());
          measurementRepo.save(measurement1);
          return new Result("Update Measurement" , true);
    }
    return new Result("Measurement not fount",false);
}

}
