package nickBallGen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Nick extends JPanel implements MouseListener{
	
	JFrame frame = new JFrame();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel("label2");
	JTextField textField1 = new JTextField(20);
	JTextField textField2 = new JTextField(20);
	JLabel resetLabel = new JLabel();
	JButton button2 = new JButton("button2");
	GamePanel gamePanel = new GamePanel();
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1000;
	public static final int HEADER_HEIGHT = 80;
	public static final int RESET_LABEL_WIDTH = 80;
	public static final int RESET_LABEL_HEIGHT = 80;
	public static final int HEADER_WIDTH = WIDTH - RESET_LABEL_WIDTH;
	public static final int GAME_HEIGHT = HEIGHT - HEADER_HEIGHT;
	public static final int GAME_WIDTH = WIDTH;
	
	Nick(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setUndecorated(true);
		frame.add(this);
		add(label1);
		//add(label2);
		//add(textField1);
		//add(textField2);
		add(resetLabel);
		//add(button2);
		add(gamePanel);
		setLayout(null);
		createHeader();
		gamePanel.setBounds(0, HEADER_HEIGHT, WIDTH, GAME_HEIGHT);
//		frame.add(label1);
//		frame.add(label2);
//		frame.add(textField1);
//		frame.add(textField2);
//		frame.add(button1);
//		frame.add(button2);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}

	private void createHeader() {
		label1.setText("Ball Gen");
		label1.setBounds(0, 0, HEADER_WIDTH, HEADER_HEIGHT);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setBackground(Color.darkGray);
		label1.setForeground(Color.lightGray);
		label1.setFont(new Font("Courier New", Font.BOLD, 20));
		
		resetLabel.setText("Reset");
		resetLabel.setBounds(HEADER_WIDTH, 0, HEADER_HEIGHT,  RESET_LABEL_HEIGHT);
		resetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resetLabel.addMouseListener(this);
		resetLabel.setOpaque(true);
		resetLabel.setBackground(Color.lightGray);
		resetLabel.setForeground(Color.darkGray);
		resetLabel.setFont(new Font("Courier New", Font.BOLD, 15));
		
	}
	
	public static void main(String[] args) {
		
			new Nick();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		gamePanel.reset();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
