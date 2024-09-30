/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Scanner;
import java.util.Date;

public class Concierto {
    private String nombreConcierto;
    private Date fecha;
    private Zona zona;

    Scanner consola = new Scanner(System.in);

    public Concierto(){
    }

    public Concierto(String nombreConcierto, Date fecha, String nombre, int capacidad, int precio){
        this.nombreConcierto = nombreConcierto;
        this.fecha = fecha;
        this.zona = new Zona(nombre, capacidad, precio);
    }

    public boolean agregarZona(){
        System.out.print("Coloque el nombre de la zona: ");
        zona.setNombre(consola.nextLine());
        System.out.print("Coloque su capacidad: ");
        zona.setCapacidad(Integer.parseInt(consola.nextLine()));
        System.out.print("Coloque el precio de la entrada: s/");
        zona.setPrecio(Integer.parseInt(consola.nextLine()));
        return true;
    }

    public boolean eliminarZona(){
        System.out.print("Coloque el nombre de la zona a eliminar: ");
        String zonaEliminar = consola.nextLine();

        if(zona.getNombre().equals(zonaEliminar)){
            System.out.println("Se ha eliminado la zona...");
        } else{
            System.out.println("Zona no existente o invalida...");
        }
            return true;
    }
}
