package com.group.findapro.user.standard_user.controller;

import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.service.UserService;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET ALL USERS
    @GetMapping("users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    // ADD USER
    @PostMapping("users")
    public void createUser(@RequestBody User user) {
        this.userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @RequestBody User user) throws ResourceNotFoundException {
        user = userService.updateUser(userId, user);

        return ResponseEntity.ok(user);
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        userService.deleteUser(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}