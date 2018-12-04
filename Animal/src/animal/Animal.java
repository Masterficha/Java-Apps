/**
 * @(#)Animal.java
 *
 *
 * @author 
 * @version 1.00 2010/9/27
 */


public abstract class Animal {
     protected int legs;
     
    protected  Animal(int legs) {
    	this.legs = legs;
    }
  
  public void walk(){
  	System.out.println("This animal walk on"  + legs);
  	  }
  public abstract void eat();
  
    
}