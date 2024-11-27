package com.example.user.controller;

import com.example.user.entities.User;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/generate") //URL: http://localhost:8081/api/users/generate
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1= userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{id}") //URL: http://localhost:8081/api/users/{001}
    public ResponseEntity<User> getSingleUser(@PathVariable Long id){
        User singleUser = userService.getSingleUser(id);
        return ResponseEntity.ok(singleUser);
    }

    @GetMapping("/allUsers") //URL: http://localhost:8081/api/users/allUsers
    public ResponseEntity<List> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @PutMapping("/{id}") //URL: http://localhost:8081/api/users/{001}
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        User UpdateUser = userService.updateUser(user, id);
        return new ResponseEntity<>(UpdateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //URL: http://localhost:8081/api/users/{001}
   public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity<>("user deleted: ", HttpStatus.OK);
   }
}
