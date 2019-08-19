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

import br.com.Api_Empresa.DAO.ProgramadorDAO;
import br.com.Api_Empresa.Model.Programador;

@Path("programadores")
public class ProgramadorController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Programador> listChamados() {
		try {
     			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();
			return ProgramadorDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(ProgramadorController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Programador getChamado(@PathParam("id") long idProgramador) {
		try {
			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();
			return ProgramadorDAO.selecionar(idProgramador);
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Programador programador) {
		try {
			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();
			ProgramadorDAO.inserir(programador);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Programador programador) {
		try {

			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();
			ProgramadorDAO.alterar(programador);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long idProgramador) {
		try {
			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();
			ProgramadorDAO.excluir(idProgramador);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") long idProgramador) {
		try {
			ProgramadorDAO ProgramadorDAO = new ProgramadorDAO();

			Programador c = ProgramadorDAO.selecionar(idProgramador);

			ProgramadorDAO.alterar(c);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
