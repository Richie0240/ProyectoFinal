/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Item;
import com.proyecto.domain.Producto;
import com.proyecto.services.ItemService;
import com.proyecto.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ricar
 */
@Controller
public class CarritoController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    private String inicio(Model model) {

        var productos = productoService.getProductos(true);
        model.addAttribute("productos", productos);
        return "/index";
    }

    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregarItem(Model model, Item item) {

        Item buscado = itemService.get(item);
        if (buscado == null) {
            Producto producto = productoService.getProducto(item);
            buscado = new Item(producto);

        }

        itemService.save(buscado);

        var lista = itemService.gets();
        var totalCarrito = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarrito += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());

        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarrito);

        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");

    }

    @GetMapping("/carrito/listado")
    public String listado(Model model) {
        var lista = itemService.gets();
        model.addAttribute("items", lista);
        var totalVenta = 0;
        for (Item i : lista) {
            totalVenta += i.getCantidad() * i.getPrecio();

        }
        model.addAttribute("carritoTotal", totalVenta);
        return "/carrito/listado";
    }

    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminar(Item item) {
        itemService.delete(item);

        return "redirect:/carrito/listado";
    }

    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificar(Model model, Item item) {
        item = itemService.get(item);
        model.addAttribute("item", item);

        return "/carrito/modifica";
    }

    @GetMapping("/facturar/carrito")
    public String facturar(){
        
        itemService.facturar();
        return "redirect:/";
        
    }
}
