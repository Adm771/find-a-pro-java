package com.group.findapro.user.standard_user.repository;


import com.group.findapro.user.standard_user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ZWROT LISTY PRZY SZUKANIA PO IMIENIU
    List<User> findByFirstName(String firstName);
    // ZWROT LISTY GDY TE ZNAKI SĄ W IMIENIU
    List<User> findByFirstNameContaining(String firstName);

}
