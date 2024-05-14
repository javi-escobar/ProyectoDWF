package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.TipoEvento;
import sv.edu.udb.www.proyectodwf.services.TipoEventoService;

import java.util.List;

@Controller
@RequestMapping("/tipoeventos")
public class TipoEventoController {

    @Autowired
    private TipoEventoService tipoEventoService;

    @GetMapping("/listar")
    public String listarTipoEventos(Model model) {
        List<TipoEvento> tipoEventos = tipoEventoService.listarTipoEventos();
        model.addAttribute("tipoEventos", tipoEventos);
        return "tipoeventos/tipoeventos"; // Nombre de la vista que muestra la lista de tipos de evento
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("tipoEvento", new TipoEvento());
        return "tipoeventos/crear"; // Nombre de la vista que contiene el formulario de creación
    }

    @PostMapping("/crear")
    public String crearTipoEvento(@ModelAttribute("tipoEvento") TipoEvento tipoEvento) {
        tipoEventoService.guardarTipoEvento(tipoEvento);
        return "redirect:/tipoeventos/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        TipoEvento tipoEvento = tipoEventoService.buscarTipoEventoPorId(id);
        model.addAttribute("tipoEvento", tipoEvento);
        return "tipoeventos/editar"; // Nombre de la vista que contiene el formulario de edición
    }

    @PostMapping("/editar/{id}")
    public String actualizarTipoEvento(@PathVariable("id") int id, @ModelAttribute("tipoEvento") TipoEvento tipoEvento) {
        tipoEvento.setTipoEventoId(id);
        tipoEventoService.actualizarTipoEvento(tipoEvento);
        return "redirect:/tipoeventos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTipoEvento(@PathVariable("id") int id) {
        tipoEventoService.eliminarTipoEvento(id);
        return "redirect:/tipoeventos/listar";
    }
}
