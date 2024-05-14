package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.EstadoEvento;
import sv.edu.udb.www.proyectodwf.services.EstadoEventoService;

import java.util.List;

@Controller
@RequestMapping("/estados")
public class EstadoEventoController {

    @Autowired
    private EstadoEventoService estadoEventoService;

    @GetMapping("/listar")
    public String listarEstados(Model model) {
        List<EstadoEvento> estados = estadoEventoService.listarEstadoEventos();
        model.addAttribute("estados", estados);
        return "estados/estados"; // nombre de la vista que muestra la lista de estados
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("estado", new EstadoEvento());
        return "estados/crear"; // nombre de la vista que contiene el formulario de creación
    }

    @PostMapping("/crear")
    public String crearEstado(@ModelAttribute("estado") EstadoEvento estado) {
        estadoEventoService.guardarEstadoEvento(estado);
        return "redirect:/estados/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        EstadoEvento estado = estadoEventoService.buscarEstadoEventoPorId(id);
        model.addAttribute("estado", estado);
        return "estados/editar"; // nombre de la vista que contiene el formulario de edición
    }

    @PostMapping("/editar/{id}")
    public String actualizarEstado(@PathVariable("id") int id, @ModelAttribute("estado") EstadoEvento estado) {
        estado.setEstadoId(id);
        estadoEventoService.actualizarEstadoEvento(estado);
        return "redirect:/estados/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstado(@PathVariable("id") int id) {
        estadoEventoService.eliminarEstadoEvento(id);
        return "redirect:/estados/listar";
    }
}
