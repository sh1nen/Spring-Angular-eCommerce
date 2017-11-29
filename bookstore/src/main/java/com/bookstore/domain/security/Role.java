package com.bookstore.domain.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role implements Serializable{

    @Id
    private Long id;
    private  String name;
    private Set<UserRole> userRoles = new HashSet<>();


}
