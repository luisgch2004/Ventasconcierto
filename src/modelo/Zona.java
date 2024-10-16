/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OCA-UIE
 */
public class Zona {
    private String nombre;
    private int capacidad;
    private int precio;
    private Entrada[] entradas;

    public Zona(String nombre, int capacidad, int precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.entradas = new Entrada[capacidad];
        generarEntradas();
        
    }

    public Zona() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public boolean generarEntradas(){
        boolean resultado =true;
        for(int i=0; i< this.capacidad; i++){
            this.entradas[i] = new Entrada(i+1);
        }
        return resultado;
    }
    
    public Entrada venderEntrada(int numero){
        if(this.entradas[numero-1].disponible()){
            this.entradas[numero-1].vender();
            return this.entradas[numero-1];
        }else{
            return null;
        }
    }
    
    public Entrada mostrarEntrada(int numero){
        return this.entradas[numero-1];
    }   
}
