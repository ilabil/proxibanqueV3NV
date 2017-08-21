package org.formation.proxibanquev3.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.formation.proxibanquev3.model.Client;
import org.formation.proxibanquev3.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named
@SessionScoped

public class ClientController implements Serializable {

	private static final long serialVersionUID = 3774463683041113840L;

	private List<Client> clients;
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);


	@Inject
	private IClientService service;

	public ClientController() throws Exception {
		clients = new ArrayList<>();

	}

	@PostConstruct
	public void initService() {
		System.out.println(this.getClass().getName() + "je suis ;;construit !" + service);
	}

	public List<Client> getClients() {
		return clients;
	}

	public void loadClients() {
		System.out.println("!!!!!! V'la les clients !!!!!!!!!");

		LOGGER.debug("lister clients");
		LOGGER.info("information");

		clients.clear();

		try {

			clients = service.getClients();

		} catch (Exception exc) {
		
			addErrorMessage(exc);
		}
	}

	public String addClient(Client client) {

	

		try {

			
			service.addClient(client);

		} catch (Exception exc) {
	
			addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}

	public String loadClient(Long idClient) {

	

		try {
			
			Client client = service.getClient(idClient);

	
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", client);

		} catch (Exception exc) {
		
			addErrorMessage(exc);

			return null;
		}

		return "update-client-form.xhtml";
	}

	public String updateClient(Client client) {

	

		try {

		
			service.updateClient(client);

		} catch (Exception exc) {
			
			addErrorMessage(exc);

			return null;
		}

		return "list-clients?faces-redirect=true";
	}

	public String deleteClient(Long idClient) {

	

		try {

			
			service.deleteClient(idClient);

		} catch (Exception exc) {

			addErrorMessage(exc);

			return null;
		}

		return "list-clients";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String logOut() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.invalidateSession();
		return "login";
	}

}
