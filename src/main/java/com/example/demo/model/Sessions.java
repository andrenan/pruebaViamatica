package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuarios")
    private Usuarios usuarios;
    private Date fechaIngreso;
    private Date fechaCierrre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCierrre() {
        return fechaCierrre;
    }

    public void setFechaCierrre(Date fechaCierrre) {
        this.fechaCierrre = fechaCierrre;
    }
}
