package com.example.demo.services;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class UsuariosService {
    //
    @Autowired
    private UsuariosRepository repo;

    @Autowired
    private PersonaRepository repo2;


    private Utils utilitarios;


    public ResponseEntity<?> guardar(Usuarios items) {
        List<Usuarios> listaUsuarios;
        Persona personaGuardar;
        try {
            utilitarios = new Utils();
            //validarApellidosNombres
            Persona validadrIdentifiacion = repo2.findByIdentificacion(items.getPersona().getIdentificacion());
            listaUsuarios = repo.findByPersona(validadrIdentifiacion);
            if (validacionDatosUsuario(items, listaUsuarios)) {
                personaGuardar = repo2.save(items.getPersona());
                items.setPersona(personaGuardar);
                items.setMail(validarMailArreglo(personaGuardar, utilitarios));
                repo.save(items);
            } else {
                log.info("LA identificacion NO ES VALIDA: {}" + items.getPersona().getIdentificacion());
            }
        } catch (Exception e) {
            log.error("ERROR AL QUERER GUARDAR: " + items);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    private Boolean validacionDatosUsuario(Usuarios items, List<Usuarios> listaUsuarios) {
        Boolean valorValidacion = Boolean.FALSE;
        //VERIFICA QUE LOS NOMBRES, APELLIDOS Y USERNAME ESTEN CORRECTOS
        //SE  PARTE EL NOMBRE PARA CREAR EL CORREO
        //VERIFICO QUE UNA PERSONA NO TENGA NOMBRES DUPLICADOS
        if (utilitarios.validarGuardadoDeUsuarios(items, listaUsuarios.size())
                && utilitarios.validarIdentificacion(items.getPersona().getIdentificacion())
                && utilitarios.validarPass(items.getPassword())) {
            valorValidacion = Boolean.TRUE;
        }
        return valorValidacion;
    }



    public String validarMailArreglo(Persona p, Utils utilitarios) {
        Usuarios u = new Usuarios();
        String mail = "";
        mail = utilitarios.concatenarTextosCorreo(p, 1, 0);
        u = repo.buscarPorIdent(mail);
        if (u != null) {
            int i = 1;
            do {
                mail = utilitarios.concatenarTextosCorreo(p, 2, i) + "@mail.com";
                u = repo.buscarPorIdent(mail);
                i++;
            } while (u != null);
        } else {
            return mail;
        }
        return mail;
    }

    public List<Usuarios> listarClientesActivos() {
        List<Usuarios> rw = null;
        rw = new ArrayList<>();
        try {
            rw = repo.findAll();

        } catch (Exception e) {
            rw = new ArrayList<>();
        }
        return rw;
    }


}
