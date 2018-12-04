
/**

* @author Abdiel Vargas
* @cedula 5-706-2314
*clase principal Fabrica.java
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class Fabrica extends JFrame implements ActionListener
{
	public JPanel panel, botones, pantalla;
	public JButton vaciar, colocar, iniciar;
	public JTextArea output;
	private JScrollPane scroll;
	private JLabel label;
	
	
	private int valor=0, lleno=0, colocado=1, contar=1, hojas;
	private String p;
	private static Persona1 p1;
    private static Persona2 p2;
    private static Persona3 p3;
    private static Supervisor s;
	

    public Fabrica(String title)
    {
    	super(title);
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al intentar cargar L&F");
		}
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	    JOptionPane.showMessageDialog(null,"Mi Fabrica de Papel.",
    	 	"FABRICA PAPEL Ricardo S,A",JOptionPane.INFORMATION_MESSAGE);

		hojas =10;

    
   
    	botones=new JPanel(new GridLayout(3,1,1,4));
    	pantalla=new JPanel(new BorderLayout());
    	panel=new JPanel();
    	
    	iniciar= new JButton("Iniciar a Trabajar");
    	botones.add(iniciar);
    	iniciar.addActionListener(this);
    	
    	vaciar= new JButton("Vaciar Caja");
    	botones.add(vaciar);
    	vaciar.addActionListener(this);
    	
    	colocar= new JButton("Nueva Caja");
    	botones.add(colocar);
    	vaciar.setEnabled(false);
    	colocar.setEnabled(false);
    	colocar.addActionListener(this);
    	
    	this.add(botones, BorderLayout.WEST);
    	
    	output=new JTextArea("",10,20);
    	output.setEditable(false);
    	output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       scroll = new JScrollPane(output);
        pantalla.add(scroll, BorderLayout.CENTER);
        this.add(pantalla, BorderLayout.CENTER);
        label = new JLabel("");
        panel.add(label);
        this.add(panel, BorderLayout.SOUTH);
    }
   
  
   public void actionPerformed(ActionEvent e)
    {
    	 if(e.getSource() == iniciar)
    	 {
    	 	JOptionPane.showMessageDialog(null,"Las personas deben iniciar a colocar los papeles en la caja.",
    	 	"FABRICA DE PAPEL",JOptionPane.INFORMATION_MESSAGE);
    	 	iniciar.setEnabled(false);

			// Arrancamos los threads
	        p1.start();
	        p2.start();
	        p3.start();
	        s.start();
    	 }
    	 
    	 if(e.getSource() == vaciar)
    	 {
    	 	JOptionPane.showMessageDialog(null,"El Supervisor esta vaciando la caja llena...",
    	 	"FABRICA DE PAPEL ",JOptionPane.INFORMATION_MESSAGE);
    	 	vaciar.setEnabled(false);
    	 	output.setText("");
    	 	valor=0;
    	 	colocado=0;
            contar++;
    	 	continuar();
    	 }
    	 
     if(e.getSource() == colocar)
    	 {
    			JOptionPane.showMessageDialog(null,"El Supervisor esta colocando una caja nueva...",
    			"FABRICA DE PAPEL BOND",JOptionPane.INFORMATION_MESSAGE);
	    		colocar.setEnabled(false);
	    		continuar();
    	 }
    }
    
  
   	public synchronized int obtener()
	{
		return valor;
	}
	

	public synchronized void asignar(String person) 
	{
	
		try {
				
				if(valor==hojas) {
					if(lleno==1)
					{
							lleno=0;			
							vaciar.setEnabled(true);
							wait();
							throw (new CajaLLenaException());		
					}
					else
					{
						wait();
					}
				 
				 }
				 else if(valor==0 && colocado==0)
				 {
				 	colocar.setEnabled(true);
				 	wait();
				 	
				 }
				 
				 else {
					valor++;
					p = person;
					output.setText(output.getText()+p+" coloca la hola de papel numero " +valor+"\n");
					
				}
            		
			}
			catch(InterruptedException i) {
			}

			catch(CajaLLenaException llena) {
				System.out.println(llena);		
			}
			
			

	}
	
	
	public void finalizar()
	{
		JOptionPane.showMessageDialog(null," Felicidades!!!  han terminado con las 3 cajas",
		"EL SUPERVISOR",JOptionPane.ERROR_MESSAGE);
	
        System.exit(0);
	}
	

	public synchronized void continuar()
	{
		notifyAll();
		
		
}

	public int getCajaLlena()
	{
		return lleno;
	}
	

	public void setCajaLlena(int c) 
	{
		this.lleno = c;
	}
	

	public void setColocado(int n) 
	{
		this.colocado = n;
	}
	
	
	public int getColocado()
	{
		return colocado;
	}
	

	public int getContar()
	{
		return contar;
	}
	

	public int getHojas()
	{
		return hojas;
	}

    
   public static void main(String [] args)
  {
  
  	Fabrica f = new Fabrica("FABRICA Papel Ricardo S,A ");
    f.setSize(450,270);
    f.setLocationRelativeTo(null);
   	f.setVisible(true);
   
   	
   	//agregando hilos
   	p1 = new Persona1( "Esclavo Andres",f );
    p2 = new Persona2( "Esclavo Victor",f );
    p3 = new Persona3( "Esclava Estefanie",f );
    s = new Supervisor("Supervisor Ricardo",f);

  }
    
}