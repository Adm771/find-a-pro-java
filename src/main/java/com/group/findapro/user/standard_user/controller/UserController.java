package com.group.findapro.user.standard_user.controller;


import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;


    // GET ALL USERS
    @GetMapping("users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException{
        return userService.getUserById(userId);
    }

    // ADD USER
    @PostMapping("users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    // UPDATE USER widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @RequestBody User userDetails) throws ResourceNotFoundException {

        return (this.userService.updateUser(userId, userDetails));
    }
    // DELETE USER
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        return userService.deleteUser(userId);
    }
}