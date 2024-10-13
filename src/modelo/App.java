package modelo;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
       
        String fechaInput = "2024-10-31";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        Concierto concierto = new Concierto("Grupo 5", fecha);

        Zona zona1 = new Zona("Zona VIP", 100, 500); 
        Zona zona2 = new Zona("Zona General", 200, 300);
        Zona zona3 = new Zona("Zona Economica", 300, 150);
        concierto.agregarZona(zona1);
        concierto.agregarZona(zona2);
        concierto.agregarZona(zona3);

        Persona persona = new Persona();
        PersonaArreglo personaArreglo = new PersonaArreglo(100);
        VentaArreglo ventaArreglo = new VentaArreglo(50);

        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------");
            System.out.println(" || GESTOR DE VENTAS || ");
            System.out.println("-----------------------");
            System.out.print("""
                           1. Registrar Entrada
                           2. Anular Entrada
                           3. Salir del programa
                           Elija una opcion:\s""");
            int opcion = Integer.parseInt(consola.nextLine());

            switch (opcion) {
                case 1 -> {
                    boolean salirRegistrar = false;                      
                    while(!salirRegistrar) {
                        limpiarPantalla();
                        System.out.println("-----------------------");
                        System.out.println(" || REGISTRAR VENTA || ");
                        System.out.println("-----------------------");
                        System.out.print("""
                                       1. Registrar Persona
                                       2. Iniciar Sesion
                                       3. Volver al menu principal
                                       Elija una opcion:\s""");

                        int opcion2 = Integer.parseInt(consola.nextLine());

                        switch (opcion2) {
                            case 1 -> {
                                limpiarPantalla();
                                System.out.println("-------------------------");
                                System.out.println(" || REGISTRAR PERSONA || ");
                                System.out.println("-------------------------");
                                System.out.print("Coloque sus nombres: ");
                                persona.setNombre(consola.nextLine());
                                System.out.print("Coloque sus apellidos: ");
                                persona.setApellidos(consola.nextLine());
                                System.out.print("Coloque su documento de identidad: ");
                                persona.setDni(consola.nextLine());
                                System.out.print("Coloque una contraseña para su sesion: ");
                                persona.setContraseña(consola.nextLine());

                                personaArreglo.agregarPersonas(persona);
                                System.out.println("Se ha registrado a la persona correctamente");
                                System.out.print("Pulse Enter para continuar...");
                                consola.nextLine();
                                limpiarPantalla();
                            }
                            case 2 -> {                         
                                limpiarPantalla();
                                System.out.println("-------------------------");
                                System.out.println(" || INICIAR SESION || ");
                                System.out.println("-------------------------");
                                System.out.print("Ingrese su DNI: ");
                                String dni = consola.nextLine();
                                System.out.print("Ingrese su contraseña: ");
                                String contraseña = consola.nextLine();

                                Persona personaEncontrada = personaArreglo.buscarPersonaPorDniYContraseña(dni, contraseña);
                                
                                boolean salirSesion = false;
                                while (!salirSesion) {     
                                    if(personaEncontrada != null){
                                        
                                        limpiarPantalla();
                                        System.out.println("Inicio de sesion exitoso. ¡Bienvenido, " + personaEncontrada.getNombre() + "!");
                                        System.out.println("");
                                        System.out.println("---------------------");
                                        System.out.println(" || SESION INICIADA ||");
                                        System.out.println("---------------------");
                                        System.out.print("""
                                                       1. Disponibilidad de zona
                                                       2. Comprar Entrada
                                                       3. Regresar al menu anterior
                                                       Elija una opcion:\s""");

                                        int opcion3 = Integer.parseInt(consola.nextLine());
                                        switch (opcion3) {
                                            case 1 -> {
                                                limpiarPantalla();
                                                System.out.println("-------------");
                                                System.out.println(" || ZONAS || ");
                                                System.out.println("-------------");
                                            
                                                System.out.println(concierto.toString());
                                                Zona[] zonas = concierto.getZonas();
                                                for (int i = 0; i < zonas.length; i++) {
                                                    if (zonas[i] != null) {
                                                        System.out.println((i + 1) + ". " + zonas[i].getNombre() + 
                                                            " - Capacidad: " + zonas[i].getCapacidad() + 
                                                            " - Precio: " + zonas[i].getPrecio());
                                                    }
                                                }
                                                System.out.println("Pulse Enter para continuar...");
                                                consola.nextLine();
                                            }
                                            case 2 -> {
                                                // Funcion de comprar la entrada, no me sale y gpt no me entiende
                                            }
                                            case 3 -> {
                                                System.out.println("Regresando al menu anterior...");
                                                salirSesion = true;
                                            }
                                        }
                                        
                                        } else {
                                            System.out.println("DNI o contraseña incorrectos.");
                                            salirSesion = true;
                                        }
                                }
                            }
                            case 3 -> {
                                System.out.println("Volviendo al menu principal...");
                                salirRegistrar = true;
                                limpiarPantalla();
                            }
                        }
                    }
                }
                case 2 -> {
                    // Funcion anular entrada
                }
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    limpiarPantalla();
                }
            }
        }
    }
    
    public static void limpiarPantalla(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
}