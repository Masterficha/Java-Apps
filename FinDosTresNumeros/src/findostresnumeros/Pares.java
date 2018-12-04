
package findostresnumeros;

import javax.swing.JOptionPane;

public class Pares implements Runnable {
	private int suma =0;
   
	public void run() {
	  
		for(int i=1;i<=100;i++){
			if((i % 2) == 0){
				suma++;
			}
		}
		
		          JOptionPane.showMessageDialog(null, "Hilo 1: La cantidad de numeros pares del 1 al 100 es: " + suma);
	}

}
