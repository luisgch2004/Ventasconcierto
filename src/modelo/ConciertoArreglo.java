/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class ConciertoArreglo{
    private int indice;
    private Concierto[] concierto;

    public ConciertoArreglo(int aforoConcierto) {
        this.indice = 0;
        this.concierto = new Concierto[aforoConcierto];
    }
    
    public boolean agregarConcierto(Concierto concierto){
        boolean result = false;
        if(indice < this.concierto.length){
            this.concierto[indice] = concierto;
            indice++;
            result = true;
        }
        return result;
    }
    public Concierto obtenerConcierto(int index) {
        if (index >= 0 && index < indice) {
            return concierto[index];
        }
        return null;
    }
    
}
