package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.TipoUsuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TipoUsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public void guardarTipoUsuario(TipoUsuario tipoUsuario) {
        entityManager.persist(tipoUsuario);
    }

    public TipoUsuario buscarTipoUsuarioPorId(int tipoUsuarioId) {
        return entityManager.find(TipoUsuario.class, tipoUsuarioId);
    }

    public void actualizarTipoUsuario(TipoUsuario tipoUsuario) {
        entityManager.merge(tipoUsuario);
    }

    public void eliminarTipoUsuario(int tipoUsuarioId) {
        TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, tipoUsuarioId);
        if (tipoUsuario != null) {
            entityManager.remove(tipoUsuario);
        }
    }

    public List<TipoUsuario> listarUsuarios() {
        TypedQuery<TipoUsuario> query = entityManager.createQuery("SELECT u FROM TipoUsuario u", TipoUsuario.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresTipoUsuario() {
        Map<Integer, String> nombresTipoUsuario = new HashMap<>();
        List<TipoUsuario> tiposUsuario = listarUsuarios();
        for (TipoUsuario tipoUsuario : tiposUsuario) {
            nombresTipoUsuario.put(tipoUsuario.getTipoUsuarioId(), tipoUsuario.getNombreTipoUsuario());
        }
        return nombresTipoUsuario;
    }

}

