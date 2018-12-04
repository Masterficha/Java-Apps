
import javax.swing.JOptionPane;

/**
 * @(#)Cat.java
 *
 *
 * @author 
 * @version 1.00 2010/9/27
 */


public class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name) {
    	super(4);
    	this.name = name;
    }
   public Cat(){
   	this(null);
   } 
   public  void setName(String name){
   	this.name = name;
   } 
   	public  String getName(){
   		return this.name;
   	}
   	public void walk(){
   		  JOptionPane.showMessageDialog(null, "This animal walk on"  + legs + "legs");
   	}
   	public void play(){
   		  JOptionPane.showMessageDialog(null, name + "like to play with string");
   	}
   	public void eat(){
   		  JOptionPane.showMessageDialog(null, "Cats like to eat spiders an mice");
   	}
}