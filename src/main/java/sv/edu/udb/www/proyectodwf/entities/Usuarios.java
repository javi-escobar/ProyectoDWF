package sv.edu.udb.www.proyectodwf.entities;

import jakarta.persistence.*;

@Entity
public class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    @Basic
    @Column(name = "correo_electronico", nullable = true, length = 100)
    private String correoElectronico;
    @Basic
    @Column(name = "contrasena", nullable = true, length = 50)
    private String contrasena;
    @Basic
    @Column(name = "tipo_usuario_id", nullable = true)
    private Integer tipoUsuarioId;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }
}
