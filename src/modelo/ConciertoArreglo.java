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
    
    public void agregarConcierto(Concierto concierto){
        if(indice < this.concierto.length){
            this.concierto[indice] = concierto;
            indice++;
        }
    }
}
