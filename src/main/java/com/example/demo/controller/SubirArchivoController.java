package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuariosService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = "http://localhost:4200/")
public class SubirArchivoController {
    @Autowired
    UsuariosService usuariosService;



    @PostMapping("/csv")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        int linea = 1;
        Persona personaPorGuardar;
        Usuarios usuarioPorGuardar;
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                if (linea == 1) {
                    //No muestra si es linea 1
                } else {
                    // Aquí puedes acceder a cada campo del CSV
                    String column1 = csvRecord.get(0);
                    String column2 = csvRecord.get(1);
                    String column3 = csvRecord.get(2);
                    String column4 = csvRecord.get(3);
                    String column5 = csvRecord.get(4);
                    String column6 = csvRecord.get(5);
                    String column7 = csvRecord.get(6);
                    String column8 = csvRecord.get(7);
                    personaPorGuardar = new Persona();
                    personaPorGuardar.setNombres(column6);
                    personaPorGuardar.setApellidos(column7);
                    personaPorGuardar.setIdentificacion(column8);
                    usuarioPorGuardar = new Usuarios();
                    usuarioPorGuardar.setPersona(personaPorGuardar);
                    usuarioPorGuardar.setStatus('A');
                    usuarioPorGuardar.setSessionActive('I');
                    usuarioPorGuardar.setUserName(column1);
                    usuarioPorGuardar.setPassword(column2);
                    usuarioPorGuardar.setEmail(column3);
                    usuariosService.guardar(usuarioPorGuardar);
                    // ... y así sucesivamente para cada columna
                    System.out.println("Columna 1: " + column1);
                    System.out.println("Columna 2: " + column2);
                    System.out.println("Columna 3: " + column3);
                    System.out.println("Columna 4: " + column4);
                    System.out.println("Columna 5: " + column5);
                    System.out.println("Columna 6: " + column6);
                    System.out.println("Columna 7: " + column7);
                    System.out.println("Columna 8: " + column8);
                }linea++;
            }
            return "Archivo cargado exitosamente";
        } catch (Exception e) {
            return "Error al cargar el archivo";
        }
    }
}
