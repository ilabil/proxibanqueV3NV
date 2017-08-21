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

ProxiBanqueSI est une application visant � permettre �  des conseillers de client�le de:

- Cr�er des nouveaux clients avec, par d�faut 2 comptes ayant une date d'ouverture: un compte courant initialis� � 2000� 
avec une autorisation de d�couvert de 100� , ainsi qu'un compte �pargne initialis� � 1500�
au taux de r�mun�ration de 1.5%. 
- Editer et modifier les informations d'un client (Nom, Pr�nom, Ville)
- Supprimer un client
- Voir la liste de tous les clients




	************************************
*****  	Structure informatique du projet   	*****
	************************************

L'application a �t� r�alis�e en projet Java Enterprise Edition et est structur�e en 4 packages de base :

- org.formation.proxibanquev3.dao
- org.formation.proxibanquev3.model
- org.formation.proxibanquev3.service
- org.formation.proxibanquev3.view


Le package dao contient la classe ClientDao impl�mentant l'interface IClientDao. 
Y sont cod�es les m�thodes du CRUD (ins�rer, lire, modifier, supprimer) pour communiquer avec la base de donn�es. 

Le package model contient les beans m�tier, notamment le Client, le Conseiller et les diff�rents Comptes.

Le package service contient la classe ServiceClient impl�mentant l'interface IServiceClient.

Le package view contient le controlleur ClientController permettant de faire le lien entre les requ�tes de l'utilisateur et l'infrastructure logicielle sus-cit�e.


	
	************************************
***** 	Execution de l'application:    		*****
	************************************

Veuillez suivre les d�marches suivantes:


1) Dans la commande de git tapper: git clone git@github.com:Van75/proxy3NV.git

2) Pour lancer l'application, r�cup�rez le ficher Proxybanquev3NV.war et placez-le dans le dossier bin/webapps de votre conteneur web Apache Tomcat 8.0

2) Lancez une invite de commande (cmd.exe) et placez-vous dans le r�pertoire bin de votre conteneur web Apache Tomcat 8.0

3) D�marrez Tomcat en utilisant la commande : startup.bat

4) Ouvrez votre navigateur web et rentrez l'adresse : http://localhost:8080/Proxybanquev3NV/

5) Configurez un role avec mot de passe dans le fichier tomcat-users.xml afin de vous connecter � l'application ( role par d�faut : tomcat )


	************************************
*****  	Prochaines  extentions    	*****
	************************************
	
1- Cr�er des comptes via l'application
2- Effectuer des virements
	