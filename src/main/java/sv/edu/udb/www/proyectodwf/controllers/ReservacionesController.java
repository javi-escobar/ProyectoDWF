package sv.edu.udb.www.proyectodwf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.Reservaciones;
import sv.edu.udb.www.proyectodwf.services.EventosService;
import sv.edu.udb.www.proyectodwf.services.ReservacionesService;
import sv.edu.udb.www.proyectodwf.services.UsuariosService;

import java.util.List;

@Controller
@RequestMapping("/reservaciones")
public class ReservacionesController {

    @Autowired
    private ReservacionesService reservacionesService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private EventosService eventosService;

    @GetMapping("/listar")
    public String listarReservaciones(Model model) {
        List<Reservaciones> reservaciones = reservacionesService.listarReservaciones();
        model.addAttribute("reservaciones", reservaciones);
        model.addAttribute("nombreUsuario", usuariosService.listarNombreUsuarios());
        model.addAttribute("eventos", eventosService.obtenerNombresEventos());
        return "reservaciones/reservaciones";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("reservacion", new Reservaciones());
        model.addAttribute("eventos", eventosService.listarEventos());
        model.addAttribute("usuarios", usuariosService.listarUsuarios());
        return "reservaciones/crear";
    }

    @PostMapping("/crear")
    public String guardarReservacion(@ModelAttribute("reservacion") Reservaciones reservacion) {
        reservacionesService.guardarReservacion(reservacion);
        return "redirect:/reservaciones/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Reservaciones reservacion = reservacionesService.buscarReservacionPorId(id);
        model.addAttribute("reservacion", reservacion);
        model.addAttribute("eventos", eventosService.listarEventos());
        model.addAttribute("usuarios", usuariosService.listarUsuarios());
        return "reservaciones/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarReservacion(@PathVariable("id") int id, @ModelAttribute("reservacion") Reservaciones reservacion) {
        reservacion.setReservacionId(id);
        reservacionesService.actualizarReservacion(reservacion);
        return "redirect:/reservaciones/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReservacion(@PathVariable("id") int reservacionId) {
        reservacionesService.eliminarReservacion(reservacionId);
        return "redirect:/reservaciones/listar";
    }
}
