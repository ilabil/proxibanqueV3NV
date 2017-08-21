/**
 * 
 */
package org.formation.proxibanquev3.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

/**
 * @author winathan
 *
 */
@Entity
@Table(name="OPERATIONS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE"
		+ "OPERATION", discriminatorType = DiscriminatorType.STRING)
public abstract class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1764489372739558434L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numOperation;
	private Date dateOperation;
	private double montant;

	@ManyToOne
	@JoinColumn(name = "NUMEROCOMPTE")
	private Compte compte;

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Constructeur par défaut (Exigence JPA)
	 */
	public Operation() {
		super();
	}

	/**
	 * Constructeur en utilisant les paramètres :
	 * 
	 * @param dateOperation
	 * @param montant
	 */
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}

}
