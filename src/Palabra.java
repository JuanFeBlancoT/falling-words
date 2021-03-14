
import processing.core.PApplet;

public class Palabra {

	private int posX, posY, vel;
	private String palabra;
	
	public Palabra(String pal) {
		palabra = pal;
		posX= (int) (Math.random()*350+10);
		posY= (int) (Math.random()*-450-50);
		vel= (int) (Math.random()*2+1);
	}
	
	public void drawP(PApplet app) {
		app.fill(0);
		app.text(palabra, posX, posY);
		
	}
	
	public void mover() {
		posY+=vel;
	}
	
	public void crearPalabra() {
		posX= (int) (Math.random()*350+10);
		posY= (int) (Math.random()*-450-50);
		vel= (int) (Math.random()*2+1);
		//vel = 5;
	}
	
	
}
