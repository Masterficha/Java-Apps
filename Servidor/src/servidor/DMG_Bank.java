package servidor;
import java.io.*;
import java.net.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.MediaSize;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author victor
 */

class MarcoPassword extends JFrame{
    
    public MarcoPassword(){
         
    setLayout(new BorderLayout());
    setBounds(350,250,300,125);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    
    campos = new JPanel();
    campos.setLayout(new GridLayout(2,2));
    add(campos,BorderLayout.NORTH);
    
    label_usuario = new JLabel("  Usuario");
    label_contrasena=new JLabel("  Password");
    
    Textuser = new JTextField(15);
    Textcontra = new JPasswordField(15);
    
    campos.add(label_usuario);
    campos.add(Textuser);
    campos.add(label_contrasena);
    campos.add(Textcontra);
    
    botones = new JPanel();
    botones.setLayout(new FlowLayout());
    add(botones,BorderLayout.SOUTH);
    
    botonOk = new JButton("Ok");
    botonCancel = new JButton("Cancel");
           
    
    botonCancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){dispose();}});  
    
    botonOk.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            
            
           char clave[]=Textcontra.getPassword();

      String clavedef=new String(clave);


if (Textuser.getText().equals("admin") && clavedef.equals("keyadmin")){

      MarcoAdmin admin=new MarcoAdmin();
      admin.setVisible(true);
    dispose();
}else {
    String serverName = "localhost";
		int port = Integer.parseInt("5001");
                String k="0";
	Cliente aux4 = null;	
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        
                        

			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF("0");	
                        out.writeUTF(Textuser.getText());
                        out.writeUTF(clavedef);
			
                       
                     
                                                                         InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			  k=in.readUTF();
                         if(k.equals("1")){
                      ObjectInputStream obj = new ObjectInputStream(client.getInputStream());
                                                                        Cliente cliente2= (Cliente) obj.readObject();
                                                                         aux4=cliente2;
    MarcoUsuario user=new MarcoUsuario(aux4);
    user.setVisible(true);
    dispose();}
                else{
                    JOptionPane.showMessageDialog(null, "alert", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);}


			
		}catch(IOException l)
		{
			l.printStackTrace();
		} catch (ClassNotFoundException ex) {
                   Logger.getLogger(MarcoPassword.class.getName()).log(Level.SEVERE, null, ex);
               }
                
}
        }
    
            });
    
    botones.add(botonOk);
    botones.add(botonCancel);
    
    
      
  
    
    }
    
    private JPanel campos,botones;
    private JButton botonOk, botonCancel;
    private JLabel label_usuario,label_contrasena;
    private JTextField Textuser;
    private JPasswordField Textcontra;
    
}




