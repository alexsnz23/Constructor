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

public class GeneracionClaves {
    private final String [] K = new String [16]; 
    private String subClavePermutada;
    private String C="";
    private String D="";
    Datos Tplano = new Datos (); 
   
    public void permutarPC1(){
        ConversionDatos Conversion =new ConversionDatos();
        Conversion.ConverHexaBin();
        String subClaveI=Tplano.getClaveInicial();
        if(subClaveI == null){
            subClaveI="0001001100110100010101110111100110011011101111001101111111110001";
        }
        String [] permutaciones = new String [7]; 
        for (int i=0; i<7; i++){
            switch (i) {
                case 0:
                case 1:
                case 2:
                    permutaciones [i]=String.valueOf(subClaveI.charAt(i+56))+
                    String.valueOf(subClaveI.charAt(i+48))+String.valueOf(subClaveI.charAt(i+40))+
                    String.valueOf(subClaveI.charAt(i+32))+String.valueOf(subClaveI.charAt(i+24))+
                    String.valueOf(subClaveI.charAt(i+16))+String.valueOf(subClaveI.charAt(i+8))+
                    String.valueOf(subClaveI.charAt(i));
                break;
                case 3:
                    permutaciones [i]=String.valueOf(subClaveI.charAt(i+56))+
                    String.valueOf(subClaveI.charAt(i+48))+String.valueOf(subClaveI.charAt(i+40))
                    +String.valueOf(subClaveI.charAt(i+32))+String.valueOf(subClaveI.charAt(65-i))
                    +String.valueOf(subClaveI.charAt(57-i))+String.valueOf(subClaveI.charAt(49-i))
                    +String.valueOf(subClaveI.charAt(41-i));
                    break;
                case 6:
                    permutaciones[i]=String.valueOf(subClaveI.charAt(34-i))+
                    String.valueOf(subClaveI.charAt(26-i))+String.valueOf(subClaveI.charAt(18-i))
                    +String.valueOf(subClaveI.charAt(10-i))+String.valueOf(subClaveI.charAt(i+22))
                    +String.valueOf(subClaveI.charAt(19))+String.valueOf(subClaveI.charAt(11))
                    +String.valueOf(subClaveI.charAt(3));
                    break;
                default:
                    permutaciones [i]=String.valueOf(subClaveI.charAt(34-i))+String.valueOf(subClaveI.charAt(26-i))
                    +String.valueOf(subClaveI.charAt(18-i))+String.valueOf(subClaveI.charAt(10-i))
                    +String.valueOf(subClaveI.charAt(65-i))+String.valueOf(subClaveI.charAt(57-i))
                    +String.valueOf(subClaveI.charAt(49-i))+String.valueOf(subClaveI.charAt(41-i));
                    break;        
            }
        }
        for (int i=0; i<7;i++){
            if(subClavePermutada==null){
                subClavePermutada=permutaciones[i];
            } else
            subClavePermutada=subClavePermutada+permutaciones[i];
        }
        System.out.println("Primera permutación "+subClavePermutada);
    }
    
    public void recorrerSubClave1(){
        String claveRecorrida=C;
        String letraFinal=String.valueOf(claveRecorrida.charAt(0));
        String recorrido="";
        for(int i=0; i<claveRecorrida.length()-1;i++){
            recorrido=recorrido+String.valueOf(claveRecorrida.charAt(i+1));
        }
        claveRecorrida=recorrido+letraFinal;
        C=claveRecorrida;
        claveRecorrida="";
        recorrido="";
        
        claveRecorrida=D;
        letraFinal=String.valueOf(claveRecorrida.charAt(0));
        for(int i=0; i<claveRecorrida.length()-1;i++){
            recorrido=recorrido+String.valueOf(claveRecorrida.charAt(i+1));
        }
        claveRecorrida=recorrido+letraFinal;
        D=claveRecorrida;
        claveRecorrida="";
        recorrido="";
    }
    
    public void recorrerSubClave2(){ 
        String claveRecorrida=C;
        String letrasFinal=claveRecorrida.substring(0, 2);
        String recorrido="";
        for(int i=0; i<claveRecorrida.length()-2;i++){
            recorrido=recorrido+String.valueOf(claveRecorrida.charAt(i+2));
        }
        claveRecorrida=recorrido+letrasFinal;
        C=claveRecorrida;
        claveRecorrida="";
        recorrido="";
        
        claveRecorrida=D;
        letrasFinal=claveRecorrida.substring(0, 2);
        recorrido="";
        for(int i=0; i<claveRecorrida.length()-2;i++){
            recorrido=recorrido+String.valueOf(claveRecorrida.charAt(i+2));
        }
        claveRecorrida=recorrido+letrasFinal;
        D=claveRecorrida;
        claveRecorrida="";
        recorrido="";
    }
    public void partirSubClaves(String subclave){
        for(int i=0; i<subclave.length(); i++){
            if(i<subclave.length()/2)
                C=C+subclave.charAt(i);
            else if(i>=subclave.length()/2)
                D=D+subclave.charAt(i);
        }
    }
    
    public void permutarCD(){
        permutarPC1();
        String subClaveAnterior = subClavePermutada;
        
        partirSubClaves(subClaveAnterior);
        System.out.println("");
        System.out.println("Co "+C+" Do "+D );
        System.out.println("");
        int arregloPosicionesCD []={13, 16, 10, 23, 0, 4, 2, 27,
            14, 5, 20, 9, 22, 18, 11, 3,
            25, 7, 15, 6, 26, 19, 12, 1, 
            40, 51, 30, 36, 46, 54, 29, 39, 
            50, 44, 32, 47, 43, 48, 38, 55, 
            33, 52, 45, 41, 49, 35, 28, 31}; //-24
        for (int i=0; i<16; i++){
            if (i==0 || i==1 || i==8 || i==15){ 
               recorrerSubClave1();
            }else 
            if(i==2 || i==3 || i==4 || i==5 || i==6 || i==7 || i==9 ||i==10 || 
               i==11 || i==12 || i==13 || i==14){
                recorrerSubClave2();
            }
            System.out.println("C y D "+(i+1)+" "+C+" "+D);
            for(int h=0; h<48; h++){
                if(K[i]==null){
                    K[i]=String.valueOf(C.charAt(arregloPosicionesCD[h]));
                }else{
                    if(h<24){
                        K[i] = K[i] + String.valueOf(C.charAt(arregloPosicionesCD[h]));
                    }
                    else if(h>=24){
                        K[i] = K[i] + String.valueOf(D.charAt(arregloPosicionesCD[h]-28));
                    }
                }
            }
        }
        mostrarArregloK();
    }
    public void mostrarArregloK(){
        System.out.println("");
        for(int i=0; i<16; i++){
            System.out.println("K"+(i+1)+": "+K[i]);
        }
    }
}
