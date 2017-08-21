/**
 * 
 */
package org.formation.proxibanquev3.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author winathan
 *
 */
@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Compte compteADebiter;
	private Compte compteACrediter;

	// Getters et Setters
	public Compte getCompteADebiter() {
		return compteADebiter;
	}

	public void setCompteADebiter(Compte compteADebiter) {
		this.compteADebiter = compteADebiter;
	}

	public Compte getCompteACrediter() {
		return compteACrediter;
	}

	public void setCompteACrediter(Compte compteACrediter) {
		this.compteACrediter = compteACrediter;
	}

	/**
	 * Constructeur par défaut (Exigence JPA)
	 */
	public Virement() {
		super();
	}

	/**
	 * Constructeur en utilisant les paramètres :
	 * 
	 * @param dateOperation
	 * @param montant
	 * @param compteADebiter
	 * @param compteACrediter
	 */
	public Virement(Date dateOperation, double montant, Compte compteADebiter, Compte compteACrediter) {
		super(dateOperation, montant);
		this.compteADebiter = compteADebiter;
		this.compteACrediter = compteACrediter;
	}

}
