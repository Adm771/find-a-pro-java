package com.group.findapro.user.standard_user.service;

import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;



    public List<User> getAllUsers(){return userRepository.findAll();}


    public ResponseEntity<User> getUserById(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUser(Long userId, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setDescription(userDetails.getDescription());
        user.setEmployment(userDetails.getEmployment());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return  ResponseEntity.ok(userRepository.save(user));
    }

    public Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
