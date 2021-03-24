package ui;
import java.util.ArrayList;

import model.Palabra;
import processing.core.PApplet;

public class Main extends PApplet{
	public static void main (String[] args) {
		PApplet.main("ui.Main");
	}
	
	int spawnTime, index, buttonControl;
	private Palabra[] wordsToMatch;
	private String[] textS;
	private String[] lines;
	private ArrayList<String> words;
	private ArrayList<Palabra> palabritas;
	
	public void settings() {
		size(1000,900);
	}
	
	public void setup() {
		spawnTime = 0;
		index = 0;
		buttonControl=0;
		textSize(20);
		textS=loadStrings("strings.txt");
		wordsToMatch = new Palabra[4];
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
			
		wordsToMatch = selectWords();

	}

	public void draw() {
		
		background(250);
		fill(0);
		for (int i = 0; i <palabritas.size() ; i++) {
			//palabritas.get(i).crearPalabra();
			palabritas.get(i).drawP(this);
			palabritas.get(i).mover();
		}
		
		fill(220);
		rect(500, 750, 500, 300);
		
		for (int i = 0; i < wordsToMatch.length; i++) {
			
			if(wordsToMatch[i].isSelected()==false) {
				wordsToMatch[i].setPosX(550+i*100);
				wordsToMatch[i].setPosY(800);
			}else {
				wordsToMatch[i].setPosX(mouseX);
				wordsToMatch[i].setPosY(mouseY);
			}
			
			wordsToMatch[i].drawP(this);
		}
		
		validateDistance();
		
		if(buttonControl==4) {
			fill(40,180,120);
			rect(700, 820, 150, 50);
		}
		
	}


	
	public Palabra[] selectWords() {
		
		int x = -1;
		Palabra[] palabrasAb = new Palabra[4];
		for (int i = 0; i < palabrasAb.length; i++) {
			x = (int) random(0,palabritas.size());
			palabrasAb[i] = new Palabra(palabritas.get(x).getPalabra());
		}
		return palabrasAb;
	}
	
	public void mouseClicked() {
		if(mouseX>500 && mouseY>750) {
			for (int i = 0; i < wordsToMatch.length; i++) {
				if(wordsToMatch[i].isCanMove() && dist(mouseX, mouseY, wordsToMatch[i].getPosX(), wordsToMatch[i].getPosY())<30) {
					wordsToMatch[i].setSelected(true);
				}
			}
		}
		if(buttonControl==4 && mouseX>700 && mouseX<850 && mouseY>820 && mouseY<870) {
			saveNewString();
		}
		
		
	}
	
	private void saveNewString() {
		
		for (int i = 0; i < palabritas.size(); i++) {
			if(!palabritas.get(i).isCanMove()) {
				palabritas.get(i).setPalabra(palabritas.get(i).getPalabra().toUpperCase());
			}else {
				palabritas.get(i).setPalabra(palabritas.get(i).getPalabra().toLowerCase());
			}
		}
		
		String[] newWords = new String[palabritas.size()];
		
		for (int i = 0; i < palabritas.size(); i++) {
			newWords[i] = palabritas.get(i).getPalabra();
		}
		
		
		saveStrings("data/newWordsFile.txt", newWords);
	}

	public void mouseReleased() {
		if(mouseX>500 && mouseY>750) {
			for (int i = 0; i < wordsToMatch.length; i++) {
					wordsToMatch[i].setSelected(false);
			}
		}
	}
	
	public void validateDistance() {
		for (int i = 0; i < wordsToMatch.length; i++) {
			for (int j = 0; j < palabritas.size(); j++) {

				if(wordsToMatch[i].isSelected() && dist(wordsToMatch[i].getPosX(), wordsToMatch[i].getPosY(),
						palabritas.get(j).getPosX(), palabritas.get(j).getPosY())<15 && 
						wordsToMatch[i].getPalabra().equals(palabritas.get(j).getPalabra())) {
					wordsToMatch[i].setSelected(false);
					wordsToMatch[i].setCanMove(false);
					palabritas.get(j).setCanMove(false);
					wordsToMatch[i].setG(200);
					wordsToMatch[i].setB(100);
					buttonControl++;
				}
			}
		}
	}
} 

