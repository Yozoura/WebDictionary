import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;

public class mainScreen extends JFrame{

	public mainScreen(){
		setLayout(new BorderLayout(5,10));
		
		JPanel logout = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel logo = new JPanel();
		JPanel search = new JPanel(new GridLayout(2,1,0,10));
		
		//ÓÒÉÏ½ÇÏÔÊ¾
		JLabel lab1 = new JLabel("ÄúÒÔ");
		lab1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		String user = "stary";
		JLabel lab2 = new JLabel(user);
		lab2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		JLabel lab3 = new JLabel("µÇÂ½");
		lab3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JLabel lab4 = new JLabel("ÍË³ö");
		lab4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		
		logout.add(lab1);
		logout.add(lab2);
		logout.add(lab3);
		logout.add(lab4);
		//ÏÂ·½ËÑË÷ÏÔÊ¾
		JPanel input = new JPanel(new FlowLayout());
		JTextField jtf = new JTextField(25);
		jtf.setSize(50,10);
		JButton jbt = new JButton("Search");		
		input.add(jtf);
		input.add(jbt);
	
		JPanel menu = new JPanel(new FlowLayout());
		JButton user1 = new JButton("ºÃÓÑÁÐ±í");
		user1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		JButton help = new JButton("°ïÖú");
		help.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menu.add(user1);
		menu.add(help);
		
		search.add(input);
		search.add(menu);
		//ÖÐ¼älogo
		ImageIcon imag = new ImageIcon("img\\1.jpg");
		imag.setImage(imag.getImage().getScaledInstance(170, 160, Image.SCALE_DEFAULT));
		
		JLabel pic = new JLabel(imag);
		logo.add(pic);
			
		
		
		getContentPane().add("North", logout);
		getContentPane().add("Center", logo);
		getContentPane().add("South", search);
		
		//µã»÷ÓÃ»§Ãû³Æ¼àÌýÆ÷
		lab2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ÄãµãÁËÎÒ");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//µã»÷ÍË³ö¼àÌýÆ÷
		lab4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		user1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Chatroom OtherFrame = new Chatroom();
				OtherFrame.setVisible(true);
				//OtherFrame.setSize(400, 300);
			}
			
		});
		
		setTitle("WebDictionary");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e){
			e.printStackTrace();
		}
		mainScreen main = new mainScreen();
		main.setVisible(true);
	}

}
