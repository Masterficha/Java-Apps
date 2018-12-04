
package findostresnumeros;

import javax.swing.JOptionPane;

public class Impares implements Runnable {
	private int suma =0;

	public void run() {
	  
		for(int i=1;i<=100;i++){
			if((i % 2) == 1){
			  suma++;	
			}
		}
		          JOptionPane.showMessageDialog(null,"Hilo 2: La cantidad de numeros inpares del 1 al 100 es: " + suma);
	}

}
