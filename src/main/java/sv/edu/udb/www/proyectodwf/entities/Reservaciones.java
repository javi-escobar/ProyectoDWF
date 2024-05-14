package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Reservaciones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservacion_id", nullable = false)
    private int reservacionId;
    @Basic
    @Column(name = "evento_id", nullable = true)
    private Integer eventoId;
    @Basic
    @Column(name = "usuario_id", nullable = true)
    private Integer usuarioId;
    @Basic
    @Column(name = "nombre_contacto", nullable = true, length = 100)
    private String nombreContacto;
    @Basic
    @Column(name = "correo_electronico", nullable = true, length = 100)
    private String correoElectronico;
    @Basic
    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;
    @Basic
    @Column(name = "cantidad_cupos", nullable = true)
    private Integer cantidadCupos;
    @Basic
    @Column(name = "total_pagar", nullable = true, precision = 2)
    private BigDecimal totalPagar;

    public int getReservacionId() {
        return reservacionId;
    }

    public void setReservacionId(int reservacionId) {
        this.reservacionId = reservacionId;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCantidadCupos() {
        return cantidadCupos;
    }

    public void setCantidadCupos(Integer cantidadCupos) {
        this.cantidadCupos = cantidadCupos;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }
}
