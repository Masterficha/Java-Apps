
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
public class RaceCar extends Thread {
private int finish,i;
//public String name;
private Race r;


public RaceCar(int finish,int i,Race r) {
	this.finish=finish;
	this.i=i;
	this.r=r;
}
	
@Override
public void run() {
	for(int j=0;j<=finish;j=j+1) {
		System.out.println("carro"+i+": "+j);
		
		try{
			Thread.sleep((long)((Math.random()*(5-1)+1)*5));
			r.pintar(j,i);
		}catch(InterruptedException e){}
	}
	//JOptionPane.showMessageDialog(null,"La carrera ha terminado el carro ganador es: carro"+i);
        
        JOptionPane.showMessageDialog(null, i+1 + " Ha llegado a la meta ");
        System.out.println(i+1 +"ha llegado a la meta");
        yield();
}
}
