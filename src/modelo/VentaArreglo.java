/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class VentaArreglo {
    private int indice;
    private Venta[] venta;
    private Entrada entrada;

    public VentaArreglo(int nrventas) {
        this.indice = 0;
        this.venta = new Venta[nrventas];
    }
    
    void agregarVentas(Venta venta){
       if(indice < this.venta.length){
           this.venta[indice] = venta;
           indice++;
       }
    }
    
    public Venta obtenerVenta(int index) {
        if (index >= 0 && index < indice) {
            return venta[index];
        }
        return null;
    }
    
}
