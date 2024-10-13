package modelo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        Persona persona = new Persona();
        
        ConciertoArreglo conciertoArreglo = new ConciertoArreglo(1);
        PersonaArreglo personaArreglo = new PersonaArreglo(100);
        VentaArreglo ventaArreglo = new VentaArreglo(50);
        
        boolean salir = false;
        while(!salir){
            System.out.println("-----------------------");
            System.out.println(" || GESTOR DE VENTA || ");
            System.out.println("-----------------------");
            System.out.print("""
                               1. Registrar Venta
                               2. Anular Venta
                               3. Salir del programa
                               Eliga una opcion:\s""");
            int opcion = Integer.parseInt(consola.nextLine()); 
            
            switch(opcion){
                case 1 ->{
                    boolean salirRegistrar = false;
                    while(!salirRegistrar){
                        System.out.println("-----------------------");
                        System.out.println(" || REGISTRAR VENTA || ");
                        System.out.println("-----------------------");
                        System.out.print("""
                                           1. Registrar Persona
                                           2. Iniciar Sesion
                                           3. Volver al menu principal
                                           Eliga una opcion:\s""");
                        
                        int opcion2 = Integer.parseInt(consola.nextLine());
                        
                        switch(opcion2){
                            case 1 ->{
                                System.out.println("-------------------------");
                                System.out.println(" || REGISTRAR PERSONA || ");
                                System.out.println("-------------------------");
                                System.out.print("Coloque sus nombres: ");
                                persona.setNombre(consola.nextLine());
                                System.out.print("Coloque sus apellidos: ");
                                persona.setApellidos(consola.nextLine());
                                System.out.print("Coloque su documento de identidad: ");
                                persona.setDni(consola.nextLine()); 
                             
                                personaArreglo.agregarPersonas(persona);
                            }
                            case 2 ->{
                                
                            }
                            case 3 ->{
                                System.out.println("Volviendo al menu principal...");
                                salirRegistrar = true;
                            }
                        }
                    }
                }
                case 2 ->{}
                case 3 ->{
                    System.out.println("Saliendo del programa...");
                    salir = true;
                }
            }
        }
    }
}    


