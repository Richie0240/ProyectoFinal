//
//package Templates.trash;
//
//import com.proyecto.domain.Categoria;
//import com.proyecto.services.CategoriaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.proyecto.services.ProductoService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//@RequestMapping("/")
//public class IndexController {
//
//    @Autowired
//    private ProductoService productoService;
//    @Autowired
//    private CategoriaService categoriaService;
//
//    @GetMapping("/")
//    public String listado(Model model) {
//        var productos = productoService.getProductos(false);
//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("productos", productos);
//        model.addAttribute("totalProductos", productos.size());
//        model.addAttribute("categorias", categorias);
//        return "/index";
//    }
//
//    @GetMapping("/index/{idCategoria}")
//    public String listado(Model model, Categoria categoria) {
//        var productos = categoriaService.getCategoria(categoria).getProductos();
//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("productos", productos);
//        model.addAttribute("totalProductos", productos.size());
//        model.addAttribute("categorias", categorias);
//        return "/index";
//    }
//    
//    
//    
//}
