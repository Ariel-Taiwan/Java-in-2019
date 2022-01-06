package javahw3;

import javax.swing.*; // import all javax.swing
import java.awt.*; // import all java.awt
import java.awt.event.*;

public class typing extends JFrame implements KeyListener {
	private int wid = 880, leng = 600;
	private String name = "typing tutor";
	private String textstr;
	private String up;
	
	private static JButton[] kbbutton = new JButton[41];
	
    private JTextArea field = new JTextArea(10,15);
    private JPanel jPanel= new JPanel();;
    private JFrame jFrame;
    private JTextArea uptext;

    private static JButton Space = new JButton("");

    public typing() { // start of the weather constructor
    	up="Type some text using your keyboard. The keys press will be highlighted and the text will be displayed.\r\nNote: Clicking the buttons with your mouse will not perform any action.";
    	
    	textstr = "";
		field = new JTextArea(textstr);
		field.setSize(800, 200);
		field.setLocation(25, 45);
		field.setLineWrap(true);
		field.setFocusable(true);
		field.setWrapStyleWord(true);
		field.setEnabled(true);
		field.addKeyListener(this);
        Space.setPreferredSize(new Dimension(270, 45));
        uptext = new JTextArea(up);
        uptext.setSize(600, 50);
		uptext.setLocation(20, 10);
		uptext.setFocusable(false);
		uptext.setBackground(null);
		uptext.setLineWrap(true);
		uptext.setWrapStyleWord(true);
        Space.setSelected(true);
        field.addKeyListener(this); // important !!!

        setTitle("typing tutor"); // set the title to the frame
        setSize(350, 350); // set the fixed size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setVisible(true); // make it visible
        
        String[] key={"~","1","2","3","4","5","6","7","8","9","0","-","=","Backspace","Tab","q","w","e","r","t","y","u","i","o","p","[","]","\\","Caps","a","s","d","f","g","h","j","k","l",";","'","Enter","Shift","z","x","c","v","b","n","m",",",".","?","\u2191"," ","\u2190","\u2193","\u2192"};
        		Font monospaced = new Font("Monospaced",Font.ITALIC, 11);
        		for (int r=0;r<key.length;r++) {
        			int dew = 45;
        			int desp = 5;
        			int Bntwe = dew;
        			int Bnthe = dew;
        			int Bntx = desp*4;
        			int Bnty = 280+(dew+desp)*r;
        			for(int c=0;c<key.length;c++){
        				switch(key[c]){
        					case "Backspace":
        						Bntwe = dew*2+desp;
        						break;
        					case "Tab":
        						Bntwe = (int)((double)dew*1.5);
        						break;
        					case "Caps":
        						
        						break;
        					case "Shift":
        						Bntwe = dew*2;
        						break;
        					case " ":
        						Bntx +=  3*(Bntwe+desp)-desp;
        						Bntwe = (int)((double)dew*7.5)+desp;
        						break;
        					case "Enter":
        						Bntwe = dew*2+desp;
        						break;
        					case "\u2190":
        						Bntx += desp+(2*dew-3*desp);
        						Bntwe = dew;
        						break;
        					case "\u2191":
        						Bntx += (1*dew-3*desp);
        						Bntwe = dew;
        					default:
        						Bntwe = dew;
        						break;
        				}
        				kbbutton[c] = new JButton(key[c]);
                        //b[row][col].setFont(monospaced);
        				kbbutton[c].setBounds(Bntx, Bnty, Bntwe, Bnthe);
        				kbbutton[c].setBorder(BorderFactory.createRaisedBevelBorder());
        				kbbutton[c].setFocusable(false);
        				Bntx += (Bntwe+desp);
        				kbbutton[c].setBackground(null);
        				
                        jPanel.add(kbbutton[c]);
                        //buttonBackground = b[row][col].getBackground();
        			} 
                }
        
        jPanel.add(field);
        
        this.setTitle(name);
		this.setFocusable(false);
		this.setEnabled(true);
        this.requestFocusInWindow();
		
		this.setSize(wid, leng);
		this.setBackground(Color.GRAY);
        this.setContentPane(jPanel);
		this.setLayout(null);
        this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    } // ends of the constructor

    public void keyPressed(KeyEvent e) {
    	System.out.println("The key code you pressed:（now the key show blue）");
        System.out.println(e.getKeyCode());
		
		int[][] vk_key ={
		{192,49,50,51,52,53,54,55,56,57,48,45,61,8},
        {KeyEvent.VK_TAB,81,87,69,82,84,89,85,73,79,80,91,93,92},
        {20,65,83,68,70,71,72,74,75,76,59,222,10},
        {16,90,88,67,86,66,78,77,44,46,47,38},
        {32,37,40,39}
        };
		for (int r=0;r<vk_key.length;r++)
			for(int c=0;c<vk_key[r].length;c++)
				if(vk_key[r][c] == e.getKeyCode())
					kbbutton[c].setBackground(Color.blue);
    }
    public void keyReleased(KeyEvent evt) {
        Space.setBackground(null);
    }

    public void keyTyped(KeyEvent evt) {
        // TODO Auto-generated method stub
    	if(evt.getKeyChar() == 'a' || evt.getKeyChar() ==  'A')
        {
            Space.setBackground(Color.green);
        }
        else if(evt.getKeyChar() == 'b' || evt.getKeyChar() == 'B')
        {
            Space.setBackground(Color.red);
        }       
    }

    public static void main(String[] args) { // start of the main method

        new typing();

    } // ends of main method

} // ends of class