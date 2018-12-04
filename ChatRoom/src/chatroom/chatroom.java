import java.awt.*;


public class chatroom extends Frame 
{
	private Button send, quick;
     private TextArea tarea;
     private TextField tfield;
    
     
	public chatroom(String title)
	{
		super(title);
		send = new Button("Send");
		quick = new Button("Quick");
		tarea = new TextArea();
		tfield = new TextField();
		Panel estePanel = new Panel(new GridLayout(2,1));
		estePanel.add(send);
		estePanel.add(quick);
		this.add(estePanel, BorderLayout.EAST);
		this.add(tarea, BorderLayout.WEST);
		this.add(tfield, BorderLayout.SOUTH);
		Escucha k= new Escucha(tarea, tfield);
		send.addActionListener(k);
		quick.addActionListener(k);
	}

	public static void main(String [] args)
	{
		Frame f = new chatroom("ChatRoom");
		f.pack();
		f.setVisible(true);
	}
	 
}