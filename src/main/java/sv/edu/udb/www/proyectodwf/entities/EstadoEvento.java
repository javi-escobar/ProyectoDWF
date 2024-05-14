package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_evento", schema = "dwf_proyecto", catalog = "")
public class EstadoEvento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "estado_id", nullable = false)
    private int estadoId;
    @Basic
    @Column(name = "estado", nullable = true, length = 20)
    private String estado;

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
