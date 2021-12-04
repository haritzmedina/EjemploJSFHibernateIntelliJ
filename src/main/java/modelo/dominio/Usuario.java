package modelo.dominio;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    private String nombre;
    private String password;
    private String tipo;
    public Usuario(){

    }
    public String getTipo() {
        return tipo; }
    public void setTipo(String tipo) {
        this.tipo = tipo; }
    public String getNombre() {
        return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
    public String getPassword() {
        return password; }
    public void setPassword(String password) {
        this.password = password; }

    public String toString() { // Usuario
        return nombre+"/"+password+"/"+tipo;
    }
}
