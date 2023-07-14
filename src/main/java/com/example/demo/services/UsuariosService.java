package com.example.demo.services;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuariosService {
    private static final Logger LOG = Logger.getLogger(UsuariosService.class.getName());
    @Autowired
    private UsuariosRepository repo;

    @Autowired
    private PersonaRepository repo2;





    public ResponseEntity<?> guardar(Usuarios items) {
        try {
            int contador =0;
            Boolean validarPass = Boolean.FALSE;
            //Str.matches(".*[0-9].*")
            if(!items.getPersona().getNombres().toLowerCase().matches("[a-zA-Z]") || !items.getPersona().getApellidos().matches("[a-zA-Z]")){
                System.out.println("entro aqui");
                String[] textoSeparado = items.getPersona().getNombres().split(" ");

                        if(textoSeparado[0]!=textoSeparado[1]){
                            contador++;
                        }

                if(contador ==1){
                    System.out.println("entro aqui 2");
                    validarPass = validarPass(items.getPassword());
                    if(validarPass==true){
                        System.out.println("entro aqui 3");
                        if(validarIdentificacion(items.getPersona().getIdentificacion())){
                            System.out.println("entro aqui 4");
                            Persona p = new Persona();
                            p = repo2.save(items.getPersona());
                            items.setPersona(p);
                            items.setMail(validarMail(p));
                            repo.save(items);
                        }else{
                            System.out.println("LA IDENTIFICACION ESTA INCORRECTA");
                        }

                    }else{
                        System.out.println("CORRIJA LA CONTRASEÑA");
                    }
                }
            }else{
                System.out.println("EL NOMBRE CONTIENE NUMEROS O SIMBOLOS");
            }


        } catch (Exception e) {

        }
        return new ResponseEntity(HttpStatus.OK);
    }

    public String validarMail(Persona p){
        Usuarios u = new Usuarios();
        String mail="";
        String[] nombres = p.getNombres().split(" ");
        String[] apellidos = p.getApellidos().split(" ");
        //alumno.setNombre(textoSeparado[0]);
        //System.out.println(sCadena.charAt(5));
        mail=""+nombres[0].charAt(0);
        mail = mail + apellidos[0];
        mail = mail +apellidos[0].charAt(0);
        mail = mail.toLowerCase();
        mail = mail +"@mail.com";
        u = repo.buscarPorIdent(mail);
        if(u != null){
            int i=1;
            do{
                mail=""+nombres[0].charAt(0);
                mail = mail + apellidos[0];
                mail = mail +apellidos[0].charAt(0);
                mail = mail.toLowerCase();
                mail = mail +i;

                mail = mail +"@mail.com";
                u = repo.buscarPorIdent(mail);
                i++;
            }while(u!=null);
        }else{
            return mail;
        }
        return mail;
    }
    public Boolean validarPass(String p){
        Boolean x = Boolean.FALSE;
        if(p.length()>=8 && esMayuscula(p)==true && !p.contains(" ") && tieneSignoz(p)==true){
            x= true;
        }
        return x;
    }

    public Boolean esMayuscula(String s) {
        int contador = 0;
        for(int i=0; i<s.length();i++){
            String xx="";
            //for (int n = 0, n <str.length (); n + +) { char c = str.charAt (n); System.out.println (c); }
            xx = String.valueOf(s.charAt(i));
            if(xx.matches("[A-Z]")){
                contador++;
            }
        }
        if(contador>0){return true;}else{return false;}
    }

    public Boolean tieneSignoz(String s) {
        int contador = 0;
        for(int i=0; i<s.length();i++){
            String xx="";
            //for (int n = 0, n <str.length (); n + +) { char c = str.charAt (n); System.out.println (c); }
            xx = String.valueOf(s.charAt(i));
            if(!xx.matches("[a-zA-Z0-9]")){
                contador++;
            }
        }
        if(contador>0){return true;}else{return false;}
    }

    public Boolean validarIdentificacion(String p){
        if(p.length()==10 && p.matches("[0-9]+") ){
            //&& !validarNumerosSeguidos(p)==true
            return true;
        }else{
            return false;
        }
    }

    public Boolean validarNumerosSeguidos(String s){
        Boolean regreso = Boolean.FALSE;
        int contador=0;
        for(int i=0; i<s.length();i++){
            for(int j=0; j<s.length();j++){
               if(s.charAt(j)==s.charAt(j+1)){
                   contador++;
               }
            }if(contador >=3){
                regreso = Boolean.TRUE;
                break;
            }
        }
        return regreso;
    }

    public List<Usuarios> listarClientesActivos( ) {
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
