package com.example.demo;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    @Autowired
    private UsuariosRepository repo;

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


