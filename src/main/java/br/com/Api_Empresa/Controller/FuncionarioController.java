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

import br.com.Api_Empresa.DAO.FuncionarioDAO;
import br.com.Api_Empresa.Model.Funcionario;


@Path("funcionarios")
public class FuncionarioController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Funcionario> listChamados() {
		try {
			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
			return FuncionarioDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Funcionario getChamado(@PathParam("id") long id_funcionario) {
		try {
			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
			return FuncionarioDAO.selecionar(id_funcionario);
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Funcionario funcionario) {
		try {
			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
			FuncionarioDAO.inserir(funcionario);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Funcionario funcionario) {
		try {
			

			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
			FuncionarioDAO.alterar(funcionario);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id_funcionario) {
		try {
			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
			FuncionarioDAO.excluir(id_funcionario);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long id_funcionario) {
		try {
			FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();

			Funcionario c = FuncionarioDAO.selecionar(id_funcionario);
			

			FuncionarioDAO.alterar(c);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
