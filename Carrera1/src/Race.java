/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick
 */
//Programa que emula una carrera de carritos

import com.sun.swing.internal.plaf.metal.resources.metal;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Race extends JFrame implements ActionListener{    //Clase Race que se encarga principalmente de la parte grafica
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel carro0,carro1,carro2,carro3,carro4, meta0;
	JButton iniciar;
	ImageIcon images, meta;
	Icon icono0,icono1,icono2,icono3,icono4, meta00;
	public String a,b,c,d,e;
        JTextArea tA= new JTextArea();
	
    int scale = 3;	

		public Race() {
			a="carro1";b="carro2";c="carro3";d="carro4";e="carro5";
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			//contentPane.setBackground(new java.awt.Color(204, 0, 0));
			//contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 153), null));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			images=new ImageIcon("src/images.jpg");
			                 meta=new ImageIcon("src/meta.jpg");
			iniciar = new JButton("iniciar");
			
                        iniciar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                
	// TODO Auto-generated method stub
	Object fun=ae.getSource();
	if(fun==iniciar){
		RaceCar[] cars=new RaceCar[5];
		tA.setText(""); ii=0;
		for(int i=0;i<5;i++){
			cars[i]=new RaceCar(250,i,Race.this);
			cars[i].start();
		}
	}
	
}
                            
                        });
                        iniciar.setBounds(166, 194, 117, 25);
			contentPane.add(iniciar);
                        
                        tA.setBounds(0, 250, 200,200);
                        contentPane.add(tA);
                        meta0=new JLabel();
                        meta0.setBounds(250,0, 200, 200);
                        meta00=new ImageIcon(meta.getImage().getScaledInstance(meta0.getWidth(),meta0.getHeight(), Image.SCALE_DEFAULT));
                        meta0.setIcon(meta00);
                        contentPane.add(meta0);
			
			carro0 = new JLabel();     
			carro0.setBounds(0,0,50,23); 
			icono0=new ImageIcon(images.getImage().getScaledInstance(carro0.getWidth(), carro0.getHeight(), Image.SCALE_DEFAULT));
			carro0.setIcon(icono0);
			contentPane.add(carro0);
			
			carro1 = new JLabel();
			carro1.setBounds(0,35,50,23);
			icono1=new ImageIcon(images.getImage().getScaledInstance(carro1.getWidth(), carro1.getHeight(), Image.SCALE_DEFAULT));		
			carro1.setIcon(icono1);
			contentPane.add(carro1);
			
			carro2 = new JLabel();
			carro2.setBounds(0,70,50,23);
			icono2=new ImageIcon(images.getImage().getScaledInstance(carro2.getWidth(), carro2.getHeight(), Image.SCALE_DEFAULT));
			carro2.setIcon(icono2);
			contentPane.add(carro2);
			
			carro3 = new JLabel();
			carro3.setBounds(0,95,50,23);
			icono3=new ImageIcon(images.getImage().getScaledInstance(carro3.getWidth(), carro3.getHeight(), Image.SCALE_DEFAULT));			
			carro3.setIcon(icono3);
			contentPane.add(carro3);
			
			carro4 = new JLabel();
			carro4.setBounds(0,130,50,23);
			icono4=new ImageIcon(images.getImage().getScaledInstance(carro4.getWidth(), carro4.getHeight(), Image.SCALE_DEFAULT));			
			carro4.setIcon(icono4);
			contentPane.add(carro4);
			
	} public int ii=0;
		public void pintar(int x,int name){
                  
			if(name==0){
				System.out.println("carro"+name+" pintar");
				carro0.setBounds(x,0,50,23);
			}else if(name==1){
				System.out.println(name+"pintar");
				carro1.setBounds(x,35,50,23);
			}else if(name==2){
				System.out.println(name+"pintar");
				carro2.setBounds(x,70,50,23);
			}else if(name==3){
				System.out.println(name+"pintar");
				carro3.setBounds(x,95,50,23);
			}else if(name==4){
				System.out.println(name+"pintar");
				carro4.setBounds(x,130,50,23);
			}
		if (name==0 && x==250){
                    tA.append("Carro 1 Termino");  ii++;tA.append(" De posicion: "+ ii+ "\n");}
                else if (name==1 && x==250){
                  tA.append("Carro 2 Termino");  ii++;tA.append(" De posicion: "+ ii+"\n");}
              else  if (name==2 && x==250){
                 tA.append("Carro 3 Termino");  ii++;tA.append(" De posicion: "+ ii+"\n");}
               else if (name==3 && x==250){
                tA.append("Carro 4 Termino");  ii++;tA.append(" De posicion: "+ ii+"\n");}
               else if (name==4 && x==250){
                  tA.append("Carro 5 Termino");  ii++;tA.append(" De posicion: "+ ii+"\n");}
                
		}
		
	
	
	
	
public static void main (String[] args){
	 Race r=new Race();
                                     r.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
}
