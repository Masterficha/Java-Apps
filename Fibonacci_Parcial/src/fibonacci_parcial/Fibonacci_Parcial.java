/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci_parcial;

/**
 *
 * @author Leonardo Ortega
 */
import javax.swing.*;
import java.io.*;
public class Fibonacci_Parcial {

    public static void main(String [] args)
	{
            String op="true";
            while(op.equals("true"))
            {
		 try{
		 
		 String text= capturaNum();
		 int y= Integer.parseInt(text);

		
	    
		admit(y);
	
		Fibonacci a= new Fibonacci(y);
		a.start();
		try {
			a.join();
		}catch(InterruptedException c){};
                
                
	JOptionPane.showMessageDialog(null, " LA SUCECION ES: "+a.resultados);}catch(IOException p)
        
        {
            return;
        
        }
                 catch(NumberFormatException p){
		JOptionPane.showMessageDialog(null, "!!USTED HA INTRODUCIDO UN CARACTER INVALIDO!!"," ***Error de Entrada*** ", JOptionPane.ERROR_MESSAGE);;return;
                 }
                 
		catch(FibonacciException p){
	        JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NUMERO MAYOR QUE CERO"," ***Error de Entrada*** ", JOptionPane.ERROR_MESSAGE);; return;
		}
                 op=JOptionPane.showInputDialog("Ingrese true o false para seguir respectivamente");
	}
        }
	
	public static void admit( int d ) throws FibonacciException
	 {
	 	if ( d > 19 || d < 0  )	
	 	  throw new FibonacciException(d);
	 	  
	 }
	 
	 
	

	public static String capturaNum() throws IOException
		{
		String strnum;
		strnum= JOptionPane.showInputDialog( "*** Ingrese un Numero: ***" );
		
		 		
		 return (strnum);
		}
		
    
}
 class FibonacciException extends Exception
{
  private final int x;

  FibonacciException( int x)
   {
	this.x = x;
	JOptionPane.showMessageDialog(null, "!!DEBE INGRESAR UN NUMERO DENTRO DE UN RANGO DE 0 a 20!!"," ***Error de entrada*** ", JOptionPane.ERROR_MESSAGE);
	System.exit(0);
   }
}