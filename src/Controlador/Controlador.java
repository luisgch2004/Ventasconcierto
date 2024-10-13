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
        
        
        this.vista.btnRegistroPersona.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(vista.nombrePersona.getText());
                persona.setApellidos(vista.apellidosPersona.getText());
                persona.setDni(vista.dniPersona.getText());
                persona.setContraseña(vista.contraseñaPersona.getText());
                personas.agregarPersonas(persona);
                vista.setVisible(false);
                vista2.setLocationRelativeTo(null);
                vista2.setVisible(true);
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
        
        this.vista.btnTarjeta.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarjeta.setNombre(vista2.nombreTarjeta.getText());
                tarjeta.setNumero(Integer.parseInt(vista2.numeroTarjeta.getText()));
                tarjeta.setCVV(Integer.parseInt(vista2.CVVTarjeta.getText()));
                tarjeta.setFecha(vista2.fechaTarjeta.getText());
                persona.registrarTarjeta(tarjeta);
                JOptionPane.showMessageDialog(vista2, "Registro exitoso");
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
                zona.setNombre(vista3.ZonaTipo.getToolTipText());
                entrada.setNumero(Integer.parseInt(vista3.numeroEntrada.getText()));
                venta.setFecha(vista3.FechaEntrada.getText());
                venta.setMonto(Integer.parseInt(vista3.montoEntreada.getText()));
                zona.venderEntrada(entrada.getNumero());
                persona.comprar(venta);
                JOptionPane.showMessageDialog(vista3, "Compra existosa");
            }
        });
        
        this.vista3.btnAnular.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int numero = Integer.parseInt(vista3.IndiceEntrada.getText());
               persona.anularVenta(numero);
               JOptionPane.showMessageDialog(vista3, "Anulacion exitosa");
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



