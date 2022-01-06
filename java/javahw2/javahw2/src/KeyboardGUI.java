import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.lang.*;

public class KeyboardGUI extends JFrame implements KeyListener{
	private int width = 880, length = 600;
	private String Boxname = "Typing Application";
	private String Post;
	private String TextString;
	
	private static JButton[][] keyBoardBut = new JButton[5][40];
	
	private JTextArea Postbox,TextInput;
    private JPanel jPanel;
    private JFrame jFrame;
	
	
	public KeyboardGUI() {
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
	private void addKeyboardBut(){
		String[][] key = { 
        {"~","1","2","3","4","5","6","7","8","9","0","-","=","Backspace"},
        {"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"},
        {"Caps","A","S","D","F","G","H","J","K","L",";","'","Enter"},
        {"Shift","Z","X","C","V","B","N","M",",",".","?","\u2191"},
        {" ","\u2190","\u2193","\u2192"}
        };
		Font monospaced = new Font("Monospaced",Font.PLAIN, 12);
		for (int row=0;row<key.length;row++) {
			int defaultw = 50;
			int defaultsp = 5;
			int Bntweight = defaultw;
			int Bntheight = defaultw;
			int Bntx = defaultsp*4;
			int Bnty = 280+(defaultw+defaultsp)*row;
			for(int col=0;col<key[row].length;col++){
				switch(key[row][col]){
					case "Backspace":
						Bntweight = defaultw*2+defaultsp;
						break;
					case "Tab":
						Bntweight = (int)((double)defaultw*1.5);
						break;
					case "Caps":
						Bntweight = (int)((double)defaultw*1.5);
						break;
					case "Shift":
						Bntweight = defaultw*2;
						break;
					case " ":
						Bntx +=  3*(Bntweight+defaultsp)-defaultsp;
						Bntweight = (int)((double)defaultw*7.5)+defaultsp;
						break;
					case "Enter":
						Bntweight = defaultw*2+defaultsp;
						break;
					case "\u2190":
						Bntx += defaultsp+(2*defaultw-3*defaultsp);
						Bntweight = defaultw;
						break;
					case "\u2191":
						Bntx += (1*defaultw-3*defaultsp);
						Bntweight = defaultw;
					default:
						Bntweight = defaultw;
						break;
				}
				keyBoardBut[row][col] = new JButton(key[row][col]);
                //b[row][col].setFont(monospaced);
                keyBoardBut[row][col].setBounds(Bntx, Bnty, Bntweight, Bntheight);
				keyBoardBut[row][col].setBorder(BorderFactory.createRaisedBevelBorder());
				keyBoardBut[row][col].setFocusable(false);
				Bntx += (Bntweight+defaultsp);
				keyBoardBut[row][col].setBackground(null);
				
                jPanel.add(keyBoardBut[row][col]);
                //buttonBackground = b[row][col].getBackground();
			} 
        }
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
    public void keyPressed (KeyEvent e) {
        System.out.println("you Pressed a key code :");
        System.out.println(e.getKeyCode());
		
		int[][] vk_key ={
		{192,49,50,51,52,53,54,55,56,57,48,45,61,8},
        {KeyEvent.VK_TAB,81,87,69,82,84,89,85,73,79,80,91,93,92},
        {20,65,83,68,70,71,72,74,75,76,59,222,10},
        {16,90,88,67,86,66,78,77,44,46,47,38},
        {32,37,40,39}
        };
		for (int row=0;row<vk_key.length;row++){
			for(int col=0;col<vk_key[row].length;col++){
				if(vk_key[row][col] == e.getKeyCode())
				{
					keyBoardBut[row][col].setBackground(Color.PINK);
				}
			}
		}
		if(e.getKeyCode() == 47)
		{
			String tmp = TextInput.getText();
			tmp = tmp.replace("/", "?");
			TextInput.setText(tmp);
		}
		
    }
	@Override
    public void keyReleased (KeyEvent e) {
        System.out.println("you Released a key code :");
        System.out.println(e.getKeyCode());
		int[][] vk_key ={
		{192,49,50,51,52,53,54,55,56,57,48,45,61,8},
        {KeyEvent.VK_TAB,81,87,69,82,84,89,85,73,79,80,91,93,92},
        {20,65,83,68,70,71,72,74,75,76,59,222,10},
        {16,90,88,67,86,66,78,77,44,46,47,38},
        {32,37,40,39}
        };
		for (int row=0;row<vk_key.length;row++){
			for(int col=0;col<vk_key[row].length;col++){
				if(vk_key[row][col] == e.getKeyCode())
				{
					keyBoardBut[row][col].setBackground(null);
				}
			}
		}
		if(e.getKeyCode() == 47)
		{
			String tmp = TextInput.getText();
			tmp = tmp.replace("/", "?");
			TextInput.setText(tmp);
		}
    }
}