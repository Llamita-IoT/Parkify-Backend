package pe.upc.edu.parkifybackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.parkifybackend.models.UserModel;
import pe.upc.edu.parkifybackend.services.UserService;

import java.util.ArrayList;

@RestController
@RequestMapping("/owners")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUser(){
        return userService.getUser();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Owner with id: " + id + " was deleted";
        }else{
            return "Can´t delete owner with id: " + id;
        }
    }

}