package chat;

import java.awt.BorderLayout;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat_first{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Chat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout( new BorderLayout() );
		
		JTextArea textarea = new JTextArea();
		textarea.setEditable(false);
		JTextField textfield = new JTextField(20);
		JPanel panel = new JPanel();
		JButton button = new JButton("Sent");
		
		panel.setLayout( new BorderLayout() );
		panel.add(button,BorderLayout.EAST);
		panel.add(textfield,BorderLayout.CENTER);
		
		frame.add(panel, BorderLayout.SOUTH);
		frame.add(textarea, BorderLayout.CENTER);
		
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);  // put frame in center of the screen
		frame.setVisible(true);
		
		int option = JOptionPane.showOptionDialog(frame, "Do you want to host or connect?", "Host or Connect", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Host", "Connect"}, null);
		
		try {
			Socket socket;
			
			if(option == 0) {
				ServerSocket server = new ServerSocket(8180);
				socket = server.accept();
				server.close();
			} else {
				String ip = JOptionPane.showInputDialog(frame, "What IP you what to connect to?");
				socket = new Socket(ip, 8180);
			}
			
			PrintWriter out = new PrintWriter( socket.getOutputStream() );
			Scanner in = new Scanner(socket.getInputStream());
			
			button.addActionListener((e) -> {
				out.println( textfield.getText() );
				out.flush();
				textarea.append(textfield.getText());
				textfield.setText("");
				textfield.requestFocus();
			});
			
			textfield.requestFocus();
			
			while( socket.isConnected() ) {
				while(in.hasNext()) {
					textarea.append(in.next());
				}
				Thread.sleep(50);
			}
			
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}