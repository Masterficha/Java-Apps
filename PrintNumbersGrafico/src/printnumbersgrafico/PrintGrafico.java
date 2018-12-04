/**
 * @(#)PrintGrafico.java
 *
 *
 * @author 
 * @version 1.00 2011/10/11
 */


import java.io.*;
import java.awt.*;
import javax.swing.*;
public class PrintGrafico
{
	 
	public static void main(String [] args)
	{
		
		int time= 0;
		int numVeces;
		String	text;
		String resp="true";
		 final JPanel panel = new JPanel();
 do
        {

       try{
       
          text = captura();
		   
		   time = Integer.parseInt(text);

           valida( time);
           numVeces = time/1000;

	



	    PrintNumbersGrafico printNumbers = new PrintNumbersGrafico(numVeces);
		Thread t1 = new Thread(printNumbers);
		t1.start();

		try
		{
			Thread.sleep(time);
		}catch(InterruptedException m) 	{}
       //  System.out.println(Thread.currentThread());
	//	printNumbers.stopPrinting();

         resp=JOptionPane.showInputDialog(null, "Desea Continuar: (true/false)? ");
    	

          }catch(IOException e){ return;}
	      catch(NumberFormatException e)
		       {
		       	JOptionPane.showMessageDialog(panel,"Tiene que ingresar un numero entero en milisegundos", "Error", JOptionPane.ERROR_MESSAGE);
			     resp=JOptionPane.showInputDialog(null, "Desea Continuar: (true/false)? ");
			    //System.out.println("Tiene que ingresar un numero entero en milisegundos");
			    //return;
		       }
	      catch(MenorQueCeroException e){}

	}while (resp.equals("true")== true);

	//System.out.println("main() is ending");
     JOptionPane.showMessageDialog(null,"main() is ending");
     System.exit(0);
	}

public static void valida( int i ) throws MenorQueCeroException
	 {
	 	if (  i < 0 ||   i%1000 != 0)
	 	  throw new MenorQueCeroException(i);

	 }

public static String captura() throws IOException
		{

		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
	    String text = JOptionPane.showInputDialog(null, "Ingrese un numero entero positivo en milisegundos:  ");
		 //System.out.print("Enter your age:  ");
		   //text  = input.readLine();

		 return (text);
		}
}

class MenorQueCeroException extends Exception
{
  private int i;

  MenorQueCeroException( int i)
   {
	this.i = i;
	System.out.println("Su Entrada es incorrecta! ");
//	System.out.println("Ingrese un numero entero positivo en milisegundos ");
//	System.exit(0);
   }
}