import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;

public class Search extends JFrame{

	public Search(){
		setLayout(null);
		
		JPanel input = new JPanel(new BorderLayout());
		JButton search = new JButton("Search");
		search.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		JTextField jtf = new JTextField();
		input.add("West", new JLabel("Type Word Here"));
		input.add("Center", jtf);
		input.add("East", search);
		input.setBounds(20, 10, 400, 30);
		
		JPanel choose = new JPanel(new GridLayout(1,3));
		
		JCheckBox baidu = new JCheckBox("百度");
		baidu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		baidu.setMnemonic(KeyEvent.VK_G);
		baidu.setSelected(true);
		
		JCheckBox youdao = new JCheckBox("有道");
		youdao.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		youdao.setMnemonic(KeyEvent.VK_G);
		youdao.setSelected(true);	
		
		JCheckBox jinshan = new JCheckBox("金山");
		jinshan.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jinshan.setMnemonic(KeyEvent.VK_G);
		jinshan.setSelected(true);		
		choose.add(baidu);
		choose.add(youdao);
		choose.add(jinshan);
		choose.setBounds(40, 45, 400, 20);
		
		JPanel result = new JPanel(new GridLayout(3,1));
		
		ImageIcon unlike = new ImageIcon("img//like.png");
		unlike.setImage(unlike.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		JButton giveMeFive1 = new JButton();
		giveMeFive1.setIcon(unlike);
		giveMeFive1.setBounds(350, 45, 20, 20);
		
		JButton giveMeFive2 = new JButton();
		giveMeFive2.setIcon(unlike);
		giveMeFive2.setBounds(350, 45, 20, 20);
		
		JButton giveMeFive3 = new JButton();
		giveMeFive3.setIcon(unlike);
		giveMeFive3.setBounds(350, 45, 20, 20);
		
		JTextField baiduRes = new JTextField();
		baiduRes.setBorder(new TitledBorder("百度"));	
		baiduRes.add(giveMeFive1);
		baiduRes.setEditable(false);
		
		JTextField youdaoRes = new JTextField();
		youdaoRes.add(giveMeFive2);
		youdaoRes.setBorder(new TitledBorder("有道"));
		youdaoRes.setEditable(false);
		
		JTextField jinshanRes = new JTextField();
		jinshanRes.add(giveMeFive3);
		jinshanRes.setBorder(new TitledBorder("金山"));
		jinshanRes.setEditable(false);
		
		result.add(baiduRes);
		result.add(youdaoRes);
		result.add(jinshanRes);
		result.setBounds(20, 70, 400, 270);
		
		giveMeFive1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("百度+1");
			}
			
		});
		
		giveMeFive2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("有道+1");
			}
			
		});
		
		giveMeFive3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("金山+1");
			}
			
		});
		
		search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String word = jtf.getText();
				
			}
			
		});
		
		getContentPane().add(input);
		getContentPane().add(choose);
		getContentPane().add(result);
		
		setTitle("Search");
		pack();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(470, 400);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e){
			e.printStackTrace();
		}
		Search main = new Search();
		main.setVisible(true);
	}

}


