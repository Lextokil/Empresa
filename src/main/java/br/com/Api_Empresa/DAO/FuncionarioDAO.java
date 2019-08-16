package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Funcionario;


public class FuncionarioDAO {

	private final ConexaoJDBC conexao;

	public FuncionarioDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO funcionario (nm_funcionario, sl_funcionario) VALUES (?, ?) ; ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, funcionario.getNm_funcionario());
			stmt.setDouble(2, funcionario.getSl_funcionario());
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE funcionario SET nm_funcionario = ?, sl_funcionario = ? WHERE id = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, funcionario.getNm_funcionario());
			stmt.setDouble(2, funcionario.getSl_funcionario());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(long id) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM funcionario WHERE id = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Funcionario selecionar(long id) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE id = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Funcionario> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario ORDER BY id";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Funcionario> funcionarios = new ArrayList<>();

			while (rs.next()) {
				funcionarios.add(parser(rs));
			}

			return funcionarios;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Funcionario parser(ResultSet resultSet) throws SQLException {
		Funcionario c = new Funcionario();

		c.setId_funcionario(resultSet.getLong("id"));
		c.setNm_funcionario(resultSet.getString("nm_funcionario"));
		c.setSl_funcionario(resultSet.getDouble("sl_funcionario"));

		return c;
	}
}