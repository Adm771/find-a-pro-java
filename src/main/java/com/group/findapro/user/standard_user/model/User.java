package com.group.findapro.user.standard_user.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(
        name = "users",
       uniqueConstraints = {
            @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
               @UniqueConstraint(name = "user_phone_number_unique",columnNames = "phone_number")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number",
            unique = true)
    private long phoneNumber;

    @Column(name = "email",
            nullable = false)
    private String email;

    @Column(name = "password",
            nullable = false)
    private String password;

    @Column(name = "employment")
    private String employment;

    @Column(name = "profile_description")
    private String description;
}