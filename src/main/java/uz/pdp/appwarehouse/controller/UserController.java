package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.Service.UserService;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.model.Result;
import uz.pdp.appwarehouse.model.UserDto;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return  userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        User userId = userService.getUserId(id);
        return userId;
    }

    @PostMapping
    public Result addUser(@RequestBody UserDto userDto){
        Result result = userService.addUser(userDto);
        return result;
    }
    @PutMapping("/{id}")
    public  Result editingUser(@PathVariable Integer id , @RequestBody UserDto userDto){
        Result result = userService.editUser(id, userDto);return result;
    }
    @DeleteMapping("/{id}")
    public  Result deletedUser(@PathVariable Integer id){
        Result result = userService.deletedUser(id);
        return result;
    }

}
