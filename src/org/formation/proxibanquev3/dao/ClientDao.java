package org.formation.proxibanquev3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;

import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.model.Compte;
import org.formation.proxibanquev3.model.CompteCourant;
import org.formation.proxibanquev3.model.CompteEpargne;

@Named
@ApplicationScoped
/**
 * 
 * @author NV 
 * 
 * Classe d'implémention de l'interface IClientDao
 * permet de réaliser les méthodes du crud à savoir la création d'un client, la modification d'un client, la récupération des clients, la suppression d'un client
 *
 */
public class ClientDao implements IClientDao{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");


	@Override
	public List<Client> getClients() throws Exception {
	
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		List<Client> retList = new ArrayList<>();
		try {
			txn.begin();
			TypedQuery<Client>query=em.createQuery("from Client", Client.class);
			retList = query.getResultList();
		
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}
		return retList;
		
	}

	@Override
	public void addClient(Client client) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			em.persist(client);
		
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		
	}

		
		
	}

	@Override
	public Client getClient(Long idClient) throws Exception {
		Client client = new Client();
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			 client = em.find(Client.class, idClient);
		
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}
		return client;
	}



	@Override
	public void deleteClient(Long idClient) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Client client = em.find(Client.class, idClient);
			em.remove(client);
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}

			
			
			
	}

	@Override
	public void updateClient(Client client) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.merge(client);
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public void addCompteCourant(CompteCourant compteCourant) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.merge(compteCourant);
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void addCompteDepargne(CompteEpargne compteEpargne) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.merge(compteEpargne);
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}
	}

		

	@Override
	public List<Compte> getComptes(Client client) throws Exception {

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		List<Compte> retList = new ArrayList<>();		
		try {
			txn.begin();
			Client cli = em.find(Client.class, client.getIdClient());
			retList = cli.getListeComptes();
			txn.commit();
		} catch (Exception e) {
			if(txn!= null) {
				txn.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if (em != null) {
				em.close();
			}
		}
		
		return retList;
	}

}
