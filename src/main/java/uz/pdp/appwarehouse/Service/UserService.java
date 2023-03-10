package uz.pdp.appwarehouse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.entity.WareHouse;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.model.UserDto;
import uz.pdp.appwarehouse.repository.UserRepo;
import uz.pdp.appwarehouse.repository.WareHouseRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    WareHouseRepo wareHouseRepo;

     public List<User> getUsers(){
         List<User> all = userRepo.findAll();
         return all;
     }

     public  User getUserId(Integer id){
         Optional<User> optionalUser = userRepo.findById(id);
         return optionalUser.get();
     }

  public Result addUser(UserDto userDto){
      Random random = new Random();
      String random1 = random.getRandom();
      Optional<WareHouse> optionalWareHouse = wareHouseRepo.findById(userDto.getWareHouseId());
      User user = new User();
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setPhoneNumber(userDto.getPhoneNumber());
      user.setCode(random1);
      user.setActive(userDto.getActive());
      user.setPassword(userDto.getPassword());
      HashSet<WareHouse> wareHouseHashSet = new HashSet<>();

      wareHouseHashSet.add(optionalWareHouse.get());
      userRepo.save(user);
      if (user!=null){
            return  new Result("Added user",true);
      }
      return new Result("User not found",false);
     }

     public Result editUser(Integer id , UserDto userDto){
         Optional<User> optionalUser = userRepo.findById(id);
         if (optionalUser.isPresent()){
             Optional<WareHouse> houseOptional = wareHouseRepo.findById(userDto.getWareHouseId());
             User user = optionalUser.get();
             user.setFirstName(userDto.getFirstName());
             user.setLastName(userDto.getLastName());
             user.setPhoneNumber(userDto.getPhoneNumber());
             user.setPassword(userDto.getPassword());
             user.setActive(userDto.getActive());
             HashSet<WareHouse> wareHouseHashSet = new HashSet<>();
               wareHouseHashSet.add(houseOptional.get());
               user.setWareHouses(wareHouseHashSet);
               userRepo.save(user);
               return new Result("editing User",true);
         }
         return new Result("User not found",false);
     }

     public Result deletedUser(Integer id){
            userRepo.deleteById(id);
            return new Result("User deleted",true);
     }

}
