


public class River {
    
    
    static final int PASSENGERS=4;
    static final int CAPACITY=2;
    Thread bote; 
    Passenger passenger[];
    Thread [] pasajeros;
    Control control;
    
      public static void main(String [] args)
      {
          
          Control control=new Control(CAPACITY);
         
         Boat boat= new Boat(control,4);
         Thread bote = new Thread(boat);
         bote.setDaemon(true);
         bote.start();
       
         
          Thread [] pasajeros = new Thread[4];
          
        Passenger passenger [] = new  Passenger[4];
        try{  
        for (int i= 0; i < 4; i++)
        {
        passenger[i] = new  Passenger(control,i+1);

       pasajeros[i] = new Thread(passenger[i]);
		pasajeros[i].start();
                pasajeros[i].join(20);
             }
           
        
        } catch (InterruptedException e) { }
    
}
}
