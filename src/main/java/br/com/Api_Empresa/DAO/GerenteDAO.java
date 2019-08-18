package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Gerente;
import br.com.Api_Empresa.Model.util.TipoFuncionario;


public class GerenteDAO {

	private final ConexaoJDBC conexao;

	public GerenteDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Gerente gerente) throws SQLException, ClassNotFoundException {
		Long id_gerente = null;
		String sqlQuery = "INSERT INTO funcionario (nm_funcionario, sl_funcionario, pw_gerente, tp_funcionario) VALUES (?, ?, ?, " + "\"gerente\""+ ") ;";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, gerente.getNm_funcionario());
			stmt.setDouble(2, gerente.getSl_funcionario());
			stmt.setString(3, gerente.getPw_gerente());

			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id_gerente;
	}

	public int alterar(Gerente gerente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE funcionario SET nm_funcionario = ?, sl_funcionario = ?, pw_gerente = ? WHERE id_funcionario = ? ";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, gerente.getNm_funcionario());
			stmt.setDouble(2, gerente.getSl_funcionario());
			stmt.setString(3, gerente.getPw_gerente());
			stmt.setLong(4, gerente.getId_funcionario());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long id_funcionario) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM funcionario WHERE id_funcionario = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id_funcionario);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Gerente selecionar(long id_funcionario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE id_funcionario = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id_funcionario);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Gerente> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE tp_funcionario = " + "\"gerente\"" + " ORDER BY id_funcionario";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Gerente> gerentes = new ArrayList<>();

			while (rs.next()) {
				gerentes.add(parser(rs));
			}

			return gerentes;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Gerente parser(ResultSet resultSet) throws SQLException {
		Gerente c = new Gerente();
		
		c.setId_funcionario(resultSet.getLong("id_funcionario"));
		c.setNm_funcionario(resultSet.getString("nm_funcionario"));
		c.setSl_funcionario(resultSet.getDouble("sl_funcionario"));
		c.setPw_gerente(resultSet.getString("pw_gerente"));
		c.setTp_funcionario(TipoFuncionario.valueOf(resultSet.getString("tp_funcionario")));

		return c;
	}
}