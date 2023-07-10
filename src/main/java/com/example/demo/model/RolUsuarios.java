package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "rol_usuarios")
public class RolUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol;

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
