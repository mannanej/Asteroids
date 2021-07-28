import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 3893425775641156235L;
	public JFrame frame;
	public Ship ship;

	public Panel(JFrame frame) {

		this.frame = frame;
		this.frame.setBackground(Color.BLACK);
		this.ship = new Ship(500, 500);
		this.frame.addKeyListener(new KeyList(this.ship));
	}

	@Override
	public void paintComponent(Graphics g) {

		this.ship.drawOn(g);
	}

	public void update() {

		this.ship.update();
	}
}
