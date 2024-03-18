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


}
