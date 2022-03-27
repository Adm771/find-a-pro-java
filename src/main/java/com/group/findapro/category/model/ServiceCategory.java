package com.group.findapro.category.model;

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
@Table(name = "services")
public class ServiceCategory {

    @Id
    private int serviceId;
    private String name;
}
