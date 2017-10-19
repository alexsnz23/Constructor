/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obtencionclaves;


import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Yo
 */
public class ConversionDatos {
    private int ConversionSub; //Conversiones intermedias dentro de procesos
    private String Binario;
    private Datos Tplano = new Datos();
    
    public void ConverHexaBin(){
        Scanner Hexadecimal = new Scanner (System.in);
        System.out.println("Ingrese el valor en hexadecimal");
        String Bin;
        Tplano.setClaveInicialP(Hexadecimal.next());
        String ClaveI = Tplano.getClaveInicialP();
        int ceros=0;
        ConversionSub=Integer.parseInt(String.valueOf(ClaveI.charAt(0)),16);
        Bin = Integer.toBinaryString(ConversionSub);
        while(Bin.length()<4){
                Bin="0"+Bin;
                ceros++;
        }
        switch(ceros){
            case 1:
                Binario="0";
            break;
            case 2:
                Binario="00";
            break;
            case 3:
                Binario="000";
            break;
        }
        Binario=Binario+new BigInteger(ClaveI,16).toString(2);
        System.out.println("Clave en binario: "+Binario);
        Tplano.setClaveInicial(Binario);
    }
//    public void ConverASIIBin(){
//        
//    }
}
