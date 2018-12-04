
import javax.swing.JOptionPane;

/**
 * @(#)Fish.java
 *
 *
 * @author 
 * @version 1.00 2010/9/27
 */


public class Fish extends Animal implements Pet{
    private String name;
    public Fish() {
    	super(0);
    }
   public void walk(){
   	  JOptionPane.showMessageDialog(null, "Fish, of course can�t walk; they swiming" );
   	
   } 
  public void eat(){
  	  JOptionPane.showMessageDialog(null, "Fish eat pond scum.");
  }  
  public void setName(String name){
  	this.name = name;
    }	
  public String getName(){
  	return this.name;
  }  
  	public void play(){
  		  JOptionPane.showMessageDialog(null, "Fish swim in their tanks all day");
  	}	
}