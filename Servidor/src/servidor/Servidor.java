/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread{

private ServerSocket serverSocket;
public LinkedList <Cliente> Clientes= new LinkedList <Cliente> ();
public Servidor(int port ) throws IOException
{
    serverSocket = new ServerSocket(port);
}
  public void run()
	{
            
		while(true)
		{
			try
			{
                                                                        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("clientes.txt"));
           
                                                                      LinkedList <Cliente> obj1=(LinkedList)entrada.readObject();
                                                                       Clientes=obj1;
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				System.out.println("Just connected to " + server.getRemoteSocketAddress());
                                                           DataInputStream in = new DataInputStream(server.getInputStream());
                                
				
                                                                        String o= in.readUTF();while(true){
                                                                        switch (o){
                                                                            case "0": DataInputStream in2 = new DataInputStream(server.getInputStream());
			                       String us= in.readUTF();
                                                                             String ps= in.readUTF();
			ArrayList <Cliente> lista3 = new ArrayList(obj1);
                         Iterator it2 = lista3.iterator();
                         Cliente aux2; int key=0;Cliente aux7=null;
                     while (it2.hasNext()){
                       aux2= (Cliente) it2.next();
                       if(us.equals(aux2.usuario)&&ps.equals(aux2.password))
                       {
                           key=1;  aux7=aux2;
                           
                                                 
                       }
                    
                     }DataOutputStream out2 = new DataOutputStream(server.getOutputStream());
				out2.writeUTF(String.valueOf(key));
ObjectOutputStream out= new ObjectOutputStream(server.getOutputStream());
                                                 out.flush();
                                                 out.writeObject(aux7);
                                                 out.flush();
				
                     break;
                                                                            case "1": ObjectInputStream obj = new ObjectInputStream(server.getInputStream());
                                                                        Cliente cliente= (Cliente) obj.readObject();
                                                                         Cliente aux= cliente;
                                                                        Clientes.add(aux);
                                                                        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("clientes.txt"));
                                                                        salida.writeObject(Clientes);
                                                                        
                                                                                                 break;
                                                                            case "2":
                                                                            case "3":System.out.println( "La lista es la siguiente" );
                    ArrayList <Cliente> lista2 = new ArrayList(obj1);
                    ObjectOutputStream out5;
                                                                        out5 = new ObjectOutputStream(server.getOutputStream());
                                                 out5.flush();
                                                 out5.writeObject(lista2);
                                                 out5.flush();
                                                 
                     Iterator it = lista2.iterator();
                     while (it.hasNext()){
                           System.out.println(it.next()+"");
                       }break;
                                                                            case "4": ObjectInputStream obj5 = new ObjectInputStream(server.getInputStream());
                                                                        Cliente cliente5= (Cliente) obj5.readObject();
                                                                         Cliente aux4= cliente5;
                                                                         ArrayList <Cliente> lista4 = new ArrayList(obj1);
                         Iterator it4 = obj1.iterator();
                         Cliente aux5; 
                         int i=0;
                     while (it4.hasNext()){
                       aux2= (Cliente) it4.next();
                       if(aux4.usuario.equals(aux2.usuario))
                       {
                          obj1.set(i, aux4);
                       } else
                           i++;
                     } BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt"));   
                     bw.write("");
                     bw.close();
                     ObjectOutputStream salida2=new ObjectOutputStream(new FileOutputStream("clientes.txt"));
                                                                        salida2.writeObject(obj1);
                                                                   
                                                                        }break;
				
                                                                        				
				
                                                                        }
				
			}catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			}catch(IOException e)
			{
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
	}

	public static void main(String [] args)
	{
		int port = Integer.parseInt("5001");

		try
		{
			Thread t = new Servidor(port);
			t.start();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
