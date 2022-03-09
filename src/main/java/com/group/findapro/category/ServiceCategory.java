package com.group.findapro.category;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Services")
public class ServiceCategory {

    @Id
    private int id;
    private String name;

}
