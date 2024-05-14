package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Eventos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "evento_id", nullable = false)
    private int eventoId;
    @Basic
    @Column(name = "nombre_evento", nullable = true, length = 100)
    private String nombreEvento;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;
    @Basic
    @Column(name = "tipo_evento_id", nullable = true)
    private Integer tipoEventoId;
    @Basic
    @Column(name = "ubicacion", nullable = true, length = 100)
    private String ubicacion;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;
    @Basic
    @Column(name = "hora", nullable = true, length = 5)
    private String hora;
    @Basic
    @Column(name = "capacidad", nullable = true)
    private Integer capacidad;
    @Basic
    @Column(name = "precio", nullable = true, precision = 2)
    private BigDecimal precio;
    @Basic
    @Column(name = "empresa_id", nullable = true)
    private Integer empresaId;
    @Basic
    @Column(name = "estado_id", nullable = true)
    private Integer estadoId;

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipoEventoId() {
        return tipoEventoId;
    }

    public void setTipoEventoId(Integer tipoEventoId) {
        this.tipoEventoId = tipoEventoId;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }
}
