package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rolName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
}
