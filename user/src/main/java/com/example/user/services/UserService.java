package com.example.user.services;

import com.example.user.entities.User;

import java.util.List;

public interface UserService {

//    Create User
    User createUser (User user);
//    Get Single User By Id
    User getSingleUser (Long id);
//    Get All User
    List<User> getAllUser();
//    Update User
    User updateUser (User user, Long id);
//    Delete User
    void deleteById (Long id);
}
