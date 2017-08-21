/**
 * 
 */
package org.formation.proxibanquev3.model;

/**
 * @author winathan
 *
 */
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.*;

@Entity
@ManagedBean
@Table(name="COMPTES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPECOMPTE", discriminatorType = DiscriminatorType.STRING)
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 616010423016209133L;
	/**
	 * 
	 */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numeroCompte;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOuverture;
	private double solde;
	
	@OneToMany(mappedBy="compte",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Operation> listeOperations;


	// ** si on veut retrouver un client à partir d'un compte
	
	@ManyToOne
	@JoinColumn(name="IDCLIENT")
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	// ************************************

	// Getters et Setters
	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}
	
	
	/**
	 * Constructeur par défaut (Exigence JPA)
	 */
	public Compte() {
		super();
	}

	/**
	 * Constructeur en utilisant les paramètres :
	 * 
	 * @param numeroCompte
	 * @param dateOuverture
	 * @param solde
	 */
	public Compte(Date dateOuverture, double solde) {
		super();
		this.dateOuverture = dateOuverture;
		this.solde = solde;
	}

}
