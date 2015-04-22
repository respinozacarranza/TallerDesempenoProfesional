package pe.com.tizen.login.entity;

/**
 * Created by Alumnos on 21/04/2015.
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
