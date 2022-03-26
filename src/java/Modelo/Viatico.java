
package Modelo;


public class Viatico {
    
    private int idViatico;
    private int legajo;
    private String concepto;
    private float importe;

    public int getIdViatico() {
        return idViatico;
    }

    public void setIdViatico(int idViatico) {
        this.idViatico = idViatico;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public Viatico() {
    }

    public Viatico(int idViatico, int legajo, String concepto, float importe) {
        this.idViatico = idViatico;
        this.legajo = legajo;
        this.concepto = concepto;
        this.importe = importe;
    }
    
}
