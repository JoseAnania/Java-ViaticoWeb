
package Modelo;

public class Empleado {
    
    private int legajo;
    private String nombre;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado() {
    }

    public Empleado(int legajo, String nombre) {
        this.legajo = legajo;
        this.nombre = nombre;
    }
    
}
