/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.manejodememoria;

/**
 *
 * @author rodolfo
 */
public class Proceso {
    //Atributos
    private Pagina proceso[];
    private int tamano;
    private int idProceso;

  
    //Constructor de Proceso
    public Proceso(int tamano,int idProceso) {
        this.tamano = tamano;
        this.idProceso = idProceso;
        proceso = new Pagina[tamano];
        for(int i = 0; i < proceso.length ; i++){
            Pagina p = new Pagina(idProceso);
        }
    }

  

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public Pagina[] getProceso() {
        return proceso;
    }

    public void setProceso(Pagina[] proceso) {
        this.proceso = proceso;
    }
    
   
    
    
    
    
    
    
}
