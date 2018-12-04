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
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @(#)BufferTest.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */

//Programa que implementa un buffer de mensajes:

/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 8\Buffer de Mensajes
Clase BufferTest

Creamos un hilo productor y otro consumidor que comparten

el recurso compartido de tipo buffer de mensajes Buffer.

******************************************************************************/

public class BufferTest extends Applet implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel botones;
	private JButton suspender, reanudar,iniciar,detener;
	private JTextField productor_field,consumidor_field,buffer_field;
	private JLabel etiqueta,productor_label,buffer_label,consumidor_label;
	private boolean pse=true,stp=false;

//----------------------------------------------------------INIT	
	public void init(){
		suspender = new JButton("Suspender");
		reanudar = new JButton("Reanudar");
		iniciar = new JButton("Iniciar");
		detener = new JButton("Detener");
		botones = new JPanel(new GridLayout(1,4));
		productor_field = new JTextField();
		consumidor_field = new JTextField();
		buffer_field = new JTextField();
		etiqueta = new JLabel("-Productor/Consumidor con Buffer-");
		productor_label = new JLabel("Productor:");
		buffer_label = new JLabel("Buffer:");
		consumidor_label = new JLabel("Consumidor:");
		
		this.setLayout(null);
		botones.add(iniciar);
		botones.add(suspender);
		botones.add(reanudar);
		botones.add(detener);
	    etiqueta.setBounds(145,2,200,25); 
	    botones.setBounds(50,30,400,25);  //tres botones 97
		productor_label.setBounds(30,120,100,25);
		buffer_label.setBounds(30,170,100,25);
		consumidor_label.setBounds(30,220,100,25);
		productor_field.setBounds(180,120,300,25);
		buffer_field.setBounds(180,170,300,25);
		consumidor_field.setBounds(180,220,300,25);
	    
		productor_field.setEditable(false);
		productor_field.setBackground(Color.WHITE);
		buffer_field.setEditable(false);
		buffer_field.setBackground(Color.WHITE);
		consumidor_field.setEditable(false);
		consumidor_field.setBackground(Color.WHITE);
		
		iniciar.addActionListener(this);
		reanudar.addActionListener(this);
		suspender.addActionListener(this);
		detener.addActionListener(this);
		
	    this.add(etiqueta);
	    this.add(botones);
		this.add(productor_label);
		this.add(buffer_label);
		this.add(consumidor_label);
		this.add(productor_field);
		this.add(buffer_field);
		this.add(consumidor_field);
		
		setButtonEnabled(false,2);
		setButtonEnabled(false,3);
		setButtonEnabled(false,4);
	    
    	this.setSize(500,300);
    	this.setVisible(true);
	}
//---------------------------------------------------------EVENTOS	
	public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == iniciar){
		   setButtonEnabled(false,1);	
		   setButtonEnabled(true,2);
		   setButtonEnabled(true,4);
		   stp=false;
		   Buffer buf = new Buffer(this);
	       Productor p1 = new Productor(buf, 1,this);
	       Consumidor c1 = new Consumidor(buf, 1,this);
	       p1.start();
	       c1.start();
		  }
		  
		  if(e.getSource() == suspender){
			  setButtonEnabled(false,2);
			  setButtonEnabled(true,3);
			  pse=false;
		  }
		  
		  if(e.getSource() == reanudar){
			  setButtonEnabled(false,3);
			  setButtonEnabled(true,2);
			  pse=true;
		  }
		  
		  if(e.getSource() == detener){
			  setButtonEnabled(true,1);
			  setButtonEnabled(false,2);
			  setButtonEnabled(false,3);
			  setButtonEnabled(false,4);
			  buffer_field.setText("");
			  consumidor_field.setText("");
			  productor_field.setText("");
			  pse=true;
			  stp=true; 
		  }
		}
//-------------------------------------------------------METODOS	
	public boolean getPause(){ return pse; }
	
	public boolean stopRun(){ return stp; }
   
	public void setText(String cadena,int opcion){
		if (opcion==1) buffer_field.setText(cadena);
		if (opcion==2) consumidor_field.setText(cadena);
		if (opcion==3) productor_field.setText(cadena);
	}
	
	public String getText(){
		String cadena=buffer_field.getText();
		return cadena;
	}
	
	public void setButtonEnabled(boolean valor,int opcion){
		if (opcion==1) iniciar.setEnabled(valor);
		if (opcion==2) suspender.setEnabled(valor);
		if (opcion==3) reanudar.setEnabled(valor);
		if (opcion==4) detener.setEnabled(valor);
	}
}