package com.example.demo.controller;

import com.example.demo.services.PdfService;
import com.example.demo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReporteController {
    private final SessionService placeService;
    private final PdfService pdfService;

    @Autowired
    public ReporteController(SessionService placeService, PdfService pdfService) {
        this.placeService = placeService;
        this.pdfService = pdfService;
    }

    @GetMapping("/pdf")
    public void generarPDF(HttpServletResponse response) {
        try {
            Path file = Paths.get(pdfService.generatePlacesPdf().getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename"+ file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
