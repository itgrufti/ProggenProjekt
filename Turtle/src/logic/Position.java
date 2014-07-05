package logic;

public class Position {
	public Position() {
		this.positionX = 0;
		this.positionY = 0;
		this.angle = 0;
		this.penState=true;
	}
	private int positionX;
	private int positionY;
	private int angle;
	boolean penState;
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public boolean getPenState() {
		return penState;
	}
	public void setPenState(boolean state) {
		this.penState=state;
	}

}
