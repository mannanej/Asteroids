import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ship {

	int x;
	int y;
	int velX;
	int velY;
	int radius;
	int moveSpeed;
	int frameMaxX;
	int frameMaxY;

	public Ship(int x, int y) {

		this.x = x;
		this.y = y;
		this.radius = 50;
		this.moveSpeed = 5;
		this.frameMaxX = 1275;
		this.frameMaxY = 675;
		this.velX = 0;
		this.velY = 0;
	}

	public void drawOn(Graphics g) {

		g = (Graphics2D) g.create();
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[] {this.x, this.x + 50, this.x + 100}, new int[] {this.y, this.y - 50, this.y}, 3);
	}

	public void update() {

		this.x += this.velX;
		this.y += this.velY;
		if ((this.y - (this.radius - 45)) <= 0 || (this.y + (this.radius + 40)) >= this.frameMaxY) {
			this.velY = (-1) * this.velY;
		}
		if ((this.x - (this.radius - 45)) <= 0 || (this.x + (this.radius + 20)) >= this.frameMaxX) {
			this.velX = (-1) * this.velX;
		}
		if (this.x >= 1275 || this.x <= 0) {
			this.stop();
			this.x = (int) Math.min(Math.max(this.x, 0), this.frameMaxX);
			this.velX = 0;
		}
		if (this.y >= 675 || this.y <= 0) {
			this.stop();
			this.y = (int) Math.min(Math.max(this.y, 0), this.frameMaxY);
			this.velY = (-1) * this.velY;
		}
	}

	public void normalizeVelocity() {

		double vectorLength = Math.sqrt(this.velX * this.velX + this.velY * this.velY);

		this.velX = (int) (this.velX / vectorLength * this.moveSpeed * 2);
		this.velY = (int) (this.velY / vectorLength * this.moveSpeed * 2);
	}

	public void moveLeft() {

		this.velX = (-1) * this.moveSpeed;
		this.velY = 0;
		this.normalizeVelocity();
	}

	public void moveRight() {

		this.velX = this.moveSpeed;
		this.velY = 0;
		this.normalizeVelocity();
	}

	public void moveUp() {

		this.velX = 0;
		this.velY = (-1) * this.moveSpeed;
		this.normalizeVelocity();
	}

	public void moveDown() {

		this.velX = 0;
		this.velY = this.moveSpeed;
		this.normalizeVelocity();
	}

	public void stop() {

		this.velX = 0;
		this.velY = 0;
	}

	public boolean scoreLeft() {

		if (this.x + this.radius >= this.frameMaxX - this.radius / 2) {
			return true;
		}
		return false;
	}

	public boolean scoreRight() {

		if (this.x - this.radius / 8 <= 0) {
			return true;
		}
		return false;
	}

	public void bounceBack() {

		this.velX = (-1) * this.velX;
	}
}