class MarcoAgregar extends JFrame{
    public MarcoAgregar(){
        
        setBounds(350,250,400,300);
        setTitle("Agregar Cliente");
        setVisible(true);
        setLayout(new BorderLayout());
        setResizable(false);
        
        campos = new JPanel();
        campos.setLayout(new GridLayout(7,2,10,10));
        
        nom = new JLabel("Nombre");
        ape = new JLabel("Apellido");
        user = new JLabel("Usuario");
        num = new JLabel("Numero de Cuenta");
        sal = new JLabel("Saldo Inicial");
        contra = new JLabel("Contraseña");
        cuenta = new JLabel("Tipo de Cuenta");
                
        textnom = new JTextField(18);
        textape = new JTextField(18);
        textuser = new JTextField(18);
        textnum = new JTextField(18);
        textsal = new JTextField(18);
        textcontra = new JTextField(18);
        textcuenta = new JTextField(18);
        
        campos.add(nom);
        campos.add(textnom);
        campos.add(ape);
        campos.add(textape);
        campos.add(user);
        campos.add(textuser);
        campos.add(num);
        campos.add(textnum);
        campos.add(sal);
        campos.add(textsal);
        campos.add(contra);
        campos.add(textcontra);
        campos.add(cuenta);
        campos.add(textcuenta);
        
        botones = new JPanel();
        botones.setLayout(new FlowLayout());
        
        add = new JButton("Add");
        add.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             int a1= Integer.parseInt(textcontra.getText()), a2= Integer.parseInt(textnum.getText());
             double d1= Double.parseDouble(textsal.getText());
              Cliente nuevo= new Cliente(textnom.getText(), textuser.getText(), textape.getText(), textcuenta
                      .getText(), a2, textcontra.getText(), d1);
              
              
              String serverName = "localhost";
		int port = Integer.parseInt("5001");
              
		
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        String o = "1";
                        OutputStream outToServer = client.getOutputStream();
			DataOutputStream out2= new DataOutputStream(outToServer);
			
                        out2.writeUTF(o);
                                                     ObjectOutputStream out= new ObjectOutputStream(client.getOutputStream());
                                                 out.flush();
                                                 out.writeObject(nuevo);
                                                 out.flush();
                                                
			
			

			
		}catch(IOException f)
		{
			f.printStackTrace();
		}
	
         }
        });   
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){dispose();}});  
        
        botones.add(add);
        botones.add(cancel);
        add(campos, BorderLayout.NORTH);
        add(botones, BorderLayout.SOUTH);
        
        
    }
    
    private JTextField textnom,textape,textuser,textnum,textsal,textcontra,textcuenta;
    private JLabel nom,ape,user,num,sal,contra,cuenta;
    private JButton add,cancel;
    private JPanel campos,botones;
    
    
}


class TablaEdit extends JFrame{
    public TablaEdit() throws ClassNotFoundException{
        
        setLayout(new BorderLayout());
        setTitle("Usuarios Registrados");
        setBounds(350,250,400,275);
        setVisible(true);
        
        tabla=new JTable();
        
        modelo=new DefaultTableModel();
        
        tabla.setModel(modelo);
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        
        
        add(tabla);
        
        String serverName = "localhost";
		int port = Integer.parseInt("5001");
              
		
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        String o = "3";
                        OutputStream outToServer = client.getOutputStream();
			DataOutputStream out2= new DataOutputStream(outToServer);
			
                        out2.writeUTF(o);
                                                     ObjectInputStream obj = new ObjectInputStream(client.getInputStream());

                                                     ArrayList <Cliente> Lista2;
            Lista2= (ArrayList)obj.readObject();
	String datos[] = new String[5];		
		for(int cont=0; cont<Lista2.size();cont++){
                    Cliente aux3= Lista2.get(cont);
                    datos[0]= aux3.getNombre();
                    datos[1]= aux3.getApellido();
                    
                    modelo.addRow(datos);
                    
                }	
                TableColumn colum1 = null;
colum1 = tabla.getColumnModel().getColumn(0);
colum1.setPreferredWidth(60);
TableColumn colum2 = null;
colum2 = tabla.getColumnModel().getColumn(1);
colum2.setPreferredWidth(5);


			
		}catch(IOException f)
		{
			f.printStackTrace();
		}
	
        
    }
    
    private JTable tabla;
    DefaultTableModel modelo;
}


