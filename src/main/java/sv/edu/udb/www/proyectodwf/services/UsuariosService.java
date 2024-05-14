package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.Usuarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsuariosService {

    @PersistenceContext
    private EntityManager entityManager;

    public void guardarUsuario(Usuarios usuario) {
        entityManager.persist(usuario);
    }

    public Usuarios buscarUsuarioPorId(int usuarioId) {
        return entityManager.find(Usuarios.class, usuarioId);
    }

    public void actualizarUsuario(Usuarios usuario) {
        entityManager.merge(usuario);
    }

    public void eliminarUsuario(int usuarioId) {
        Usuarios usuario = entityManager.find(Usuarios.class, usuarioId);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    public List<Usuarios> listarUsuarios() {
        TypedQuery<Usuarios> query = entityManager.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
        return query.getResultList();
    }

    public List<Usuarios> listarUsuarioOrganizador() {
        TypedQuery<Usuarios> query = entityManager.createQuery(
                "SELECT u FROM Usuarios u WHERE u.tipoUsuarioId = 2", Usuarios.class);
        return query.getResultList();
    }

    public Map<Integer, String> listarNombreUsuarios() {
        TypedQuery<Usuarios> query = entityManager.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
        List<Usuarios> usuarios = query.getResultList();
        Map<Integer, String> nombresUsuarios = new HashMap<>();
        for (Usuarios usuario : usuarios) {
            nombresUsuarios.put(usuario.getUsuarioId(), usuario.getNombre());
        }
        return nombresUsuarios;
    }

}

