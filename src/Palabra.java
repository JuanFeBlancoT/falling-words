
import processing.core.PApplet;

public class Palabra {

	private int posX, posY, vel, r, g, b;
	private boolean selected, canMove;
	private String palabra;
	
	public Palabra(String pal) {
		palabra = pal;
		posX= (int) (Math.random()*940+20);
		posY= (int) (Math.random()*-450-50);
		vel= (int) (Math.random()*2+1);
		selected = false;
		canMove = true;
		r=0;
		g=0;
		b=0;
	}
	
	public void drawP(PApplet app) {
		app.fill(r,g,b);
		app.text(palabra, posX, posY);
		
	}
	
	public void mover() {
		posY+=vel;
		if(posY>915) {
			posY = -15;
		}
	}
	
	public void crearPalabra() {
		posX= (int) (Math.random()*350+10);
		posY= (int) (Math.random()*-450-50);
		vel= (int) (Math.random()*2+1);
		//vel = 5;
	}

	public String getPalabra() {
		return palabra;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
		
	
}
