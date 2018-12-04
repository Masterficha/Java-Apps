
import javax.swing.JOptionPane;


public class Supervisor extends Thread{
	private String nombre; 
    private Fabrica fabrica; 

    

    public Supervisor( String s, Fabrica f) {
        nombre = s;
        fabrica = f ;
        }

    public void run() {
        int valor, lleno, noHay, maximo, hojas;
        
        
        
	        for(int i=1;i<=1000;i++)
	        {
	        	hojas = fabrica.getHojas();
	        	maximo = fabrica.getContar();
	        	if(maximo>3)
	        	{
	        		fabrica.finalizar();
	        		break;
	        	}
	        	
	        	else
	        	{
	        		valor = fabrica.obtener();
		       
		        	if(valor==hojas)
		        	{
		        		fabrica.setCajaLlena(1);
		        		lleno = fabrica.getCajaLlena();
		        			        		
		        		if(lleno==1) {
		        		
		        			JOptionPane.showMessageDialog(null,"La caja esta llena, esperar a que el supervisor la vacie","CAJA LLENA EXCEPTION",JOptionPane.WARNING_MESSAGE);
		        			fabrica.setColocado(0);
						
						try {
		        			sleep(1000);
		    				} catch( InterruptedException e ) {
		        				;
		    				}
						fabrica.asignar(nombre);
		        		}
		        			        	
		        	}
		        	
		        	else {
		        		noHay = fabrica.getColocado();
		        		
		        		if(noHay==0) {
		        		
		        			JOptionPane.showMessageDialog(null,"Las personas no pueden colocar papeles, ya que no hay caja...","NO HAY CAJA EXCEPTION",JOptionPane.WARNING_MESSAGE);
		        			fabrica.setColocado(1);
		        		}
		        		
		        		try {
		        			sleep(1000);
		    				} catch( InterruptedException e ) {
		        				;
		    				}
		        	
		        	}
		        }
		
	        	
	        }
            
    }
        
}