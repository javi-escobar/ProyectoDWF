package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_evento", schema = "dwf_proyecto", catalog = "")
public class TipoEvento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tipo_evento_id", nullable = false)
    private int tipoEventoId;
    @Basic
    @Column(name = "nombre_tipo_evento", nullable = true, length = 100)
    private String nombreTipoEvento;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    public int getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(int tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public String getNombreTipoEvento() {
        return nombreTipoEvento;
    }

    public void setNombreTipoEvento(String nombreTipoEvento) {
        this.nombreTipoEvento = nombreTipoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
