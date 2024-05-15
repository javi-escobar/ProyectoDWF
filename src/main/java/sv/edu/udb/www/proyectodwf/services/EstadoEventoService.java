package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.EstadoEvento;
import sv.edu.udb.www.proyectodwf.entities.TipoEvento;
import sv.edu.udb.www.proyectodwf.entities.Usuarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EstadoEventoService {
    @PersistenceContext
    private EntityManager entityManager;

    public void guardarEstadoEvento(EstadoEvento estadoEvento) {
        entityManager.persist(estadoEvento);
    }

    public EstadoEvento buscarEstadoEventoPorId(int estadoEventoId) {
        return entityManager.find(EstadoEvento.class, estadoEventoId);
    }

    public void actualizarEstadoEvento(EstadoEvento estadoEvento) {
        entityManager.merge(estadoEvento);
    }

    public void eliminarEstadoEvento(int estadoEventoId) {
        EstadoEvento estadoEvento = entityManager.find(EstadoEvento.class, estadoEventoId);
        if (estadoEvento != null) {
            entityManager.remove(estadoEvento);
        }
    }

    public List<EstadoEvento> listarEstadoEventos() {
        TypedQuery<EstadoEvento> query = entityManager.createQuery("SELECT e FROM EstadoEvento e", EstadoEvento.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresEstadoEventos() {
        Map<Integer, String> nombresEstadoEventos = new HashMap<>();
        List<EstadoEvento> estadoEventos = listarEstadoEventos();
        for (EstadoEvento estadoEvento : estadoEventos) {
            nombresEstadoEventos.put(estadoEvento.getEstadoId(), estadoEvento.getEstado());
        }
        return nombresEstadoEventos;
    }

    public List<EstadoEvento> estadoEnEspera() {
        TypedQuery<EstadoEvento> query = entityManager.createQuery(
                "SELECT e FROM EstadoEvento e WHERE e.estadoId = 3", EstadoEvento.class);
        return query.getResultList();
    }

    public List<EstadoEvento> estadosAprobadoRechazado() {
        TypedQuery<EstadoEvento> query = entityManager.createQuery(
                "SELECT e FROM EstadoEvento e WHERE e.estadoId = 1 OR e.estadoId = 2", EstadoEvento.class);
        return query.getResultList();
    }
}
