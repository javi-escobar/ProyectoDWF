package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

@Entity
public class Empresas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "empresa_id", nullable = false)
    private int empresaId;
    @Basic
    @Column(name = "nombre_empresa", nullable = true, length = 100)
    private String nombreEmpresa;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;
    @Basic
    @Column(name = "representante_id", nullable = true)
    private Integer representanteId;

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRepresentanteId() {
        return representanteId;
    }

    public void setRepresentanteId(Integer representanteId) {
        this.representanteId = representanteId;
    }
}
