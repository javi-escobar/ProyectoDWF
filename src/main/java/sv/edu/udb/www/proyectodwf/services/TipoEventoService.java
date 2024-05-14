package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.TipoEvento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TipoEventoService {
    @PersistenceContext
    private EntityManager entityManager;

    public void guardarTipoEvento(TipoEvento tipoEvento) {
        entityManager.persist(tipoEvento);
    }

    public TipoEvento buscarTipoEventoPorId(int tipoEventoId) {
        return entityManager.find(TipoEvento.class, tipoEventoId);
    }

    public void actualizarTipoEvento(TipoEvento tipoEvento) {
        entityManager.merge(tipoEvento);
    }

    public void eliminarTipoEvento(int tipoEventoId) {
        TipoEvento tipoEvento = entityManager.find(TipoEvento.class, tipoEventoId);
        if (tipoEvento != null) {
            entityManager.remove(tipoEvento);
        }
    }

    public List<TipoEvento> listarTipoEventos() {
        TypedQuery<TipoEvento> query = entityManager.createQuery("SELECT t FROM TipoEvento t", TipoEvento.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresTipoEventos() {
        Map<Integer, String> nombresTipoEventos = new HashMap<>();
        List<TipoEvento> tipoEventos = listarTipoEventos();
        for (TipoEvento tipoEvento : tipoEventos) {
            nombresTipoEventos.put(tipoEvento.getTipoEventoId(), tipoEvento.getNombreTipoEvento());
        }
        return nombresTipoEventos;
    }
}
