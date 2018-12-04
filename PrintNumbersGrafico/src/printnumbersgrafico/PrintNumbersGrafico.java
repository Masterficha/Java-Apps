/**
 * @(#)PrintNumbersGrafico.java
 *
 *
 * @author 
 * @version 1.00 2011/10/11
 */
import java.awt.*;
import javax.swing.*;

public class PrintNumbersGrafico implements Runnable
{
	public boolean keepGoing;
    public int numVeces;
    
	public PrintNumbersGrafico(int n)
	{
		keepGoing = true;
		numVeces = n;
	}

	public void stopPrinting()
	{
		keepGoing = false;
	}

	public void run()
	{
		int counter = 0;
		JFrame h= new JFrame("Print en modo Grafico");
		h.setVisible(true);
		JTextArea display = new JTextArea(){
     	
        public void paintComponent(Graphics g) {
        UIDefaults uid = UIManager.getDefaults();
        Graphics2D g2d = (Graphics2D)g;

        int w = getWidth();
        int h = getHeight();

        Color lightBlue = new Color(216,231,243);
        Color darkBlue = new Color(255, 255, 255);
        
        if (!isOpaque()) {
            super.paintComponent( g );
            return;
        }

        GradientPaint gp = new GradientPaint(0, 0, lightBlue, 0, h, darkBlue );

        g2d.setPaint(gp);
       
        

        setOpaque( false );
        super.paintComponent( g );
        setOpaque( true );
    }

      };  
		JScrollPane barra = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		display.setFont(new Font("MV Boli", Font.PLAIN,35 ));
		h.add(display,BorderLayout.CENTER);
		h.setSize(500,400);
		h.setLocation(400,100);
		h.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		while(keepGoing)
		{
		//display.setText("");
		display.append("\n"+ ++counter  );
		
			//System.out.println(++counter);
			try
			{
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{}
			//
			// System.out.println(Thread.currentThread());
			if( counter == numVeces)
			stopPrinting();
		}
	}
}