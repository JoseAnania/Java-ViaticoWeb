
package Dto;

public class EmpleadoDto {
    
    private String nombre;
    private String concepto;
    private float importe;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public EmpleadoDto() {
    }

    public EmpleadoDto(String nombre, String concepto, float importe) {
        this.nombre = nombre;
        this.concepto = concepto;
        this.importe = importe;
    }
    
}
