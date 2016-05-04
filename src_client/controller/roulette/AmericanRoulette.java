package controller.roulette;

import java.awt.Color;
import java.util.ArrayList;

import model.struct.roulette.Casella;

public class AmericanRoulette {

	String[] num_casella = { "3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "2", "5", "8", "11",
			"14", "17", "20", "23", "26", "29", "32", "35", "1", "4", "7", "10", "13", "16", "19", "22", "25", "28",
			"31", "34" };

	Boolean[] color_caselles = { true, false, true, true, false, true, true, false, true, true, false, true, false,
			true, false, false, true, false, false, true, false, false, true, false, true, false, true, false, false,
			true, false, false, true, true, false, true };

	private final int rows = 3;
	private final int column = 12;
	private final int totalNumers = (rows * column);
	private final Color backgroundColor = new Color(76, 145, 65);
	private ArrayList<Casella> caselles;

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public AmericanRoulette() {
		setCaselles();
	}

	public void setCaselles(String[] caselles) {
		this.num_casella = caselles;
	}

	public Boolean[] getColorCaselles() {
		return color_caselles;
	}

	public void setColorCaselles(Boolean[] color_caselles) {
		this.color_caselles = color_caselles;
	}

	public void setCaselles() {
		caselles = new ArrayList<model.struct.roulette.Casella>();
		for (int i = 0; i < totalNumers; i++) {
			caselles.add(new model.struct.roulette.Casella(Integer.parseInt(num_casella[i]), color_caselles[i]));
		}
	}
	public ArrayList<Casella> getCaselles() {
		return caselles;
	}
}