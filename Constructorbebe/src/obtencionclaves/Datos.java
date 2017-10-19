/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obtencionclaves;

/**
 *
 * @author Yo
 */

public class Datos {

    private String DatoAcifrar;
    private String ClaveInicialP;   //Clave inicialplana
    private String ClaveInicial;    //Clave inicial en binario

    public String getDatoAcifrar() {
        return DatoAcifrar;
    }

    public void setDatoAcifrar(String DatoAcifrar) {
        this.DatoAcifrar = DatoAcifrar;
    }

    public String getClaveInicialP() {
        return ClaveInicialP;
    }

    public void setClaveInicialP(String ClaveInicialP) {
        this.ClaveInicialP = ClaveInicialP; 
    }
 
    public String getClaveInicial() {
        return ClaveInicial;
    }

    public void setClaveInicial(String ClaveInicial) {
        this.ClaveInicial = ClaveInicial;
    }
}
