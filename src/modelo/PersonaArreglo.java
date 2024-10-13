/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class PersonaArreglo {
    private int indice;
    private Persona[] persona;

    public PersonaArreglo(int aforo) {
        this.indice = 0;
        this.persona = new Persona[aforo];
    }
    
    
    
    public void mostrarPersonaArray(){
        for (int i = 0; i <persona.length; i++) {
            System.out.println("Persona N°" + i+1);
            persona[i].mostrarPersona();
        }
    }
    
    public void agregarPersonas(Persona persona){
        if(indice < this.persona.length){
            this.persona[indice] = persona;
            indice++;
        }
    }
    
    public Persona buscarPersonaPorDniYContraseña(String dni, String contraseña){
        for(int i = 0; i < indice; i++){
            if(this.persona[i].getDni().equals(dni) && this.persona[i].getContraseña().equals(contraseña)){
                return this.persona[i];
            }
        }
        return null;
    }

    
    public Persona buscarPersonaPorDni(String dni){
        for(int i = 0; i < indice; i++){
            if(this.persona[i].getDni().equals(dni)){
                return this.persona[i];
            }
        }
        return null;
    }
}

