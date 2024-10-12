/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

public class Persona {
    String nombre;
    String apellidos;
    String dni;
    String contraseña;
    Tarjeta tarjeta;
    Venta[] venta;
    
    public Persona(String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.tarjeta = null;
        this.venta = new Venta[4];
    }
    public boolean registrarTarjeta(Tarjeta tarjeta){
        boolean result = false;
        if(this.tarjeta == null && tarjeta != null){
            this.tarjeta = tarjeta;
            result = true;
        }
        return result;
    }
    
    public boolean eliminarTarjeta(Tarjeta tarjeta){
        boolean result = false;
            if(this.tarjeta == null && tarjeta == this.tarjeta){
                this.tarjeta = null;
                result = true;
            }
        return result;
    }
    
    public boolean anularVenta(int indice){
        boolean result = false;
        if(indice >= 0 && indice<this.venta.length && this.venta[indice] != null){
            this.venta[indice].anular();
            this.venta[indice] = null;
            result = true;
        }
        return result;
    }
    
    public boolean comprar(Venta venta){
        boolean result = false;
        if(tarjeta != null){
            for(int i=0; i<this.venta.length; i++){
                if(this.venta[i] == null){
                    this.venta[i] = venta;
                    result = true;
                }
            }
        }
        return result;
    }
    
    public void mostrarPersona(){
        System.out.println("nombres: " + nombre);
        System.out.println("apellidos: " +apellidos);
        System.out.println("dni: " + dni);
        if(tarjeta == null){
            System.out.println("No existe ninguna tarjeta");
        }else{
            System.out.println("Tarjeta: " + tarjeta);
        }
    }
}
