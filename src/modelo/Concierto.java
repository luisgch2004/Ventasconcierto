/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Scanner;
import java.util.Date;

public class Concierto{
    private String nombreConcierto;
    private Date fecha;
    private Zona[] zona;


    public Concierto(String nombreConcierto, Date fecha){
        this.nombreConcierto = nombreConcierto;
        this.fecha = fecha;
        this.zona = new Zona[3];
    }

    public boolean agregarZona(Zona nuevaZona) {
    for (int i = 0; i < this.zona.length; i++) {
        if (this.zona[i] == null) {  
            this.zona[i] = nuevaZona;  
            return true;  
        }
    }
    return false;  
}

    public boolean eliminarZona(Zona zona){
        boolean result = false;
        for (int i = 0; i < 10; i++) {
            if(this.zona[i] == zona){
                this.zona[i] = null;
                result = true;
            }
        }
        return result;
    }

    public Zona[] getZonas() {
        return this.zona;  
    }
    
    @Override
    public String toString() {
        return  "\nNombre del Concierto: " + nombreConcierto + ", "
                + "\nfecha: " + fecha + '}';   
    }
    
    
}
