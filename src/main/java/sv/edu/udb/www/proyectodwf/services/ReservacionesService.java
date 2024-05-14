package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.Reservaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReservacionesService {
    @PersistenceContext
    private EntityManager entityManager;

    public void guardarReservacion(Reservaciones reservacion) {
        entityManager.persist(reservacion);
    }

    public Reservaciones buscarReservacionPorId(int reservacionId) {
        return entityManager.find(Reservaciones.class, reservacionId);
    }

    public void actualizarReservacion(Reservaciones reservacion) {
        entityManager.merge(reservacion);
    }

    public void eliminarReservacion(int reservacionId) {
        Reservaciones reservacion = entityManager.find(Reservaciones.class, reservacionId);
        if (reservacion != null) {
            entityManager.remove(reservacion);
        }
    }

    public List<Reservaciones> listarReservaciones() {
        TypedQuery<Reservaciones> query = entityManager.createQuery("SELECT r FROM Reservaciones r", Reservaciones.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresReservaciones() {
        Map<Integer, String> nombresReservaciones = new HashMap<>();
        List<Reservaciones> reservaciones = listarReservaciones();
        for (Reservaciones reservacion : reservaciones) {
            nombresReservaciones.put(reservacion.getReservacionId(), reservacion.getNombreContacto());
        }
        return nombresReservaciones;
    }
}
