package sv.edu.udb.www.proyectodwf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class ControladorRest {
    @GetMapping("/aprobareventos")
    public String aprobareventos() {
        log.info("Vista de Aprobar Eventos");
        return "admin/aprobareventos";
    }

    @GetMapping("/reservaciones")
    public String reservaciones() {
        log.info("Vista de Reservaciones Realizadas");
        return "organizador/reservacionesrealizadas";
    }

    @GetMapping("/rechazarevento")
    public String rechazarevento() {
        log.info("Vista de Rechazar Evento");
        return "admin/rechazarevento";
    }

    @GetMapping("/misreservaciones")
    public String misreservaciones() {
        log.info("Vista de Rechazar Evento");
        return "cliente/misreservaciones";
    }

    @GetMapping("/registroeventos")
    public String registroeventos() {
        log.info("Vista de Registrar Evento");
        return "organizador/registroeventos";
    }
    @GetMapping("/plantilla")
    public String plantilla() {
        log.info("Vista de la Plantilla del Proyecto");
        return "plantilla";
    }
    @GetMapping("/editarmireservacion")
    public String editarmireservacion() {
        log.info("Vista de Editar mi reservación");
        return "cliente/editarmireservacion";
    }

    @GetMapping("/eventosdisponibles")
    public String eventosdisponibles() {
        log.info("Vista de los Eventos Disponibles");
        return "cliente/eventosdisponibles";
    }
    @GetMapping("/editarreservacion")
    public String editarreservacion() {
        log.info("Vista de Editar Reservación");
        return "admin/editarreservacion";
    }

    @GetMapping("/login")
    public String login() {
        log.info("Vista de Login");
        return "login";
    }

    @GetMapping("/reservarcupo")
    public String reservarcupo() {
        log.info("Vista de Reservar Cupo");
        return "cliente/reservarcupo";
    }

    @GetMapping("/controlevento")
    public String controlevento() {
        log.info("Vista de Control de eventos");
        return "admin/controlevento";
    }
    @GetMapping("/editarevento")
    public String editarevento() {
        log.info("Vista de Editar el evento");
        return "admin/editarevento";
    }
}


