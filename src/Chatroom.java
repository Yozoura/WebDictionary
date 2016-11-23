import javax.swing.*;
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
		userOnline.addElement("four");
		JList online = new JList(userOnline);
		//getContentPane().setBounds(arg0);
		//online.setBounds(30, 60,200,25);
		JScrollPane a = new JScrollPane(online);
		a.setBounds(30, 60, 300, 100);
		a.setBackground(getContentPane().getBackground());
		
		Vector userOffline = new Vector();
		userOffline.addElement("three");
		userOffline.addElement("four");
		JList offline = new JList(userOffline);
		
		JLabel lab1 = new JLabel();
		lab1.setText("‘⁄œﬂ∫√”—");
		lab1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		lab1.setIcon(new ImageIcon("img/ico1.png"));
		//lab1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		lab1.setBounds(30, 30, 100, 25);
		
		getContentPane().add(lab1);
		getContentPane().add(a);
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
