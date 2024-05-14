package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.Usuarios;
import sv.edu.udb.www.proyectodwf.services.TipoUsuarioService;
import sv.edu.udb.www.proyectodwf.services.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuariosService.listarUsuarios());
        model.addAttribute("nombresTipoUsuario", tipoUsuarioService.obtenerNombresTipoUsuario());
        return "usuarios/usuarios"; // nombre de la vista que muestra la lista de usuarios
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("usuario", new Usuarios());
        model.addAttribute("tiposUsuarios", tipoUsuarioService.listarUsuarios());
        return "usuarios/crear"; // nombre de la vista que contiene el formulario de creación
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute("usuario") Usuarios usuario) {
        usuariosService.guardarUsuario(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Usuarios usuario = usuariosService.buscarUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("tiposUsuarios", tipoUsuarioService.listarUsuarios());
        return "usuarios/editar"; // nombre de la vista que contiene el formulario de edición
    }

    @PostMapping("/editar/{id}")
    public String actualizarUsuario(@PathVariable("id") int id, @ModelAttribute("usuario") Usuarios usuario) {
        usuario.setUsuarioId(id);
        usuariosService.actualizarUsuario(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") int id) {
        usuariosService.eliminarUsuario(id);
        return "redirect:/usuarios/listar";
    }
}
