package br.com.Api_Empresa.Controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.Api_Empresa.DAO.GerenteDAO;
import br.com.Api_Empresa.Model.Gerente;


@Path("gerentes")
public class GerenteController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Gerente> listChamados() {
		try {
			GerenteDAO GerenteDAO = new GerenteDAO();
			return GerenteDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Gerente getChamado(@PathParam("id") long id_gerente) {
		try {
			GerenteDAO GerenteDAO = new GerenteDAO();
			return GerenteDAO.selecionar(id_gerente);
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Gerente gerente) {
		try {
			GerenteDAO GerenteDAO = new GerenteDAO();
			GerenteDAO.inserir(gerente);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Gerente gerente) {
		try {
			

			GerenteDAO GerenteDAO = new GerenteDAO();
			GerenteDAO.alterar(gerente);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id_gerente) {
		try {
			GerenteDAO GerenteDAO = new GerenteDAO();
			GerenteDAO.excluir(id_gerente);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id_gerente) {
		try {
			GerenteDAO GerenteDAO = new GerenteDAO();

			Gerente c = GerenteDAO.selecionar(id_gerente);
			

			GerenteDAO.alterar(c);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(GerenteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
