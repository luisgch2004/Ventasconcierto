/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.Ventana1;
import Vista.Ventana2;
import Vista.Ventana3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.text.AsyncBoxView;
import modelo.Concierto;
import modelo.ConciertoArreglo;
import modelo.Entrada;
import modelo.Persona;
import modelo.PersonaArreglo;
import modelo.Tarjeta;
import modelo.Venta;
import modelo.VentaArreglo;
import modelo.Zona;
    
public class Controlador {
    private Persona persona;
    private Concierto concierto;
    private Entrada entrada;
    private Tarjeta tarjeta;
    private Venta venta;
    private Zona zona;
    private PersonaArreglo personas;
    private ConciertoArreglo conciertos;
    private VentaArreglo ventas;
    private Ventana1 vista;
    private Ventana2 vista2;
    private Ventana3 vista3;

    public Controlador(Persona persona, Concierto concierto, Entrada entrada, Tarjeta tarjeta, Venta venta, Zona zona, PersonaArreglo personas, ConciertoArreglo conciertos, VentaArreglo ventas, Ventana1 vista, Ventana2 vista2, Ventana3 vista3) {
        this.persona = persona;
        this.concierto = concierto;
        this.entrada = entrada;
        this.tarjeta = tarjeta;
        this.venta = venta;
        this.zona = zona;
        this.personas = personas;
        this.conciertos = conciertos;
        this.ventas = ventas;
        this.vista = vista;
        this.vista2 = vista2;
        this.vista3 = vista3;
        
        Zona zona1 = new Zona("Platinum", 50, 550);
        Zona zona2 = new Zona("VIP", 50, 400);
        Zona zona3 = new Zona("General", 50, 250);
        zona1.generarEntradas();
        zona2.generarEntradas();
        zona3.generarEntradas();
        concierto.agregarZona(zona1);
        concierto.agregarZona(zona2);
        concierto.agregarZona(zona3);
        
        this.vista.btnRegistroPersona.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.nombrePersona.getText();
                String apellido = vista.apellidosPersona.getText();
                String dni = vista.dniPersona.getText();
                String contraseña = vista.contraseñaPersona.getText();
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Error al registrar, por favor llene todos los campos");
                }else{
                    persona.setNombre(vista.nombrePersona.getText());
                    persona.setApellidos(vista.apellidosPersona.getText());
                    persona.setDni(vista.dniPersona.getText());
                    persona.setContraseña(vista.contraseñaPersona.getText());
                    personas.agregarPersonas(persona);
                    vista.setVisible(false);
                    vista2.setLocationRelativeTo(null);
                    vista2.setVisible(true);
                    JOptionPane.showMessageDialog(vista2, "Registro exitoso");
                }
                
            }
        });
        
        this.vista.btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = vista.inicioDni.getText();
                String contraseña = vista.inicioContraseña.getText();
                if (personas.buscarPersonaPorDniYContraseña(dni, contraseña) != false) {
                    vista.setVisible(false);
                    vista2.setLocationRelativeTo(null);
                    vista2.setVisible(true);
                    JOptionPane.showMessageDialog(vista2, "Inicio de Sesion exitoso");
                }else{
                    JOptionPane.showMessageDialog(vista, "Error al iniciar sesion");
                }
            }
        });
        
        this.vista2.btnTarjeta.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTarjeta= vista2.nombreTarjeta.getText();
                String numeroTarjeta = vista2.numeroTarjeta.getText();
                String CVVTarjeta = vista2.CVVTarjeta.getText();
                String fechaTarjeta = vista2.fechaTarjeta.getText();
                if (nombreTarjeta.isEmpty() || numeroTarjeta.isEmpty()|| CVVTarjeta.isEmpty() || fechaTarjeta.isEmpty()) {
                    JOptionPane.showMessageDialog(vista2, "Error al registrar, por favor llene todos los campos");
                }else{
                    tarjeta.setNombre(nombreTarjeta);
                    tarjeta.setNumero(Integer.parseInt(numeroTarjeta));
                    tarjeta.setCVV(Integer.parseInt(CVVTarjeta));
                    tarjeta.setFecha(fechaTarjeta);
                    persona.registrarTarjeta(tarjeta);
                    JOptionPane.showMessageDialog(vista2, "Registro exitoso");
                }
            }
        });
        
        this.vista2.btnAnularTarjeta.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarjeta.setNombre(vista2.NombreAnulacionTarjeta.getText());
                tarjeta.setNumero(Integer.parseInt(vista2.numeroAnularTarjeta.getText()));
                tarjeta.setCVV(Integer.parseInt(vista2.CVVAnulacionTarjeta.getText()));
                tarjeta.setFecha(vista2.FechaAnulacionTarjeta.getText());
                persona.eliminarTarjeta(tarjeta);
                JOptionPane.showMessageDialog(vista2, "Anulacion exitosa");
            }
        });
        this.vista2.irVentana3.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               vista2.setVisible(false);
               vista3.setLocationRelativeTo(null);
               vista3.setVisible(true);
            }
        });
        
        this.vista2.volverVentana1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista2.setVisible(false);
                vista.setLocationRelativeTo(null);
                vista.setVisible(true);
            }
        });
        
        this.vista3.volverVentana2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista3.setVisible(false);
                vista2.setLocationRelativeTo(null);
                vista2.setVisible(true);
            }
        });
        
        this.vista3.btnComprarEntrada.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroEntrada = Integer.parseInt(vista3.numeroEntrada.getText());
                    String fechaEntrada = vista3.FechaEntrada.getText();
                    int montoEntrada = Integer.parseInt(vista3.montoEntreada.getText());
                    
                    Zona zona = concierto.obtenerZona(vista3.ZonaTipo.getToolTipText());
                    Entrada entrada = zona.venderEntrada(numeroEntrada);
                    
                    if("disponible".equals(entrada.getEstado())){
                        JOptionPane.showMessageDialog(vista3, "Entrada no disponible");
                    }else{
                        Venta venta = new Venta (fechaEntrada, montoEntrada, entrada);
                        persona.comprar(venta);
                        vista3.IndiceEntradasVenta.setText(String.valueOf(ventas.getIndice()));
                        JOptionPane.showMessageDialog(vista3, "compra exitosa");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista3, "No se pudo realizar la venta");  
                }
            }
        });
        
        this.vista3.btnAnular.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(vista3.IndiceEntrada.getText());
                    boolean anularVenta = persona.anularVenta(numero);
                    if (anularVenta) {
                        JOptionPane.showMessageDialog(vista3, "Anulacion exitosa"); 
                    }else{
                        JOptionPane.showMessageDialog(vista3, "No se encontro el boleto a anular");
                    }   
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista3, "Error al buscar");
                }
            }
        });
    }

    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    public Ventana1 getVista() {
        return vista;
    }

    public void setVista(Ventana1 vista) {
        this.vista = vista;
    }

    public Ventana2 getVista2() {
        return vista2;
    }

    public void setVista2(Ventana2 vista2) {
        this.vista2 = vista2;
    }

    public Ventana3 getVista3() {
        return vista3;
    }

    public void setVista3(Ventana3 vista3) {
        this.vista3 = vista3;
    }
    
}



