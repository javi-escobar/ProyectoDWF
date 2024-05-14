package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.Empresas;
import sv.edu.udb.www.proyectodwf.services.EmpresasService;
import sv.edu.udb.www.proyectodwf.services.UsuariosService;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresasService empresasService;

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/listar")
    public String listarEmpresas(Model model) {
        List<Empresas> empresas = empresasService.listarEmpresas();
        model.addAttribute("empresas", empresas);
        model.addAttribute("nombreRepresentante", usuariosService.listarNombreUsuarios());
        return "empresas/empresas"; // nombre de la vista que muestra la lista de empresas
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("empresa", new Empresas());
        model.addAttribute("usuarios", usuariosService.listarUsuarioOrganizador());
        return "empresas/crear"; // nombre de la vista que contiene el formulario de creación
    }

    @PostMapping("/crear")
    public String crearEmpresa(@ModelAttribute("empresa") Empresas empresa) {
        empresasService.guardarEmpresa(empresa);
        return "redirect:/empresas/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Empresas empresa = empresasService.buscarEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        model.addAttribute("usuarios", usuariosService.listarUsuarioOrganizador());
        return "empresas/editar"; // nombre de la vista que contiene el formulario de edición
    }

    @PostMapping("/editar/{id}")
    public String actualizarEmpresa(@PathVariable("id") int id, @ModelAttribute("empresa") Empresas empresa) {
        empresa.setEmpresaId(id);
        empresasService.actualizarEmpresa(empresa);
        return "redirect:/empresas/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id) {
        empresasService.eliminarEmpresa(id);
        return "redirect:/empresas/listar";
    }
}

