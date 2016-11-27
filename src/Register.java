import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame{

	public Register(){
		
		setLayout(new GridLayout(5,1,10,10));
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel password = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel repassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel email = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel button = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel jlb1 = new JLabel("”√ªß√˚≥∆:");
		jlb1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		JTextField jtf1 = new JTextField(10);
		
		JLabel jlb2 = new JLabel(" ‰»Î√‹¬Î:");
		jlb2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		JTextField jtf2 = new JTextField(10);
		
		JLabel jlb3 = new JLabel("»∑»œ√‹¬Î:");
		jlb3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		JTextField jtf3 = new JTextField(10);
		
		JLabel jlb4 = new JLabel("µÁ◊”” œ‰:");
		jlb4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		JTextField jtf4 = new JTextField(10);
		
		JButton commit = new JButton("»∑»œ");
		commit.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		JButton cancel = new JButton("»°œ˚");
		cancel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		
		name.add(jlb1);
		name.add(jtf1);
		
		password.add(jlb2);
		password.add(jtf2);
		
		repassword.add(jlb3);
		repassword.add(jtf3);
		
		email.add(jlb4);
		email.add(jtf4);
		
		button.add(commit);
		button.add(cancel);
		
		commit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login main = new Login();
				dispose();
				main.setVisible(true);
			}
			
		});
		
		getContentPane().add(name);
		getContentPane().add(password);
		getContentPane().add(repassword);
		getContentPane().add(email);
		getContentPane().add(button);
		
		setTitle("”√ªß◊¢≤·");
		pack();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 270);
		setLocationRelativeTo(null);
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.put("Button.font", new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		} catch (Throwable e){
			e.printStackTrace();
		}
		Register main = new Register();
		main.setVisible(true);
	}

}
