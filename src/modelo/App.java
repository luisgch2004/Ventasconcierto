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
        
        
        Tarjeta tarjeta= new Tarjeta ();
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
                                persona.setTarjeta(null);
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
                                                limpiarPantalla();
                                                System.out.println("-----------------------");
                                                System.out.println(" || COMPRAR ENTRADA || ");
                                                System.out.println("-----------------------");

    
                                                if(persona.getTarjeta()==null){
                                                    System.out.println("Por favor, registre su tarjeta.");
                                                    System.out.println("Ingrese el numero de tarjeta: ");
                                                    tarjeta.setNumero(consola.nextLine());
                                                    System.out.println("Ingrese el nombre del titular: ");
                                                    tarjeta.setNombre(consola.nextLine());
                                                    System.out.println("Ingrese la fecha de expiracion (yyyy-MM-dd): ");
                                                    tarjeta.setFecha(consola.nextLine());
                                                    System.out.println("Ingrese el CVV: ");
                                                    tarjeta.setCVV(consola.nextInt());
                                                     consola.nextLine();
                                                    persona.registrarTarjeta(tarjeta);
                                                    System.out.println("Resgistro de tarjeta exitoso!!!");
                                                    System.out.println("");
                                                    System.out.println("");
                                                    
                                                    //  el array de ventas no sea null
                                                    if (persona.getVenta() == null) {
                                                        persona.setVenta(new Venta[4]); //  inicializado
                                                    }

                                                    Zona[] zonas = concierto.getZonas();
                                                    System.out.println("-------------");
                                                    System.out.println(" || ZONAS || ");
                                                    System.out.println("-------------");

                                                    for (int i = 0; i < zonas.length; i++) {
                                                        if (zonas[i] != null) {
                                                            System.out.println((i + 1) + ". " + zonas[i].getNombre() +
                                                                " - Capacidad: " + zonas[i].getCapacidad() +
                                                                " - Precio: " + zonas[i].getPrecio());
                                                        }
                                                    }

                                                    System.out.print("Seleccione una zona: ");
                                                    int zonaSeleccionada = Integer.parseInt(consola.nextLine()) - 1;

                                                    if (zonaSeleccionada >= 0 && zonaSeleccionada < zonas.length) {
                                                        Zona zonaElegida = zonas[zonaSeleccionada];

                                                       
                                                        if (zonaElegida.getCapacidad() > 0) {
                                                            //  límite de 4 entradas
                                                            Venta[] ventasPersona = persona.getVenta();
                                                            int contadorEntradas = 0;
                                                            for (Venta venta : ventasPersona) {
                                                                if (venta != null) {
                                                                    contadorEntradas++;
                                                                }
                                                            }

                                                            if (contadorEntradas < 4) {
                                                                Date fechaVenta = new Date(); 
                                                                Venta nuevaVenta = new Venta(fechaVenta, zonaElegida.getPrecio());
                                                                ventaArreglo.agregarVentas(nuevaVenta);

                                                                
                                                                zonaElegida.setCapacidad(zonaElegida.getCapacidad() - 1);

                                                                
                                                                if (persona.comprar(nuevaVenta)) {
                                                                    System.out.println("Compra exitosa. ¡Disfruta del concierto en la " + zonaElegida.getNombre() + "!");
                                                                } else {
                                                                    System.out.println("Error al registrar la compra. Verifique la tarjeta asociada.");
                                                                    
                                                                    zonaElegida.setCapacidad(zonaElegida.getCapacidad() + 1);
                                                                }
                                                            } else {
                                                                System.out.println("Lo sentimos, ya has alcanzado el límite de 4 entradas por persona.");
                                                            }
                                                        } else {
                                                            System.out.println("Lo sentimos, la zona seleccionada ya no tiene entradas disponibles.");
                                                        }
                                                    } else {
                                                        System.out.println("Zona no válida. Por favor, intente nuevamente.");
                                                    }
                                                }else {
                                                    System.out.println("");
                                                    System.out.println("Usted ya tiene una tarjeta registrada, puede continuar con la compra");
                                                    System.out.println("");
                                                    if (persona.getVenta() == null) {
                                                        persona.setVenta(new Venta[4]); //  inicializado
                                                    }

                                                    
                                                    Zona[] zonas = concierto.getZonas();
                                                    System.out.println("-------------");
                                                    System.out.println(" || ZONAS || ");
                                                    System.out.println("-------------");

                                                    for (int i = 0; i < zonas.length; i++) {
                                                        if (zonas[i] != null) {
                                                            System.out.println((i + 1) + ". " + zonas[i].getNombre() +
                                                                " - Capacidad: " + zonas[i].getCapacidad() +
                                                                " - Precio: " + zonas[i].getPrecio());
                                                        }
                                                    }

                                                    System.out.print("Seleccione una zona: ");
                                                    int zonaSeleccionada = Integer.parseInt(consola.nextLine()) - 1;

                                                    if (zonaSeleccionada >= 0 && zonaSeleccionada < zonas.length) {
                                                        Zona zonaElegida = zonas[zonaSeleccionada];

                                                        
                                                        if (zonaElegida.getCapacidad() > 0) {
                                                            //  límite de 4 entradas
                                                            Venta[] ventasPersona = persona.getVenta();
                                                            int contadorEntradas = 0;
                                                            for (Venta venta : ventasPersona) {
                                                                if (venta != null) {
                                                                    contadorEntradas++;
                                                                }
                                                            }

                                                            if (contadorEntradas < 4) {
                                                                Date fechaVenta = new Date();
                                                                Venta nuevaVenta = new Venta(fechaVenta, zonaElegida.getPrecio());
                                                                ventaArreglo.agregarVentas(nuevaVenta);

                                                                zonaElegida.setCapacidad(zonaElegida.getCapacidad() - 1);

                                                                if (persona.comprar(nuevaVenta)) {
                                                                    System.out.println("Compra exitosa. ¡Disfruta del concierto en la " + zonaElegida.getNombre() + "!");
                                                                } else {
                                                                    System.out.println("Error al registrar la compra. Verifique la tarjeta asociada.");
                                                                    zonaElegida.setCapacidad(zonaElegida.getCapacidad() + 1);
                                                                }
                                                            } else {
                                                                System.out.println("Lo sentimos, ya has alcanzado el límite de 4 entradas por persona.");
                                                            }
                                                        } else {
                                                            System.out.println("Lo sentimos, la zona seleccionada ya no tiene entradas disponibles.");
                                                        }
                                                    } else {
                                                        System.out.println("Zona no válida. Por favor, intente nuevamente.");
                                                    }
                                                }
                                                System.out.println("Pulse Enter para continuar...");
                                                consola.nextLine();
                                            }
                                            case 3 -> {
                                                System.out.println("Regresando al menu anterior...");
                                                salirSesion = true;
                                            }
                                        } // FIN SWITCH TERCIARIO
                                        
                                    } else {
                                        System.out.println("DNI o contraseña incorrectos.");
                                        salirSesion = true;
                                    } // FIN CONDICIONAL IF ELSE 
                                }// FIN WHILE TERCIARIO
                                
                            }
                            case 3 -> {
                                System.out.println("Volviendo al menu principal...");
                                salirRegistrar = true;
                                limpiarPantalla();
                            }
                        }// FIN SWITCH SECUNDARIO
                    }// FIN WHILE SECUNDARIO
                }//FIN CASE 1
                case 2 -> {
                    
                }
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    limpiarPantalla();
                }
            }//FIN SWITCH PRINCIPAL
        }//FIN WHILE PRINCIPAL
    }
    
    
    public static void limpiarPantalla(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }
    
}