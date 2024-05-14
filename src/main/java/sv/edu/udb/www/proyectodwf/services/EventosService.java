package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.Eventos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EventosService {
    @PersistenceContext
    private EntityManager entityManager;

    public void guardarEvento(Eventos evento) {
        entityManager.persist(evento);
    }

    public Eventos buscarEventoPorId(int eventoId) {
        return entityManager.find(Eventos.class, eventoId);
    }

    public void actualizarEvento(Eventos evento) {
        entityManager.merge(evento);
    }

    public void eliminarEvento(int eventoId) {
        Eventos evento = entityManager.find(Eventos.class, eventoId);
        if (evento != null) {
            entityManager.remove(evento);
        }
    }

    public List<Eventos> listarEventos() {
        TypedQuery<Eventos> query = entityManager.createQuery("SELECT e FROM Eventos e", Eventos.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresEventos() {
        Map<Integer, String> nombresEventos = new HashMap<>();
        List<Eventos> eventos = listarEventos();
        for (Eventos evento : eventos) {
            nombresEventos.put(evento.getEventoId(), evento.getNombreEvento());
        }
        return nombresEventos;
    }
}
