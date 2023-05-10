package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role extends BaseEntity {

    private String description;
}
