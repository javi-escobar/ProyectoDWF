package sv.edu.udb.www.proyectodwf.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.proyectodwf.entities.Reservaciones;
import sv.edu.udb.www.proyectodwf.services.ReservacionesService;

import java.util.List;

@Controller
@RequestMapping("/reservaciones")
public class ReservacionesController {
    
    @Autowired
    private ReservacionesService reservacionesService;
    
    @GetMapping("/listar")
    public String listarReservaciones(Model model) {
        List<Reservaciones> reservaciones = reservacionesService.listarReservaciones();
        model.addAttribute("reservaciones", reservaciones);
        return "reservaciones/reservaciones";
    }
    
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("reservacion", new Reservaciones());
        return "reservaciones/crear";
    }
    
    @PostMapping("/guardar")
    public String guardarReservacion(@ModelAttribute("reservacion") Reservaciones reservacion) {
        reservacionesService.guardarReservacion(reservacion);
        return "redirect:/reservaciones/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int reservacionId, Model model) {
        Reservaciones reservacion = reservacionesService.buscarReservacionPorId(reservacionId);
        model.addAttribute("reservacion", reservacion);
        return "reservaciones/editar";
    }
    
    @PostMapping("/actualizar/{id}")
    public String actualizarReservacion(@PathVariable("id") int reservacionId, @ModelAttribute("reservacion") Reservaciones reservacion) {
        reservacionesService.actualizarReservacion(reservacion);
        return "redirect:/reservaciones/listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarReservacion(@PathVariable("id") int reservacionId) {
        reservacionesService.eliminarReservacion(reservacionId);
        return "redirect:/reservaciones/listar";
    }
}
