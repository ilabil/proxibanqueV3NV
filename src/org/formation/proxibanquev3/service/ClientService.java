package org.formation.proxibanquev3.service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.proxibanquev3.dao.IClientDao;
import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.model.Compte;
import org.formation.proxibanquev3.model.CompteCourant;
import org.formation.proxibanquev3.model.CompteEpargne;





/**
 * @author Nabil Van-anh
 *Le service implémente l'interface IClientService, on y appelle les méthodes de la dao
 */
@Named
public class ClientService implements IClientService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7571773500379670076L;
	@Inject
	private IClientDao clientDao;

	@PostConstruct
	public void initService() {
		System.out.println(this.getClass().getName() + "je suis construit");
	}

	@Override
	public List<Client> getClients() throws Exception {
		List<Client> clients = clientDao.getClients();
		return clients;
	}


	@Override
	public Client getClient(Long idClient) throws Exception {
		Client client = clientDao.getClient(idClient);
		return client;
	}

	@Override
	public void updateClient(Client client) throws Exception {
		
		clientDao.updateClient(client);

	}

	@Override
	public void deleteClient(Long idClient) throws Exception {
		clientDao.deleteClient(idClient);
	}

	@Override
	public void addCompteCourant(CompteCourant compteCourant) throws Exception {
		clientDao.addCompteCourant(compteCourant);		
	}

	@Override
	public void addCompteDepargne(CompteEpargne compteEpargne) throws Exception {
		clientDao.addCompteDepargne(compteEpargne);		
	}

	@Override
	public List<Compte> getComptes(Client client) throws Exception {
		List<Compte> listeComptes = clientDao.getComptes(client);	
		return listeComptes;
	}
	
	public void addClient(Client client) throws Exception {
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		 Calendar cal = Calendar.getInstance(); 
		 
		CompteCourant comptecourant = new CompteCourant(cal.getTime(), 2000.0, 100.0);
		CompteEpargne compteepargne = new CompteEpargne(cal.getTime(), 1500.0, 1.5);
		System.out.println(compteepargne);
		List<Compte> listeCompte = new ArrayList<Compte>();
		listeCompte.add(compteepargne);
		listeCompte.add(comptecourant);
		client.setListeComptes(listeCompte);
		System.out.println("Liste des comptes : "+ client.getListeComptes());
		
		clientDao.addClient(client);
		
	}


}
