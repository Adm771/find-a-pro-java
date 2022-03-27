package com.group.findapro.user.standard_user.service;

import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return user;
    }

    public void addUser(User newUser) {
        userRepository.save(newUser);
    }

    @Transactional
    public User updateUser(Long userId, User user) throws ResourceNotFoundException{
        System.out.println("Fetching user with id = " + userId);
        User userEdited = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userEdited.setFirstName(user.getFirstName());
        userEdited.setLastName(user.getLastName());
        userEdited.setDescription(user.getDescription());
        userEdited.setPhoneNumber(user.getPhoneNumber());
        // these two below to change
        userEdited.setEmail(user.getEmail());
        userEdited.setPassword(user.getPassword());

        System.out.println("Updated to " + userEdited);
        // unnecessary because of "dirty checking"
        userRepository.save(userEdited);
        return userEdited;
    }

    public boolean deleteUser(long userId) throws ResourceNotFoundException {
        User userEdited = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        userRepository.deleteById(userId);
        return true;
    }
}
