package com.example.demo.utils;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
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
        if(p.length()==10 && p.matches("[0-9]+") && !validarNumerosSeguidos(p)){
            //&& !validarNumerosSeguidos(p)==true
            return true;
        }else{
            return false;
        }
    }

    public Boolean validarNumerosSeguidos(String s){
        Boolean regreso = Boolean.FALSE;
        String regex = "(\\d)\\1{3,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            regreso = Boolean.TRUE;
        }
        else{
            regreso = Boolean.FALSE;
        }
        return regreso;
    }

    public Boolean validarApellidosNombres(String s){
        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){return true;}else{return false;}
    }


    public String concatenarTextosCorreo(Persona p, Integer opcion, Integer aumento){
        String mail = "";
        String[] nombres = p.getNombres().split(" ");
        String[] apellidos = p.getApellidos().split(" ");
        if(opcion==1){
            mail = ("" + nombres[0].charAt(0) + apellidos[0] + apellidos[0].charAt(0)+"@mail.com").toLowerCase();
        }else{
            mail = ("" + nombres[0].charAt(0) + apellidos[0] + apellidos[0].charAt(0) + aumento).toLowerCase();
        }
        return mail;
    }

    public Boolean validarGuardadoDeUsuarios(Usuarios items, Integer tamanioLista){
        int contador = 0;
        Boolean valorRegreso = Boolean.FALSE;
        String[] textoSeparado = items.getPersona().getNombres().split(" ");
        if (textoSeparado[0] != textoSeparado[1]) {
            contador++;
        }
        if((validarApellidosNombres(items.getPersona().getNombres()) || validarApellidosNombres(items.getPersona().getApellidos())) && (!items.getUserName().contains(" "))
        && validarApellidosNombres(items.getUserName()) && tamanioLista>2 && contador ==1){
            valorRegreso= Boolean.TRUE;
        }else{

        }
        return valorRegreso;
    }



}
