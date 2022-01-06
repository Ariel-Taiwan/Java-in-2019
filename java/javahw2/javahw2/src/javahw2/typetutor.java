package javahw2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class typetutor extends JFrame{
	private int width = 880, length = 600;
	private String Boxname = "Typing Application";
	private String Post;
	private String TextString;
	
	private static JButton[][] keyBoardBut = new JButton[5][40];
	
	private JTextArea Postbox,TextInput;
    private JPanel jPanel;
    private JFrame jFrame;
	
	
	public typetutor() {
		super("typing tutor");
		setLayout(new FlowLayout());
		Post = "Type some text using your keyboard. The keys press will be highlighted and the text will be displayed.\r\nNote: Clicking the buttons with your mouse will not perform any action.";
		jPanel = new JPanel();
        //keyBoard = new KeyBoard();
        
        //jframe.setLocationRelativeTo(null);
        
		// text board
		TextString = "";
		TextInput = new JTextArea(TextString);
		TextInput.setSize(815, 200);
        TextInput.setLocation(20, 60);
		TextInput.setLineWrap(true);
		TextInput.setFocusable(true);
		TextInput.setWrapStyleWord(true);
		TextInput.setEnabled(true);
		TextInput.addKeyListener(this);
		
		
		// post
        Postbox = new JTextArea(Post);
		Postbox.setSize(600, 50);
        Postbox.setLocation(20, 10);
        Postbox.setFocusable(false);
        Postbox.setBackground(null);
        Postbox.setLineWrap(true);
        Postbox.setWrapStyleWord(true);
        // keyboard button
		addKeyboardBut();
		
		
		
		jPanel.add(Postbox);
		jPanel.add(TextInput);
		
		this.setTitle(Boxname);
		this.setFocusable(false);
		this.setEnabled(true);
        this.requestFocusInWindow();
		
		this.setSize(width, length);
		this.setBackground(Color.GRAY);
        this.setContentPane(jPanel);
		this.setLayout(null);
        this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}
	String[][] key = { 
	{"~","1","2","3","4","5","6","7","8","9","0","-","=","Backspace"},
	{"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"},
	{"Caps","A","S","D","F","G","H","J","K","L",";","'","Enter"},
	{"Shift","Z","X","C","V","B","N","M",",",".","?","\u2191"},
	{" ","\u2190","\u2193","\u2192"}
	};
}
