/**
 * 
 */
package org.formation.proxibanquev3.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;
/**
 * @author winathan
 *
 */
@Entity
@Table(name="CONSEILLERS")
public class Conseiller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2971168845452355660L;
	/**
	 * 
	 */
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idConseiller;
	private String nomConseiller;
	private String prenomConseiller;
	
	@OneToMany(mappedBy="conseiller",fetch=FetchType.LAZY)
	private List<Client> listeClients;

	public Long getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(Long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNomConseiller() {
		return nomConseiller;
	}

	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}

	public String getPrenomConseiller() {
		return prenomConseiller;
	}

	public void setPrenomConseiller(String prenomConseiller) {
		this.prenomConseiller = prenomConseiller;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * Constructeur par défaut (Exigence JPA)
	 */
	public Conseiller() {
		super();
	}

	/**
	 * Constructeur en utilisant les paramètres :
	 * 
	 * @param nomConseiller
	 * @param prenomConseiller
	 */
	public Conseiller(String nomConseiller, String prenomConseiller) {
		super();
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
	}

}
