/**
 * 
 */
package org.formation.proxibanquev3.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
  * @Nabil Van-anh
 * La classe compte �pargne �tend la classe compte 
 *
 */

@Entity
@DiscriminatorValue("COMPTEDEPARGNE")
public class CompteEpargne extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private double tauxRemuneration;

	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * Constructeur par d�faut (Exigence JPA)
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * Constructeur en utilisant les param�tres :
	 * 
	 * @param tauxRemuneration
	 */
	public CompteEpargne(Date dateOuverture, double solde, double tauxRemuneration) {
		super(dateOuverture,solde);
		this.tauxRemuneration = tauxRemuneration;
	}

}
