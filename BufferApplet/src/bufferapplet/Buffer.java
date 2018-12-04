/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufferapplet;

/**
 *
 * @author Ricardo
 */
public class Buffer {
         private int capacidad = 10;
         private int pila[] = new int[capacidad];
         private int puntero = -1;
         private boolean estaLleno = false;
         private boolean estaVacio = true;
         private BufferTest win;
         public Buffer(BufferTest win){ this.win = win;  }
         
 //=========================================================================================================LEE
         public synchronized int lee() {
                 System.out.println("LEE - ptro: "+puntero+" - vacio: "+estaVacio );

                 while(estaVacio) {

                          try {

                                    wait();

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupci del hilo..." );

                          }

                 }

                 int num = pila[puntero];

                 pila[puntero]=0;

                 puntero--;

                 if (puntero < 0) estaVacio = true;

                 estaLleno = false;

                 System.out.print("\n-- PilaB:");

                 for (int i=0;i<capacidad;i++){ 
                	 System.out.print(" "+pila[i]);
                	 if (i==0) win.setText(" "+pila[i],1); 
                	 else win.setText(win.getText()+" "+pila[i],1);
                 } 
                 
                 notify();

                 return num;

         }
//=====================================================================================================================ESCRIBE

         public synchronized void escribe(int num) {

                 System.out.println("ESCRIBE - ptro: "+puntero+" - lleno: "+estaLleno );
 
                 while(estaLleno) {

                          try {

                                    wait();

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupci del hilo..." );

                          }

                 }

                 puntero++;

                 pila[puntero]=num;

                 if (puntero == capacidad-1) estaLleno = true;

                 estaVacio = false;

                 System.out.print("\n-- PilaX:");

                 for (int i=0;i<capacidad;i++){ 
                	 System.out.print(" "+pila[i]);
                	 if(i==0) win.setText(" "+pila[i],1); 
                	 else  win.setText(win.getText()+" "+pila[i],1);
                 }
                 
                 notify();
         }
  //===============================================================================================================

}//fin de clase
