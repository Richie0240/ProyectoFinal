package com.proyecto.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "proyecto-c1943.appspot.com";

    final String rutaSuperiorStorage = "proyecto";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "proyecto-c1943-firebase-adminsdk-62a3c-c46d20f37e.json";
}