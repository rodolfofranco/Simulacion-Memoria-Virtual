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
public class Memoria {
    //Atributos
    private int marcoPagina;
    private int memoria[];
    private int tamano;
    private boolean disponible = false;
    private String tipo;
    private boolean marcosDisponibles[];
    
    //Constructor de Memoria
    public Memoria(int marcoPagina, int tamano, String tipo, boolean[] marcosDisponibles) {
        this.marcoPagina = marcoPagina;
        this.tamano = tamano;
        this.tipo = tipo;
        this.marcosDisponibles = marcosDisponibles;
        memoria = new int[marcoPagina];
        
    }

    public int getMarcoPagina() {
        return marcoPagina;
    }
    
    
    
    public void setMemoriaLIBRE(){
        for(int i = 0 ; i < marcosDisponibles.length ; i++){
            marcosDisponibles[i] = false;
        }
    }
    
    public int checkMarcosDisponibles(){
        int cantidad=0;
        for(int i = 0 ; i < marcosDisponibles.length ; i++){
              if(marcosDisponibles[i]==false){
                  cantidad++;
              }
        }
        return cantidad;
    }
    
    public int checkMarcosUsadosID(int id){
        int cantidad = 0;
        for(int i = 0 ; i < memoria.length; i++){
            if(memoria[i] == id){
                cantidad++;
            }
        }
        return cantidad;
    }
    
    public void almacenarProceso(int numPagina,int id){
        int cont=0;
        for(int i = 0; i < memoria.length ; i++){
            
            
            if(marcosDisponibles[i] == false){
            memoria[i] = id;
            marcosDisponibles[i] = true;
            cont++;
            }
            if(cont == numPagina){
                break;
            }
            
        }
      }
    
    public void eliminarProceso(int numPagina,int id){
        int cont = 0;
        
        if(numPagina == 0 ){
        for(int i = 0 ; i < memoria.length ; i++){
            if(memoria[i] == id){
                marcosDisponibles[i] = false;
                memoria[i] = 0;
            }
        }
        }
        else{
            for(int i = 0 ; i < memoria.length ; i++){
                if(memoria[i] == id){
                    marcosDisponibles[i]=false;
                    memoria[i]=0;
                    cont++;
                }
                if(cont == numPagina){
                    break;
                }
            }
        }
        
        
    }
    
     
    
    public int parearTabla(String[] vecMem,int id,int cont,int[] vecPag){
        
        for(int i = 0; i < memoria.length ; i ++){
            if(memoria[i]==id){
                if("principal".equals(tipo)){
                   vecMem[cont]= "P";
                   vecPag[cont]= i;
                   cont++;
                }
                else{
                    vecMem[cont] = "S";
                    vecPag[cont]= i;
                    cont++;
                }
            }
        }
        return cont;
    }
    
    
    
    public void showMemoria(){
        System.out.println(tipo);
        for(int i = 0 ; i < memoria.length ; i++){
            System.out.println("Posicion "+i+":  Proceso:"+memoria[i]);
        }
    }
    
    public int memoriaDisponible(){
        int disponibles = checkMarcosDisponibles();
        return disponibles*1024;
    }
    
    public int memoriaUtilizada(){
        int disponibles = checkMarcosDisponibles();
        return marcoPagina - disponibles;   
    }
    

   
    
    
    
    
    
    
}
