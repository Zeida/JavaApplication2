/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.Scanner;
/**
 *
 * @author entrar
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(getAtomicWeight("Gold"));
        System.out.println ("Empezamos el programa");
        System.out.println ("Por favor introduzca un número para acceder a los diferentes servicios:");
        System.out.println  ("Número 1: GetAtomicNumber \n"
                            +"Número 2: GetAtomicWeight \n"
                            +"Número 3: GetAtoms \n"
                            +"Número 4: GetElementSymbol ");
        
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
        
        switch (entradaTeclado) {
            
            case "1":   System.out.println ("Por favor introduzca el nombre de un elemento químico en inglés: ");
                         //Invocamos un método sobre un objeto Scanner
                        entradaEscaner = new Scanner (System.in);
                        entradaTeclado = entradaEscaner.nextLine ();
                        String response1=getAtomicNumber(entradaTeclado);
                                if (!response1.equals("<NewDataSet />")){
                                    String atomicNumber = parseResponse(response1, "</AtomicNumber>");
                                    System.out.println("The atomic number of is: " + atomicNumber);
                                    }
                     break;
                
            case "2":   System.out.println ("Por favor introduzca el nombre de un elemento químico en inglés: "); 
                        entradaEscaner = new Scanner (System.in);
                        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
                        System.out.println (getAtomicWeight(entradaTeclado));
                     break;
                
            case "3":   System.out.println (getAtoms());
                     break;
                
            case "4":   System.out.println ("Por favor introduzca el nombre de un elemento químico en inglés: ");
                        entradaEscaner = new Scanner (System.in);
                        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
                        System.out.println (getElementSymbol(entradaTeclado));
                        String response2=getElementSymbol(entradaTeclado);
                                if (!response2.equals("<NewDataSet />")) {
                                    String elementSymbol = parseResponse(response2, "</Symbol>");
                                    System.out.println("The element symbol is: " + elementSymbol );
                                    }
                     break;
                
            default:    System.out.println("Número erróneo \n");
        }
    }

    private static String getAtomicWeight(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicWeight(elementName);
    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String getAtoms() {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtoms();
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
    
    private static String parseResponse(String response, String endTag) {
        String beginTag = endTag.replace("/", "");
        final int from = response.indexOf(beginTag);
        final int to = response.lastIndexOf(endTag);
        final String beginTagAndContent = response.substring(from, to);
        return beginTagAndContent.substring(beginTagAndContent.indexOf(">") + 1);
    }
    

    
}
