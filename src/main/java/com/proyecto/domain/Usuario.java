package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity

@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVerionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")

    private Long idUsuario;

    private String username;
    
    private String password;
     
    private String nombre;
    
    private String apellidos;
    
     private String correo;
    
    private String telefono;
    
    private String rutaImagen;
    
    private boolean activo;
  
    

    @OneToMany
    @JoinColumn(name = "id_usuario", updatable = false)
    List<Rol> roles;



}
