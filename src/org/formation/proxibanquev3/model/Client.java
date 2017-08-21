package org.formation.proxibanquev3.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;




@Entity
@ManagedBean
@Table(name="CLIENTS")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4457029357359257829L;
	/**
	 * 
	 */

	//Completer pour JPA
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idClient;
	private String firstName;
	private String lastName;
	private String ville;
	private String email;
	
	public Client(String firstName, String lastName, String ville, String email, List<Compte> listeComptes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ville = ville;
		this.email = email;
		this.listeComptes = listeComptes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="client", fetch=FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<Compte> listeComptes;
	
	// ** si on veut retrouver un conseiller à partir d'un client
	
	@ManyToOne
	@JoinColumn(name="IDCONSEILLER")
	private Conseiller conseiller;
	
	public Client() {
	}
	
	public Client(String firstName, String lastName, String ville) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ville = ville;
	}
	
	

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Client [id=" + idClient + ", firstName=" + firstName + ", lastName="
				+ lastName + ", ville=" + ville + "]";
	}

}