/*class MarcoEditar extends JFrame{
    public MarcoEditar(){
        
        setBounds(350,250,400,300);
        setTitle("Editar Cliente");
        setVisible(true);
        setLayout(new BorderLayout());
        setResizable(false);
        
        campos = new JPanel();
        campos.setLayout(new GridLayout(7,2,10,10));
        
        nom = new JLabel("Nombre");
        ape = new JLabel("Apellido");
        user = new JLabel("Usuario");
        num = new JLabel("Numero de Cuenta");                       
        sal = new JLabel("Saldo Inicial");       
        contra = new JLabel("Contraseña");
        cuenta = new JLabel("Tipo de Cuenta");
                
        textnom = new JTextField(18);
        textape = new JTextField(18);
        textuser = new JTextField(18);
        textnum = new JTextField(18);
        textnum.setEnabled(false);
        
        textsal = new JTextField(18);
        textsal.setEnabled(false);
        
        textcontra = new JTextField(18);
        textcuenta = new JTextField(18);
        
        campos.add(nom);
        campos.add(textnom);
        campos.add(ape);
        campos.add(textape);
        campos.add(user);
        campos.add(textuser);
        campos.add(num);
        campos.add(textnum);
        campos.add(sal);
        campos.add(textsal);
        campos.add(contra);
        campos.add(textcontra);
        campos.add(cuenta);
        campos.add(textcuenta);
        
        botones = new JPanel();
        botones.setLayout(new FlowLayout());
        
        edit = new JButton("Add");
        edit.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
              //Falta codigo
         }
        });   
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){dispose();}});  
        
        botones.add(edit);
        botones.add(cancel);
        add(campos, BorderLayout.NORTH);
        add(botones, BorderLayout.SOUTH);
        
        
    }
    
    private JTextField textnom,textape,textuser,textnum,textsal,textcontra,textcuenta;
    private JLabel nom,ape,user,num,sal,contra,cuenta;
    private JButton edit,cancel;
    private JPanel campos,botones;
    
    
}*/



class MarcoLista extends JFrame{
    public MarcoLista() throws ClassNotFoundException{
        
        setLayout(new BorderLayout());
        setTitle("Reportes de Usuario");
        setBounds(350,250,400,275);
        setVisible(true);
        
        tabla=new JTable();
        
        modelo=new DefaultTableModel();
        
        tabla.setModel(modelo);
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Usuario");
        modelo.addColumn("# Cuenta");
        modelo.addColumn("Saldo");
        
        add(tabla);
        
        String serverName = "localhost";
		int port = Integer.parseInt("5001");
              
		
		try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        String o = "3";
                        OutputStream outToServer = client.getOutputStream();
			DataOutputStream out2= new DataOutputStream(outToServer);
			
                        out2.writeUTF(o);
                                                     ObjectInputStream obj = new ObjectInputStream(client.getInputStream());

                                                     ArrayList <Cliente> Lista2;
            Lista2= (ArrayList)obj.readObject();
	String datos[] = new String[5];		
		for(int cont=0; cont<Lista2.size();cont++){
                    Cliente aux3= Lista2.get(cont);
                    datos[0]= aux3.getNombre();
                    datos[1]= aux3.getApellido();
                    datos[2]= aux3.getUsuario();
                    datos[3]= String.valueOf(aux3.getNumCuenta());
                    datos[4]= String.valueOf(aux3.getSaldo());
                    modelo.addRow(datos);
                    
                }	
                TableColumn colum1 = null;
colum1 = tabla.getColumnModel().getColumn(0);
colum1.setPreferredWidth(60);
TableColumn colum2 = null;
colum2 = tabla.getColumnModel().getColumn(1);
colum2.setPreferredWidth(5);
TableColumn colum3 = null;
colum3 = tabla.getColumnModel().getColumn(2);
colum3.setPreferredWidth(40);
colum3.setPreferredWidth(10);
TableColumn colum4 = null;
colum4 = tabla.getColumnModel().getColumn(3);
colum4.setPreferredWidth(10);


			
		}catch(IOException f)
		{
			f.printStackTrace();
		}
	
        
    }
    
    private JTable tabla;
    DefaultTableModel modelo;
}



