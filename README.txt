	    ************************************
     *****      Livrables			  	*****
	    ************************************	
		
Sur le lien Github :  https://github.com/Van75/proxi3NV

1-Le projet ProxibanqueV3NV 
2-Les diagrammes UML de classe (Proxi3NV.png, Proxi3NVmetier.png)
3-La Javadoc
4-Les maquettes Balasamik
5-Le war : Proxybanquev3.war



	************************************
*****  	Description de l'application   	*****
	************************************

ProxiBanqueSI est une application visant à permettre à  des conseillers de clientèle de:

- Créer des nouveaux clients avec, par défaut 2 comptes ayant une date d'ouverture: un compte courant initialisé à 2000€ 
avec une autorisation de découvert de 100€ , ainsi qu'un compte épargne initialisé à 1500€
au taux de rémunération de 1.5%. 
- Editer et modifier les informations d'un client (Nom, Prénom, Ville)
- Supprimer un client
- Voir la liste de tous les clients




	************************************
*****  	Structure informatique du projet   	*****
	************************************

L'application a été réalisée en projet Java Enterprise Edition et est structurée en 4 packages de base :

- org.formation.proxibanquev3.dao
- org.formation.proxibanquev3.model
- org.formation.proxibanquev3.service
- org.formation.proxibanquev3.view


Le package dao contient la classe ClientDao implémentant l'interface IClientDao. 
Y sont codées les méthodes du CRUD (insérer, lire, modifier, supprimer) pour communiquer avec la base de données. 

Le package model contient les beans métier, notamment le Client, le Conseiller et les différents Comptes.

Le package service contient la classe ServiceClient implémentant l'interface IServiceClient.

Le package view contient le controlleur ClientController permettant de faire le lien entre les requêtes de l'utilisateur et l'infrastructure logicielle sus-citée.


	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les démarches suivantes:


1) Dans la commande de git tapper: git clone git@github.com:Van75/proxy3NV.git

2) Pour lancer l'application, récupérez le ficher Proxybanquev3NV.war et placez-le dans le dossier bin/webapps de votre conteneur web Apache Tomcat 8.0

2) Lancez une invite de commande (cmd.exe) et placez-vous dans le répertoire bin de votre conteneur web Apache Tomcat 8.0

3) Démarrez Tomcat en utilisant la commande : startup.bat

4) Ouvrez votre navigateur web et rentrez l'adresse : http://localhost:8080/Proxybanquev3NV/

5) Configurez un role avec mot de passe dans le fichier tomcat-users.xml afin de vous connecter à l'application ( role par défaut : tomcat )


	************************************
*****  	Prochaines  extentions    	*****
	************************************
	
1- Créer des comptes via l'application
2- Effectuer des virements
	