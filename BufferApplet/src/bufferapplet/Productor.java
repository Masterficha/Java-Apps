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


/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 8\Buffer de Mensajes
Clase Productor

******************************************************************************/

class Productor extends Thread {

         private Buffer buffer;

         private int num;

         private BufferTest win;

         public Productor(Buffer b,int n,BufferTest win) {

                 buffer = b;

                 this.num = n;

                 this.win = win;
         }



         public void run() {
                 for (int i=1; i<=25; i++) {
                	 if(win.stopRun()==true){break;}
                        while(win.getPause()==false){ yield(); }

                          System.out.println(" - Productor " + this.num + " pone: " + i);
                          win.setText(" - Productor " + this.num + " pone: " + i,3);
                          
                          buffer.escribe(i);
                     

                          try {

                                    sleep((int)(Math.random()*700));

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupci del hilo..." );

                          }

                 }
                 if(win.stopRun()==true){ System.gc();}
         }

}




