import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame{

	public Login(){
	
		setLayout(new GridLayout(4,1,0,10));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel password = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel identify = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel button = new JPanel(new FlowLayout());
		
		JLabel label1 = new JLabel("ÕËºÅ:");
		label1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JTextField jtf1 = new JTextField(10);
		
		JLabel label2 = new JLabel("ÃÜÂë:");
		label2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JPasswordField jtf2 = new JPasswordField(10);		
		jtf2.setEchoChar((char) 0);
		
		JLabel label3 = new JLabel("ÑéÖ¤Âë:");
		label3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JTextField jtf3 = new JTextField(5);
		String randomText = "abcd";
		
		JLabel label4 = new JLabel(randomText);
		//CAPTCHALable label = new CAPTCHALabel(randomText);
		
		JButton jb1 = new JButton("µÇÂ½");
		jb1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JButton jb2 = new JButton("×¢²á");
		jb2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		name.add(label1);
		name.add(jtf1);
		
		password.add(label2);
		password.add(jtf2);
		
		identify.add(label3);
		identify.add(jtf3);
		identify.add(label4);
		
		button.add(jb1);
		button.add(jb2);
		
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainScreen main = new mainScreen();
				dispose();
				main.setVisible(true);
			}
			
		});
		
		jb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Register reg = new Register();
				dispose();
				reg.setVisible(true);
			}
			
		});
		
		getContentPane().add(name);
		getContentPane().add(password);
		getContentPane().add(identify);
		getContentPane().add(button);
		
		setTitle("Welcome");
		pack();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 270);
		setLocationRelativeTo(null);
		
	}

	public static void main(String []args){
		
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e){
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
						Login main = new Login();
						main.setVisible(true);	
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		);
		
	}
	
}
