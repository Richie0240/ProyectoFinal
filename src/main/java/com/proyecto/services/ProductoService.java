package com.proyecto.services;

import com.proyecto.domain.Producto;
import java.util.List;

public interface ProductoService {
    

    
    public List<Producto> getProductos(Boolean activo);
    

    public Producto getProducto (Producto producto);
    

    public void save(Producto producto);
    

    public void delete(Producto Producto);

    public List<Producto> consultaQuery(
            double precioInf, double precioSup);
     

    public List<Producto> consultaJPQL(
            double precioInf, double precioSup);

    public List<Producto> consultaSQL(
            double precioInf, double precioSup);
    
     
}
