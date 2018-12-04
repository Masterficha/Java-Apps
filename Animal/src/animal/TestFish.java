
import javax.swing.JOptionPane;

/**
 * @(#)TestFish.java
 *
 *
 * @author 
 * @version 1.00 2010/9/27
 */

public class TestFish {
        
    /**
     * Creates a new instance of <code>TestFish</code>.
     */
    public TestFish() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fish f1 = new Fish();
        f1.setName("Nemo");
        JOptionPane.showMessageDialog(null, "Su nombre es: " + f1.getName());
        f1.play();
        f1.eat();
        
        Cat c1 = new Cat();
        c1.setName("Silvestre");
         JOptionPane.showMessageDialog(null, "Su nombre es: " + c1.getName());
        c1.play();
        c1.eat();
        c1.walk();
        
        Spider s1 = new Spider();
        s1.eat();
        
        
       
        
    }
}
