


public class Passenger extends Thread {
    
    Control control;
    private int id;
    
    
    public Passenger(Control control, int id)
    {
        this.control=control;      
        this.id=id;
    }
    
    public void walk()
    {
      System.out.println("Passenger "+id+" .walk");  
       
    }
    
    public void enter() throws InterruptedException
    {
        control.enter(id);
    }
    
    public void exit() throws InterruptedException
    {       
       
        control.exit(id);
    }
    
      public void run()
      {
         while(true){  
            try {
                walk();
                enter();
                exit();
            } catch (InterruptedException ex) {}
           
         }
          }
      }

