import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldResult extends JTextField{

	private ImageIcon icon;
	
	public JTextFieldResult(){
		icon = new ImageIcon("img//like.png");
		Insets insets = new Insets(200, 200, 0, 0);
		this.setMargin(insets);
		this.setBorder(new TitledBorder("°Ù¶È"));
	}
	
	public void paintComponent(Graphics g){
		Insets insets = getInsets();
		super.paintComponent(g);
		int iconWidth = icon.getIconWidth();
		int iconHeight = icon.getIconHeight();
		int Height = this.getHeight();
		
		icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame a = new JFrame();
		a.add(new JTextFieldResult());
		a.setVisible(true);
		a.setSize(300,300);
	}

}
