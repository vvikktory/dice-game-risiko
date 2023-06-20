package risiko;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class WuerfelSpiel 
{
	public static void main(String[] args) 
	{
		//Eingabe der Anzahl von Steinen
		Scanner input = new Scanner(System.in);
	    System.out.println("Anzahl der Steinen bei Angreiferin eingeben > ");
	    int aSteine = input.nextInt();
	    System.out.println("Anzahl der Steinen bei Verteidigerin eingeben > ");
	    int vSteine = input.nextInt();
	    String antwort = "";
	    
	    Random zufall = new Random();
	    
	    do
	    {
	        int aWuerfel = Math.min(3, aSteine);
	        int vWuerfel = Math.min(3, vSteine);
	        //Array deklaration
	        Integer[] aWuerfelt = new Integer[aWuerfel];
	        Integer[] vWuerfelt = new Integer[vWuerfel];
	        //Zufaelliges Wuerfelergebniss fue Angreiferin
	        for (int i = 0; i < aWuerfel; i++) 
	        {
	            aWuerfelt[i] = zufall.nextInt(6) + 1;
	        }
	        //Zufaelliges Wuerfelergebniss fuer Verteidigerin
	        for (int i = 0; i < vWuerfel; i++) 
	        {
	        	vWuerfelt[i] = zufall.nextInt(6) + 1;
	        }
	        //Aufsteigend sortieren
	        Arrays.sort(aWuerfelt, Collections.reverseOrder());
	        Arrays.sort(vWuerfelt, Collections.reverseOrder());
	        //Ausgabe der Wuerfelergebnissen
	        System.out.println("Angreiferin wuerfelt: " + Arrays.toString(aWuerfelt));
	        System.out.println("Verteidigerin wuerfelt: " + Arrays.toString(vWuerfelt));
	        //Verlustezaeler
	        for (int i = 0; i < Math.min(aWuerfel, vWuerfel); i++) 
	        {
	            if (aWuerfelt[i] > vWuerfelt[i]) 
	            {
	                vSteine--;
	            }else 
	            {
	                aSteine--;
	            }
	        }
	        System.out.println("Anzahl Steinen bei Angreiferin uebrig: " + aSteine + "; Anzahl Steinen bei Verteidigerin uebrig: " + vSteine);
	        System.out.println("Wollen Sie den Angriff abbrechen? J/N > ");
	        antwort = input.next();
	        if(antwort.equals("J"))
	        {
	        	break;
	        }
	    }while (aSteine > 0 && vSteine > 0); 
	    
	    if (aSteine == 0) 
  	     {
  		  	System.out.println("Verteidigerin hat gewonnen!");
        } 
        else if (aSteine > 0 && vSteine > 0)
        {
        	System.out.println("Das Programm ist abgebrochen");
        }
        else
        {
      	  	System.out.println("Angreiferin hat gewonnen!");
        } 
	}
}
	
