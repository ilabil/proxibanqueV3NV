package org.formation.proxibanquev3.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.formation.proxibanquev3.dao.IClientDao;
import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.model.Compte;
import org.formation.proxibanquev3.model.CompteCourant;
import org.formation.proxibanquev3.model.CompteEpargne;

public class TestVirement {

	// appel du DaoClient

	@Inject
	static IClientDao daoClient;

	public static void main(String[] args) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Calendar cal = Calendar.getInstance();

		/**
		 * on crée 2 clients avec 2 comptes (épargne et courant) chacun :
		 * 
		 * client 1:
		 * 
		 * solde compte courant = 2000,0 
		 * solde compte épargne = 1500,0
		 * 
		 * 
		 * 
		 * client 2:
		 * 
		 * 
		 * solde compte courant = 1500,0 
		 * solde compte épargne = 3000,0
		 */

		// Client 1
		
		String David = "", Banner="", Paris="";
		
		Client cli1 = new Client(David, Banner, Paris);

		CompteCourant cc1 = new CompteCourant(cal.getTime(), 2000.0, 100.0);
		CompteEpargne ce1 = new CompteEpargne(cal.getTime(), 1500.0, 1.5);

		List<Compte> listeComptes1 = new ArrayList<Compte>();
		listeComptes1.add(cc1);
		listeComptes1.add(ce1);

		cli1.setListeComptes(listeComptes1);

		// client 2
		
		String John = "", Williams="", London="";
		
		Client cli2 = new Client(John, Williams,London );
		CompteCourant cc2 = new CompteCourant(cal.getTime(), 1500.0, 100.0);
		CompteEpargne ce2 = new CompteEpargne(cal.getTime(), 3000.0, 1.5);

		List<Compte> listeComptes2 = new ArrayList<Compte>();
		listeComptes2.add(cc2);
		listeComptes2.add(ce2);
		cli2.setListeComptes(listeComptes2);

		// on sauvegarde les 2 clients dans la BDD

		try {
			daoClient.addClient(cli1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			daoClient.addClient(cli2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Traitement virement cli1 à cli2 de compte courant à compte courant
		 * 
		 * ---------- avec succes ---------
		 * 
		 */
		
		// on retrouve les 2 cliens dans la base 
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
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

}
