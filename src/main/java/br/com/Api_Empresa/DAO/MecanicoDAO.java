package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Mecanico;

public class MecanicoDAO {

	private final ConexaoJDBC conexao;

	public MecanicoDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Mecanico mecanico) throws SQLException, ClassNotFoundException {
		Long idMecanico = null;
		String sqlQuery = "INSERT INTO mecanico (nm_mecanico, sl_mecanico) VALUES (?, ?) ; ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, mecanico.getId_mecanico());
			stmt.setString(2, mecanico.getSt_mecanico());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return idMecanico;
	}

	public int alterar(Mecanico mecanico) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE mecanico SET nm_mecanico= ?, sl_mecanico= ? WHERE id_mecanico = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, mecanico.getId_mecanico());
			stmt.setString(2, mecanico.getSt_mecanico());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long idMecanico) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM mecanico WHERE id_mecanico= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, idMecanico);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Mecanico selecionar(long idMecanico) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM mecanico WHERE id_mecanico = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, idMecanico);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Mecanico> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM mecanico ORDER BY id_mecanico";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Mecanico> mecanicos = new ArrayList<>();

			while (rs.next()) {
				mecanicos.add(parser(rs));
			}

			return mecanicos;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Mecanico parser(ResultSet resultSet) throws SQLException {

		Mecanico c = new Mecanico();
		c.setId_mecanico(resultSet.getLong("idMecanico"));
		c.setSt_mecanico(resultSet.getString("nmMecanico"));
		return c;

	}

}
