package com.example.demo.services;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService {
    private static final Logger LOG = Logger.getLogger(LoginService.class.getName());
    @Autowired
    private UsuariosRepository repo;

    Integer contador = 0;
    public ResponseEntity<?> login(Usuarios items) {
        Usuarios usuario = new Usuarios();
        System.out.println(items.getUserName()+" "+items.getPassword());
        usuario= repo.findByUserNameOrMailAndPassword(items.getUserName(),items.getUserName(),items.getPassword());
        Usuarios username = new Usuarios();
                username = repo.findByUserName(items.getUserName());
        if (usuario != null ) {
            if(usuario.getSessionActive().charValue() != 'A'){
                usuario.setSessionActive('A');
                repo.save(usuario);
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("El usuario ya esta loggueado", HttpStatus.OK);
            }
        }
        else{
            contador++;
            System.out.println(contador);
            if(username != null){
                if(contador>3){
                    username.setStatus('I');
                    repo.save(username);
                    return new ResponseEntity<>("USUARIO CON USERNAME: '"+username.getUserName()+"' FUE BLOQUEADO", HttpStatus.NOT_FOUND);
                }
                else
                {
                return new ResponseEntity<>("INTENTOS FALLIDOS: "+  contador, HttpStatus.NOT_FOUND);
                }
            }
            else{
                return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
            }
        }


    }
}
