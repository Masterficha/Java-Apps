/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci_parcial;

/**
 *
 * @author Leonardo Ortega 8-928-1522
 */
public class Fibonacci extends Thread {
 public int num;
 public int resultados;
 public Fibonacci( int num)
	{
		this.num = num;
	}
	
	public void run() 
	{
          
        if( ( num==0) || ( num== 1) )
        {
            resultados=1;
        ;
        }
		else
		    {
		    	Fibonacci fibo1 = new Fibonacci(num - 1);
		    	Fibonacci fibo2 = new Fibonacci(num - 2);
                     
                        
                        
		    	fibo1.start();
		    	fibo2.start();
                       
		    	try{
		    fibo1.join();
                              
		    fibo2.join();
                            
		    		
		    	}catch( InterruptedException e ) {}
                        
                        resultados = fibo1.getResultado() + fibo2.getResultado();
		    }
	}
	
	public int getResultado()
	{
		return resultados;
	}
	
        
        }
 




