/**
 * @author
 * Pol Vales - ls30599@salleurl.edu
 * Enric Marin - ls31308@salleurl.edu
 * Diego Bellino - ls30741@salleurl.edu
 * Jordi Rubio - ls31289@salleurl.edu
 * David Estepa - ls30622@salleurl.edu
 * DPO2 (Disseny i programacio orientats a objectes)
 * La Salle, Universitat Ramon Llull
 */

package network.segment;

/**
 * The Class BJEnd.
 */
public class BJEnd extends Segment {
	private static final long serialVersionUID = 1L;
	private float guanys;
	private float diners;

	/**
	 * Instantiates a new BJEnd segment.
	 *
	 * @param guanys
	 * @param diners
	 */
	public BJEnd(float guanys, float diners) {
		super();
		this.guanys = guanys;
		this.diners = diners;
	}

	/**
	 * Gets guanys.
	 *
	 * @return guanys
	 */
	public float getGuanys() {
		return guanys;
	}

	/**
	 * Sets guanys.
	 *
	 * @param guanys
	 */
	public void setGuanys(float guanys) {
		this.guanys = guanys;
	}

	/**
	 * Gets diners.
	 *
	 * @return diners
	 */
	public float getDiners() {
		return diners;
	}

	/**
	 * Sets diners.
	 *
	 * @param diners
	 */
	public void setDiners(float diners) {
		this.diners = diners;
	}
}
