/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Date;
/**
 *
 * @author OCA-UIE
 */
public class Venta {
    private Date fecha;
    private int monto;
    private Entrada entrada;

    public Venta(Date fecha, int monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public Venta() {
    }
    
    public Date getFecha() {
        return fecha;
    }

    public int getMonto() {
        return monto;
    }
    
    public boolean anular(){
        return entrada.liberar();
    }

    public Entrada getEntrada() {
        return entrada;
    }
    
    public int getNumero(){
        return entrada.getNumero();
    }
    
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
