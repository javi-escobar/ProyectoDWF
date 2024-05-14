package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_usuario", schema = "dwf_proyecto", catalog = "")
public class TipoUsuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tipo_usuario_id", nullable = false)
    private int tipoUsuarioId;
    @Basic
    @Column(name = "nombre_tipo_usuario", nullable = true, length = 100)
    private String nombreTipoUsuario;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
