package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Frame extends JFrame {
 
	private static final long serialVersionUID = 1L;

	private Border createNewDefaultBorder()
	{
		return BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
	}
	
	private JPanel createNewSuperiorPanel()
    {
        JPanel sup = new JPanel();
        sup.setLayout(new BoxLayout(sup, BoxLayout.X_AXIS));
        
        // Configure left panel
        JPanel left = new JPanel();
        left.setBackground(null);
        JButton b1 = new JButton("Inserir Projeto");
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setBorder(new RoundedBorder(5));
        b1.setPreferredSize(new Dimension(120,20));
        left.add(b1);
        
        // Configure right panel
        JPanel right = new JPanel( new FlowLayout(FlowLayout.LEADING,10,5));
        right.setPreferredSize(new Dimension(200,35));
        right.setBackground(null);
        JLabel l = new JLabel("Buscar:");
        right.add(l);
        
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(150, 25));
        right.add(tf);
        
        JButton b2 = new JButton("Ok");
        b2.setPreferredSize(new Dimension(50,20));
        b2.setBorder(new RoundedBorder(5));
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        right.add(b2);
        
        // Configure main panel (sup)
        // Add left panel
        sup.add(left);
        
        // Align to right
        sup.add(Box.createHorizontalGlue());
        
        // Add right panel
        sup.add(right);
        
        return sup;
    }
	
	private JPanel createNewInferiorPanel()
	{
		JPanel inf = new JPanel();
		inf.setBorder(this.createNewDefaultBorder());
		return inf;
	}
    
    public Frame(String name)
    {
        super(name);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel top = createNewSuperiorPanel();
        JPanel bottom = createNewInferiorPanel();
        
        mainPanel.add(top, BorderLayout.PAGE_START);
        mainPanel.add(bottom, BorderLayout.CENTER);
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setMinimumSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Frame("CRUD");
    }
    
}
