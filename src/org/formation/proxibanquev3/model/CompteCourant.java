/**
 * 
 */
package org.formation.proxibanquev3.model;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

/**
 * @Nabil Van-anh
 * La classe compte courant �tend la classe compte 
 *
 */

@Entity
@DiscriminatorValue("COMPTECOURANT")
public class CompteCourant extends Compte {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * Constructeur par d�faut (Exigence JPA)
	 */
	public CompteCourant() {
		super();
	}

	/**
	 * Constructeur en utilisant les param�tres :
	 * @param date 
	 * 
	 * @param decouvert
	 * @param decouvert2 
	 */
	public CompteCourant(Date dateOuverture, double solde, double decouvert) {
		super(dateOuverture,solde);
		this.decouvert = decouvert;
	}

}