class MarcoAdmin extends JFrame{
    public MarcoAdmin(){
       // setVisible(true);
        principio=true;
    setBounds(350,250,565,275);
    setLayout(new BorderLayout());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
            
    
    JMenuBar mibarra =new JMenuBar();
    
    JMenu formularios = new JMenu("Formularios");  
    JMenu tramites = new JMenu("Tramites");  
    JMenu ayuda = new JMenu("Ayuda");
      
      JMenuItem agregar =new JMenuItem("Agregar Cliente");
      agregar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
              MarcoAgregar agrega= new MarcoAgregar();
         }
        });   
      
      JMenuItem editar =new JMenuItem("Editar Cliente");
      editar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
                         try {
                             TablaEdit edit= new TablaEdit();
                             edit.setVisible(true);
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(MarcoAdmin.class.getName()).log(Level.SEVERE, null, ex);
                         }
         }
        });   
      
      JMenuItem listado =new JMenuItem("Ver Listado");
      listado.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
                         try {
                             MarcoLista lista= new MarcoLista();
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(MarcoAdmin.class.getName()).log(Level.SEVERE, null, ex);
                         }
         }
        });   
      
     formularios.add(agregar);
     formularios.add(editar);
           
     tramites.add(listado);
      
           
      mibarra.add(formularios);
      mibarra.add(tramites);
      mibarra.add(ayuda);
      
     
    
            LaminaEste = new JPanel();
            LaminaEste.setLayout(new BorderLayout());
            
            
            JTextArea Area1 = new JTextArea(14,25);
            Area1.setLineWrap(true);
            Area1.setEditable(false);
            Area1.append("\n                         WELCOME TO DMG BANK\n               SERVICIO DE CAJERO AUTOMATICO");
            LaminaEste.add(Area1, BorderLayout.NORTH);
            
            
            text = new JTextField(12);
            LaminaEste.add(text,BorderLayout.SOUTH);
            
                     
         
    
            LaminaOeste = new JPanel();
            LaminaOeste.setLayout(new BorderLayout());
            
                        
            BotonesCuenta = new JPanel();
            BotonesCuenta.setLayout(new GridLayout(4,1));
            JButton botn=new JButton("");
            botn.setEnabled(false);
            
              ver_balance =new JButton("Ver el Balance de mi cuenta");
              ver_balance.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
              //Falta Codigo
         }
        });   
            
            
              depositar =new JButton("Hacer un Deposito");
              depositar.addActionListener(new ActionListener(){
            
         public void actionPerformed(ActionEvent e){
             
              //Falta Codigo
         }
        });  
              
              retiro =new JButton("Hacer un Retiro");
              retiro.addActionListener(new ActionListener(){
            
         public void actionPerformed(ActionEvent e){
             
             //Falta Codigo
         }
        });  
              
              ver_balance.setEnabled(false);
              depositar.setEnabled(false);
              retiro.setEnabled(false);
              
              
              BotonesCuenta.add(ver_balance);
              BotonesCuenta.add(depositar);
              BotonesCuenta.add(retiro);
              BotonesCuenta.add(botn);
              
                         
            
            BotonesNumericos = new JPanel();
            BotonesNumericos.setLayout(new GridLayout(3,4));
            
            InsertaNumero insertar = new InsertaNumero();
            BorraNumero borrar = new BorraNumero();
            
            ponerBotonNumerico("1",insertar);
            ponerBotonNumerico("2",insertar);
            ponerBotonNumerico("3",insertar);
            ponerBotonNumerico("4",insertar);
            
            ponerBotonNumerico("5",insertar);
            ponerBotonNumerico("6",insertar);
            ponerBotonNumerico("7",insertar);
            ponerBotonNumerico("8",insertar);
            
            ponerBotonNumerico("9",insertar);
            ponerBotonNumerico("0",insertar);
            ponerBotonNumerico(".",insertar);
            ponerBotonNumerico("Borrar",borrar);
            
             
            LaminaOeste.add(BotonesCuenta, BorderLayout.NORTH);
            LaminaOeste.add(BotonesNumericos, BorderLayout.CENTER);
            add(mibarra, BorderLayout.NORTH);
            add(LaminaOeste, BorderLayout.WEST);
            add(LaminaEste, BorderLayout.EAST);
    }
    private void ponerBotonNumerico(String rotulo, ActionListener oyente){
        
        JButton boton = new JButton(rotulo);
        
        boton.addActionListener(oyente);
        
        BotonesNumericos.add(boton);
    }
    private class InsertaNumero implements ActionListener{
       
        public void actionPerformed(ActionEvent e){
            
             String entrada =e.getActionCommand();
            
            if(principio){
                
                //text.setText("");
                principio=false;
            }
            
            text.setText(text.getText() + entrada);
            
        }
       
    }
    private class BorraNumero implements ActionListener{
       
        public void actionPerformed(ActionEvent e){
            
             
            
            text.setText("");
        }
       
    }
    
    
    private JPanel BotonesCuenta, BotonesNumericos,Area_Texto;
    private JPanel LaminaOeste,LaminaEste;
    private JButton ver_balance,depositar,retiro;
    private boolean principio;
    private JTextField text;
    
}






