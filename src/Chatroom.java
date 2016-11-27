import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Chatroom extends JFrame{

	public Chatroom(){
		setLayout(null);
		Vector userOnline = new Vector();
		userOnline.addElement("one");
		userOnline.addElement("two");
		userOnline.addElement("three");
		userOnline.addElement("three");
		
		JList online = new JList(userOnline);
		TitledBorder nameTitle = new TitledBorder("‘⁄œﬂ”√ªß");
		nameTitle.setTitleFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		online.setBorder(nameTitle);
		JScrollPane a = new JScrollPane(online);
		a.setBounds(30, 60, 200, 100);
		
		TitledBorder nameTitle2 = new TitledBorder("¿Îœﬂ”√ªß");
		nameTitle2.setTitleFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		Vector userOffline = new Vector();
		userOffline.addElement("three");
		userOffline.addElement("four");
		JList offline = new JList(userOffline);
		offline.setBorder(nameTitle2);
		JScrollPane b = new JScrollPane(offline);
		b.setBounds(30, 160, 200, 100);
		 
		
		
		online.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String name = (String)online.getSelectedValue();
				JTextField chatLabel = new JTextField();
				chatLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
				chatLabel.setBounds(250, 60, 200, 150);
				chatLabel.setEditable(false);
				chatLabel.setSize(200, 150);
				chatLabel.setBackground(Color.white);
				//chatLabel.setLineWrap(true);
				TitledBorder nameTitle3 = new TitledBorder(name);
				nameTitle3.setTitleFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
				chatLabel.setBorder(nameTitle3);
				getContentPane().add(chatLabel);
				
				
				
			}
			
		});
		
		getContentPane().add(a);
		getContentPane().add(b);
		pack();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e){
			e.printStackTrace();
		}*/
		Chatroom main = new Chatroom();
		main.setVisible(true);
	}

}
