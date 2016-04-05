package com.example;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    public UUID id;

    @Column(name = "username")
    public String name;
    
    @Column
    public String password;

}