class MarcoUsuario extends JFrame{
    Cliente yo;
    public MarcoUsuario(Cliente yo){
       // setVisible(true);
        principio=true;
        this.yo=yo;
    setBounds(350,250,565,275);
    setLayout(new BorderLayout());
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
            
    
    JMenuBar mibarra =new JMenuBar();
   
    JMenu formularios = new JMenu("Formularios");
    formularios.setEnabled(false);
    
    JMenu tramites = new JMenu("Tramites");  
    tramites.setEnabled(false);
    
    JMenu ayuda = new JMenu("Ayuda");
    
      
      JMenuItem agregar =new JMenuItem("Agregar Cliente");
      agregar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
              MarcoAgregar agrega= new MarcoAgregar();
         }
        });   
      
      JMenuItem editar =new JMenuItem("Editar Cliente");
      editar.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
                         try {
                             TablaEdit edita= new TablaEdit();
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(MarcoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                         }
         }
        });   
      
      JMenuItem listado =new JMenuItem("Ver Listado");
      listado.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
                         try {
                             MarcoLista lista= new MarcoLista();
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(MarcoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                         }
         }
        });   
      
     formularios.add(agregar);
     formularios.add(editar);
           
     tramites.add(listado);
      
           
      mibarra.add(formularios);
      mibarra.add(tramites);
      mibarra.add(ayuda);
      
     
    
            LaminaEste = new JPanel();
            LaminaEste.setLayout(new BorderLayout());
            
            
            JTextArea Area1 = new JTextArea(14,25);
            Area1.setLineWrap(true);
            Area1.setEditable(false);
            Area1.append("\n                         WELCOME TO DMG BANK\n               SERVICIO DE CAJERO AUTOMATICO");
            LaminaEste.add(Area1, BorderLayout.NORTH);
            
            
            text = new JTextField(12);
            LaminaEste.add(text,BorderLayout.SOUTH);
            
                     
         
    
            LaminaOeste = new JPanel();
            LaminaOeste.setLayout(new BorderLayout());
            
                        
            BotonesCuenta = new JPanel();
            BotonesCuenta.setLayout(new GridLayout(4,1));
            JButton botn=new JButton("");
            botn.setEnabled(false);
            
              ver_balance =new JButton("Ver el Balance de mi cuenta");
              ver_balance.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
             
              Area1.setText("Su balance de la cuenta: "+ yo.numCuenta + "Es de: " +yo.saldo);
         }
        });   
            
            
              depositar =new JButton("Hacer un Deposito");
              depositar.addActionListener(new ActionListener(){
            
         public void actionPerformed(ActionEvent e){
             
              yo.setSaldo(yo.saldo+Double.parseDouble(text.getText()));
              Area1.setText("Ha depositado en la cuenta: "+ yo.numCuenta + " El monto de: " +text.getText()+ " haciendo un total de: "+ yo.saldo);
               String serverName = "localhost";
		int port = Integer.parseInt("5001");
              try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        
                        

			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF("4");	
                        ObjectOutputStream out4= new ObjectOutputStream(client.getOutputStream());
                                                 out4.flush();
                                                 out4.writeObject(yo);
                                                 out4.flush();
                                                 
			
                       
                                         


			
		}catch(IOException l)
		{
			l.printStackTrace();
		}
         }
        });  
              
              retiro =new JButton("Hacer un Retiro");
              retiro.addActionListener(new ActionListener(){
            
         public void actionPerformed(ActionEvent e){
             if(Double.parseDouble(text.getText())<yo.saldo){
             yo.setSaldo(yo.saldo-Double.parseDouble(text.getText()));
              Area1.setText("Ha retirado de la cuenta: "+ yo.numCuenta + " El monto de: " +text.getText()+ " haciendo un total de: "+ yo.saldo);
             String serverName = "localhost";
		int port = Integer.parseInt("5001");
              try
		{
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);

			System.out.println("Just connected to " + client.getRemoteSocketAddress());
                        
                        

			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF("4");	
                        ObjectOutputStream out4= new ObjectOutputStream(client.getOutputStream());
                                                 out4.flush();
                                                 out4.writeObject(yo);
                                                 out4.flush();
                                                 
			
                       
                                         


			
		}catch(IOException l)
		{
			l.printStackTrace();
		}}
             else
                Area1.setText("No tiene suficiente dinero para retirar esa cantidad"); 
         }
        });  
              
              
              BotonesCuenta.add(ver_balance);
              BotonesCuenta.add(depositar);
              BotonesCuenta.add(retiro);
              BotonesCuenta.add(botn);
              
                         
            
            BotonesNumericos = new JPanel();
            BotonesNumericos.setLayout(new GridLayout(3,4));
            
            InsertaNumero insertar = new InsertaNumero();
            BorraNumero borrar = new BorraNumero();
            
            ponerBotonNumerico("1",insertar);
            ponerBotonNumerico("2",insertar);
            ponerBotonNumerico("3",insertar);
            ponerBotonNumerico("4",insertar);
            
            ponerBotonNumerico("5",insertar);
            ponerBotonNumerico("6",insertar);
            ponerBotonNumerico("7",insertar);
            ponerBotonNumerico("8",insertar);
            
            ponerBotonNumerico("9",insertar);
            ponerBotonNumerico("0",insertar);
            ponerBotonNumerico(".",insertar);
            ponerBotonNumerico("Borrar",borrar);
            
             
            LaminaOeste.add(BotonesCuenta, BorderLayout.NORTH);
            LaminaOeste.add(BotonesNumericos, BorderLayout.CENTER);
            add(mibarra, BorderLayout.NORTH);
            add(LaminaOeste, BorderLayout.WEST);
            add(LaminaEste, BorderLayout.EAST);
    }
    private void ponerBotonNumerico(String rotulo, ActionListener oyente){
        
        JButton boton = new JButton(rotulo);
        
        boton.addActionListener(oyente);
        
        BotonesNumericos.add(boton);
    }
    private class InsertaNumero implements ActionListener{
       
        public void actionPerformed(ActionEvent e){
            
             String entrada =e.getActionCommand();
            
            if(principio){
                
                //text.setText("");
                principio=false;
            }
            
            text.setText(text.getText() + entrada);
            
        }
       
    }
    private class BorraNumero implements ActionListener{
       
        public void actionPerformed(ActionEvent e){
            
             
            
            text.setText("");
        }
       
    }
    
    
    private JPanel BotonesCuenta, BotonesNumericos,Area_Texto;
    private JPanel LaminaOeste,LaminaEste;
    private JButton ver_balance,depositar,retiro;
    private boolean principio;
    private JTextField text;
    
}



public class DMG_Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
			
                                                       
                        
                        MarcoPassword contra=new MarcoPassword();
                        contra.setVisible(true);
                           
                          
	  
                
                
        
    }
    
}
