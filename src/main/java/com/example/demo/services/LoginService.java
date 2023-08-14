package com.example.demo.services;

import com.example.demo.model.ResponseService;
import com.example.demo.model.Sessions;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.SessionsRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private UsuariosRepository repo;

    @Autowired
    private SessionsRepository repoSession;



    private ResponseService responseService;




    Integer contador = 0;

    private Sessions sesion;

    public ResponseService login(Usuarios items) {
        responseService = new ResponseService();
        Usuarios usuario = repo.findByUserNameOrEmailAndPassword(items.getEmail(), items.getEmail(), items.getPassword());
        Usuarios username = repo.findByUserName(items.getUserName());
        if (usuario != null) {
            if (usuario.getSessionActive().charValue() != 'A') {
                usuario.setSessionActive('A');
                sesion = new Sessions();
                sesion.setUsuarios(usuario);
                sesion.setFechaIngreso(new Date());
                repoSession.save(sesion);
                repo.save(usuario);
                return respuesta(0, usuario);
            } else {
                return respuesta(1, usuario);
            }
        } else {
            contador++;
            System.out.println(contador);
            if (username != null) {
                if (contador > 3) {
                    username.setStatus('I');
                    repo.save(username);
                    return respuesta(2, usuario);
                } else {
                    return respuesta(3, usuario);
                }
            } else {
                return respuesta(66, usuario);
            }
        }


    }

    public ResponseService respuesta(Integer opcion, Usuarios usuario) {
        responseService = new ResponseService();
        Map<String, Object> mapa = new HashMap<>();

        switch (opcion) {
            case 0:

                mapa.put("Usuario", usuario);
                mapa.put("Rol", repo.findRolByUsert(usuario.getId()));
                responseService.setContenido(mapa);
                responseService.setMensajeTecnico("OK");
                responseService.setMensajeUsuario("LOGGUEADO CORRECTAMENTE");
                break;
            case 1:
                mapa.put("Usuario", usuario);
                responseService.setContenido(mapa);
                responseService.setMensajeTecnico("YA LOGGUEADO");
                responseService.setMensajeUsuario("YA SE ENCUENTRA LOGGUEADO");
                break;
            case 2:
                mapa.put("username", usuario.getUserName());
                responseService.setContenido(mapa);
                responseService.setMensajeUsuario("SU USUARIO FUE BLOQUEADO");
                responseService.setMensajeTecnico("BLOQEUADO POR INTENTOS FALLIDOS");
                break;
            case 3:
                mapa.put("username", usuario.getUserName());
                responseService.setContenido(mapa);
                responseService.setMensajeUsuario("INTENTOS FALLIDOS: " + contador);
                break;
            case 66:
                mapa.put("username", "");
                responseService.setContenido(mapa);
                responseService.setMensajeUsuario("USUARIO NO ENCONTRADO");
                break;
        }
        return responseService;
    }
}
