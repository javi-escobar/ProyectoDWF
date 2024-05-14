package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sv.edu.udb.www.proyectodwf.services.TipoUsuarioService;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping("/tiposUsuarios")
    public String listarTiposUsuarios(Model model) {
        model.addAttribute("tiposUsuarios", tipoUsuarioService.listarUsuarios());
        return "tiposUsuarios/lista"; // Nombre de la vista que muestra la lista de tipos de usuarios
    }
}
