package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.Eventos;
import sv.edu.udb.www.proyectodwf.services.EmpresasService;
import sv.edu.udb.www.proyectodwf.services.EstadoEventoService;
import sv.edu.udb.www.proyectodwf.services.EventosService;
import sv.edu.udb.www.proyectodwf.services.TipoEventoService;

@Controller
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @Autowired
    private EmpresasService empresasService;

    @Autowired
    private EstadoEventoService estadoEventoService;

    @Autowired
    private TipoEventoService tipoEventoService;

    @GetMapping("/listar")
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventosService.listarEventos());
        model.addAttribute("nombresEmpresas", empresasService.obtenerNombresEmpresas());
        model.addAttribute("estados", estadoEventoService.obtenerNombresEstadoEventos());
        model.addAttribute("tipos", tipoEventoService.obtenerNombresTipoEventos());
        return "eventos/eventos";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearEvento(Model model) {
        model.addAttribute("evento", new Eventos());
        model.addAttribute("tipos", tipoEventoService.listarTipoEventos());
        model.addAttribute("empresas", empresasService.listarEmpresas());
        model.addAttribute("estados", estadoEventoService.estadoEnEspera());
        return "eventos/crear";
    }

    @PostMapping("/crear")
    public String crearEvento(@ModelAttribute("evento") Eventos evento) {
        eventosService.guardarEvento(evento);
        return "redirect:/eventos/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarEvento(@PathVariable("id") int id, Model model) {
        Eventos evento = eventosService.buscarEventoPorId(id);
        model.addAttribute("evento", evento);
        model.addAttribute("tipos", tipoEventoService.listarTipoEventos());
        model.addAttribute("empresas", empresasService.listarEmpresas());
        model.addAttribute("estados", estadoEventoService.estadoEnEspera());
        return "eventos/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarEvento(@PathVariable("id") int id, @ModelAttribute("evento") Eventos evento) {
        evento.setEventoId(id);
        eventosService.actualizarEvento(evento);
        return "redirect:/eventos/listar";
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificarEvento(@PathVariable("id") int id, Model model) {
        Eventos evento = eventosService.buscarEventoPorId(id);
        model.addAttribute("evento", evento);
        model.addAttribute("nombresEmpresas", empresasService.obtenerNombresEmpresas());
        model.addAttribute("tipos", tipoEventoService.obtenerNombresTipoEventos());
        model.addAttribute("estados", estadoEventoService.estadosAprobadoRechazado());
        return "eventos/modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificarEvento(@PathVariable("id") int id, @ModelAttribute("evento") Eventos evento) {
        Eventos eventoAnterior = eventosService.buscarEventoPorId(id);
        int estadoAnterior = eventoAnterior.getEstadoId();
        evento.setEventoId(id);
        eventosService.actualizarEvento(evento);

        //Actualiza el campo 'Motivo'
        if (estadoAnterior == 2 && evento.getEstadoId() == 1) {
            evento.setMotivo("Vacío");
            eventosService.actualizarEvento(evento);
        }

        return "redirect:/eventos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable("id") int id) {
        eventosService.eliminarEvento(id);
        return "redirect:/eventos/listar";
    }
}
