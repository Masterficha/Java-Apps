
package findostresnumeros;

import javax.swing.JOptionPane;

public class FinDosTresNumeros implements Runnable {
	private int suma=0;
   
	public void run() {
	  
		for(int i=1;i<=100;i++){
			if( ( ((i - 2) % 10 == 0) || ( (i - 3) % 10)==0 )){
				suma++;
			}
		}
		
	           JOptionPane.showMessageDialog(null,"Hilo 3: La cantidad de numeros que terminen en tres y en dos es: " + suma); 
	}//fin run

}
