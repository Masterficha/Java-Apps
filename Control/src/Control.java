


public class Control {

    protected int  capacity;
    
    public Control(int capacity)
    {
        this.capacity=capacity;
    }    
    
    
    
    public void enter(int id) throws InterruptedException
    {
        System.out.println("passenger "+ id +" enter");
    }
    
   public void sailAway() throws InterruptedException
    {
        System.out.println("sal_away");
    } 
    
    public void exit(int id) throws InterruptedException
    {
        System.out.println("passenger "+id+" exit");
    }
    
    public void sailBack() throws InterruptedException
    {
        System.out.println("sail_back");
    }
}
