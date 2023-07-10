package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "rol_rolopciones")
public class RolRolOpciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "rol_opciones")
    private RolOpciones rolOpciones;

    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol;

    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }

    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
