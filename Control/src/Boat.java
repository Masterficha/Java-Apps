


public class Boat extends Thread {

    Control control;
    private int id;
    
    public Boat(Control control,int id)
    {
       this.control=control;
       this.id=id;
       
    }
    
    public void sailAway() throws InterruptedException
    {
        
        control.sailAway();
    } 
    
      public void sailBack() throws InterruptedException
    {
        
      control.sailBack();
    }
      
      public void run()
      {
          boolean contador = true;
          while ( contador ) 
          {
           
           
            try { 
                sailAway();
                sailBack();
            } catch (InterruptedException ex) {}
           
          }
      }
}
