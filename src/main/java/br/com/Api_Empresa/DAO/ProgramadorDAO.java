package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Programador;

public class ProgramadorDAO {

	private final ConexaoJDBC conexao;

	public ProgramadorDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Programador programador) throws SQLException, ClassNotFoundException {
		Long idProgramador = null;
		String sqlQuery = "INSERT INTO programador (nm_programador, sl_programador) VALUES (?, ?) ; ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, programador.getId_programador());
			stmt.setString(2, programador.getLg_programador());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return idProgramador;
	}

	public int alterar(Programador programador) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE programador SET nm_programador= ?, sl_programador= ? WHERE id_programador = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, programador.getId_programador());
			stmt.setString(2, programador.getLg_programador());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long idProgramador) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM programador WHERE id_programador= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, idProgramador);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Programador selecionar(long idProgramador) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM programador WHERE id_programador = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, idProgramador);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Programador> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM programador ORDER BY id_programador";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Programador> programadores = new ArrayList<>();

			while (rs.next()) {
				programadores.add(parser(rs));
			}

			return programadores;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Programador parser(ResultSet resultSet) throws SQLException {

		Programador c = new Programador();
		c.setId_programador(resultSet.getLong("idProgramador"));
		c.setLg_programador(resultSet.getString("nmProgramador"));
		return c;

	}

}
