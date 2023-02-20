package com.example.SpringTwitter.archivo.controller;

import com.example.SpringTwitter.archivo.application.FileServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/files")
public class ArchivoController {
    @Autowired
    private FileServiceAPI fileServiceAPI;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("files")List<MultipartFile> files) throws Exception {
        fileServiceAPI.save(files);
        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos");
    }
}
