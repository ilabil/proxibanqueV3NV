package org.formation.proxibanquev3.service;

import java.util.List;

import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.model.Compte;
import org.formation.proxibanquev3.model.CompteCourant;
import org.formation.proxibanquev3.model.CompteEpargne;

public interface IClientService {

	List<Client> getClients() throws Exception;

	void addClient(Client client) throws Exception;

	Client getClient(Long idClient) throws Exception;

	void updateClient(Client client) throws Exception;

	void deleteClient(Long idClient) throws Exception;

	void addCompteCourant(CompteCourant compteCourant) throws Exception;

	void addCompteDepargne(CompteEpargne compteEpargne) throws Exception;

	List<Compte> getComptes(Client client) throws Exception;
}