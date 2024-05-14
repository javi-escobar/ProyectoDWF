package sv.edu.udb.www.proyectodwf.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.www.proyectodwf.entities.Empresas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmpresasService {
    @PersistenceContext
    private EntityManager entityManager;

    public void guardarEmpresa(Empresas empresa) {
        entityManager.persist(empresa);
    }

    public Empresas buscarEmpresaPorId(int empresaId) {
        return entityManager.find(Empresas.class, empresaId);
    }

    public void actualizarEmpresa(Empresas empresa) {
        entityManager.merge(empresa);
    }

    public void eliminarEmpresa(int empresaId) {
        Empresas empresa = entityManager.find(Empresas.class, empresaId);
        if (empresa != null) {
            entityManager.remove(empresa);
        }
    }

    public List<Empresas> listarEmpresas() {
        TypedQuery<Empresas> query = entityManager.createQuery("SELECT e FROM Empresas e", Empresas.class);
        return query.getResultList();
    }

    public Map<Integer, String> obtenerNombresEmpresas() {
        Map<Integer, String> nombresEmpresas = new HashMap<>();
        List<Empresas> empresas = listarEmpresas();
        for (Empresas empresa : empresas) {
            nombresEmpresas.put(empresa.getEmpresaId(), empresa.getNombreEmpresa());
        }
        return nombresEmpresas;
    }
}
