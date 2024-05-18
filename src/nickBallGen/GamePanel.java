package nickBallGen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {


	Timer frameDraw;

	List<Ball> balls;

	Random random = new Random();

	GamePanel(){
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(Nick.GAME_WIDTH,Nick.GAME_HEIGHT));
		setOpaque(true);
		setBackground(Color.black);

		balls = new ArrayList<>();
		balls.add(new Ball(random.nextInt(Nick.GAME_WIDTH)));
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Ball b : balls) {
			b.draw(g);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Courier New", Font.PLAIN, 12));
		g.drawString("Balls: " + balls.size(), Nick.GAME_WIDTH - 100, 50);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < balls.size(); i++) {
			balls.get(i).update();
		}
		repaint();

	}

	class Ball{
		int x, y, size, yVelocity, xVelocity, gravity;
		Color color;
		public Ball(int x) {
			super();
			this.x = x;
			this.y = 0;
			this.size = 20;
			this.yVelocity = 0;
			this.xVelocity = random.nextInt(30) - 15;
			this.gravity = 1;
			this.color = new Color(30 + random.nextInt(226), 30 + random.nextInt(226), 30 + random.nextInt(226), 150);
		}

		public void update() {
			y += yVelocity;
			x += xVelocity;
			yVelocity += gravity;

			if(x<=0 || x >=Nick.GAME_WIDTH) {
				xVelocity = -xVelocity;
			}



			if(y >= Nick.GAME_HEIGHT-50) {
				yVelocity = - random.nextInt(45);
				if(balls.size()<10000 && random.nextInt(2) == 0) {
					balls.add(new Ball(random.nextInt(Nick.GAME_WIDTH)));
				}
				//				if(balls.size()<10000 ) {
				//
				//
				//
				//					balls.add(new Ball(random.nextInt(Nick.GAME_WIDTH)));
				//					//	balls.add(new Ball(random.nextInt(Nick.GAME_WIDTH)));
				//
				//				}
			}

		}

		void draw(Graphics g) {
			g.setColor(color);
			g.fillOval(x, y, size, size);
		}


	}

	public void reset() {
		balls = new ArrayList<>();
		balls.add(new Ball(random.nextInt(Nick.GAME_WIDTH)));

	}


}
