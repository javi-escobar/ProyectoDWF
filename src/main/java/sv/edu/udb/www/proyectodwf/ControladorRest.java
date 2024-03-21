package sv.edu.udb.www.proyectodwf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Slf4j
public class ControladorRest {
    @GetMapping("/aprobareventos")
    public String aprobareventos() {
        log.info("Vista de Aprobar Eventos");
        return "aprobareventos";
    }

    @GetMapping("/reservaciones")
    public String reservaciones() {
        log.info("Vista de Reservaciones Realizadas");
        return "reservacionesrealizadas";
    }

    @GetMapping("/rechazarevento")
    public String rechazarevento() {
        log.info("Vista de Rechazar Evento");
        return "rechazarevento";
    }

    @GetMapping("/misreservaciones")
    public String misreservaciones() {
        log.info("Vista de Rechazar Evento");
        return "misreservaciones";
    }

    @GetMapping("/registroeventos")
    public String registroeventos() {
        log.info("Vista de Registrar Evento");
        return "registroeventos";
    }
    @GetMapping("/plantilla")
    public String plantilla() {
        log.info("Vista de la Plantilla del Proyecto");
        return "plantilla";
    }
    @GetMapping("/editarmireservacion")
    public String editarmireservacion() {
        log.info("Vista de Editar mi reservación");
        return "editarmireservacion";
    }

    @GetMapping("/eventosregistrados")
    public String eventosregistrados() {
        log.info("Vista de los Eventos Registrados");
        return "eventosregistrados";
    }
    @GetMapping("/editarreservacion")
    public String editarreservacion() {
        log.info("Vista de Editar Reservación");
        return "editarreservacion";
    }

}
