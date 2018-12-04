/**
 * @(#)Escucha.java
 *
 *
 * @author 
 * @version 1.00 2016/8/26
 */
import java.awt.event.*;
import java.awt.*;

public class Escucha implements ActionListener{
	private TextArea tarea;
     private TextField tfield;
     public Escucha(TextArea tarea, TextField tfield)
     {
     	this.tarea=tarea;
     	this.tfield=tfield;
     }
public void actionPerformed(ActionEvent e){
     	String c= e.getActionCommand();
     	if(c.equals("Send"))
     	{
     	tarea.setText(tarea.getText()+"\n"+tfield.getText());
     	tfield.setText("");
     	}
     	if(c.equals("Quick"))
     	{
     	System.exit(0);	
     	}
     }
    public Escucha() {
    }
    
    
}