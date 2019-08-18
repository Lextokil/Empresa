package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Mecanico;
import br.com.Api_Empresa.Model.util.TipoFuncionario;


public class MecanicoDAO {

	private final ConexaoJDBC conexao;

	public MecanicoDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Mecanico mecanico) throws SQLException, ClassNotFoundException {
		Long id_mecanico = null;
		String sqlQuery = "INSERT INTO funcionario (nm_funcionario, sl_funcionario, st_mecanico, tp_funcionario) VALUES (?, ?, ?, " + "\"mecanico\""+ ") ;";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, mecanico.getNm_funcionario());
			stmt.setDouble(2, mecanico.getSl_funcionario());
			stmt.setString(3, mecanico.getSt_mecanico());

			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id_mecanico;
	}

	public int alterar(Mecanico mecanico) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE funcionario SET nm_funcionario = ?, sl_funcionario = ?, st_mecanico = ? WHERE id_funcionario = ? ";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, mecanico.getNm_funcionario());
			stmt.setDouble(2, mecanico.getSl_funcionario());
			stmt.setString(3, mecanico.getSt_mecanico());
			stmt.setLong(4, mecanico.getId_funcionario());

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

	public Mecanico selecionar(long id_funcionario) throws SQLException, ClassNotFoundException {
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

	public List<Mecanico> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE tp_funcionario = " + "\"mecanico\"" + " ORDER BY id_funcionario";

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
		
		c.setId_funcionario(resultSet.getLong("id_funcionario"));
		c.setNm_funcionario(resultSet.getString("nm_funcionario"));
		c.setSl_funcionario(resultSet.getDouble("sl_funcionario"));
		c.setSt_mecanico(resultSet.getString("st_mecanico"));
		c.setTp_funcionario(TipoFuncionario.valueOf(resultSet.getString("tp_funcionario")));

		return c;
	}
}