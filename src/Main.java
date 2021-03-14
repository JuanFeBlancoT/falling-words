import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet{
	public static void main (String[] args) {
		PApplet.main("Main");
	}
	
	private String[] textS;
	private String[] lines;
	private ArrayList<String> words;
	private ArrayList<Palabra> palabritas;
	
	public void settings() {
		size(400,400);
	}
	
	public void setup() {
		textSize(20);
		textS=loadStrings("strings.txt");
		words = new ArrayList<>();
		palabritas = new ArrayList<>();
		
		for (int i = 0; i < textS.length; i++) {
			
			lines = split(textS[i], " ");
			for (int j = 0; j < lines.length; j++) {
				words.add(lines[j]);
			}
		}
		
		for (int i = 0; i < words.size(); i++) {
			palabritas.add(new Palabra(words.get(i)));
		}
		
	}

	public void draw() {
		background(250);
		for (int i = 0; i <palabritas.size() ; i++) {
			//palabritas.get(i).crearPalabra();
			palabritas.get(i).drawP(this);
			palabritas.get(i).mover();
		}
		
	}
} 
