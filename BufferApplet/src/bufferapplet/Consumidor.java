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


import javax.swing.JOptionPane;

/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 8\Buffer de Mensajes
Clase Consumidor

******************************************************************************/

public class Consumidor extends Thread {

         private Buffer buffer;

         private int num;

         private BufferTest win;
         
         private boolean show_JOptionPane=true;

         public Consumidor(Buffer b,int n, BufferTest win) {

                 buffer = b;

                 this.num = n;
                 
                 this.win = win;
         }



         public void run() {
                 for (int i=1; i<=25; i++) {
                	 if(win.stopRun()==true){show_JOptionPane=false; break;}
                	 while(win.getPause()==false){ yield(); }

                          int val=buffer.lee();

                          System.out.println(" - Consumidor "+this.num+" toma: "+val);
                          win.setText(" - Consumidor "+this.num+" toma: "+val,2);
                 

                          try {

                                    sleep((int)(Math.random()*1000));

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupci del hilo..." );

                          }

                 }
                win.setButtonEnabled(true,1);
                win.setButtonEnabled(false, 2);
                win.setButtonEnabled(false, 4);
                if(win.stopRun()==true){ System.gc();}
                if(show_JOptionPane==true) JOptionPane.showMessageDialog(null,"Proceso terminado");
         }

}





