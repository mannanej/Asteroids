import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList implements KeyListener {

	public Ship ship;

	public KeyList(Ship ship) {

		this.ship = ship;
	}

	@Override
	public void keyTyped(KeyEvent e) {

		// Do Nothing
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			System.out.println("UP");
			this.ship.moveUp();
		} else if (key == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			this.ship.moveDown();
		} else if (key == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			this.ship.moveLeft();
		} else if (key == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			this.ship.moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			System.out.println("STOP");
			this.ship.stop();
		}
	}
}
