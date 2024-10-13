import Vista.Ventana1;
import Vista.Ventana2;
import Vista.Ventana3;
import modelo.Concierto;
import modelo.ConciertoArreglo;
import modelo.Entrada;
import modelo.Persona;
import modelo.PersonaArreglo;
import modelo.Tarjeta;
import modelo.Venta;
import modelo.VentaArreglo;
import modelo.Zona;
import Controlador.Controlador;
import java.time.LocalDate;
public class App {

    public static void main(String[] args) {
        Ventana1 vista1 = new Ventana1();
        Ventana2 vista2 = new Ventana2();
        Ventana3 vista3 = new Ventana3();
        ConciertoArreglo conciertos = new ConciertoArreglo(1);
        PersonaArreglo personas = new PersonaArreglo(150);
        VentaArreglo ventas = new VentaArreglo(150);
        Concierto concierto = new Concierto("Grupo 5", 2024/10/14);
        Persona persona = new Persona();
        Tarjeta tarjeta = new Tarjeta();
        Entrada entrada = new Entrada();
        Venta venta = new Venta();
        Zona zona = new Zona();
        Controlador controlador = new Controlador(persona, concierto, entrada, tarjeta, venta, zona, personas, conciertos, ventas, vista1, vista2, vista3);
        controlador.iniciar();
    }
    
}
