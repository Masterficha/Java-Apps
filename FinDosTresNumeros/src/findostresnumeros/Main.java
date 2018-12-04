//Por Metodo de Runnable
package findostresnumeros;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String [] args){
  
	  Pares par = new Pares();
	  Impares impar = new Impares();
	  FinDosTresNumeros dos_tres = new FinDosTresNumeros();
	  
	  Thread hilo_1 = new Thread(par);
	  Thread hilo_2 = new Thread(impar);
	  Thread hilo_3 = new Thread(dos_tres);
	     JOptionPane.showMessageDialog(null,"Numeros del 1 al 100: ");
	  hilo_1.start();
	  hilo_2.start();
	  hilo_3.start();
	  
  }
}

