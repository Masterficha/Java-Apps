

public class Persona2 extends Thread {
    private String nombre;
    private Fabrica fabrica;

   
    public Persona2( String s, Fabrica f ) {
        nombre = s;
        fabrica = f;
        }

  
    public void run() {
    	int valor, maximo, hojas;
        
       for(int i=1;i<=1000;i++)
		{
			hojas = fabrica.getHojas();
       		maximo = fabrica.getContar();
        	if(maximo>10)
        	{
        		break;
        	}
       		
       		else
       		{
	       		valor = fabrica.obtener();
	  
	        	if(valor>hojas)
	        	{
	        		esperar();
	        	}
	        	
	        	else 
	        	{  	
	        		try {
	            			sleep(1000);
	        				} catch( InterruptedException e ) {
	            				;
	        				}
		       	   	fabrica.asignar(nombre);
	        	}
       		}
        }
     }
    
   
    public synchronized void esperar()
	{
		try {
			wait();
			} catch( InterruptedException e ) {
				;
			}
	}
 }