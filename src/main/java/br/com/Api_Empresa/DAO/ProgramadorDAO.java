package br.com.Api_Empresa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Api_Empresa.Data.ConexaoJDBC;
import br.com.Api_Empresa.Data.ConexaoMysqlJDBC;
import br.com.Api_Empresa.Model.Programador;
import br.com.Api_Empresa.Model.util.TipoFuncionario;


public class ProgramadorDAO {

	private final ConexaoJDBC conexao;

	public ProgramadorDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Programador programador) throws SQLException, ClassNotFoundException {
		Long id_programador = null;
		String sqlQuery = "INSERT INTO funcionario (nm_funcionario, sl_funcionario, lg_programador, tp_funcionario) VALUES (?, ?, ?, " + "\"programador\""+ ") ;";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, programador.getNm_funcionario());
			stmt.setDouble(2, programador.getSl_funcionario());
			stmt.setString(3, programador.getLg_programador());

			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id_programador;
	}

	public int alterar(Programador programador) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE funcionario SET nm_funcionario = ?, sl_funcionario = ?, lg_programador = ? WHERE id_funcionario = ? ";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, programador.getNm_funcionario());
			stmt.setDouble(2, programador.getSl_funcionario());
			stmt.setString(3, programador.getLg_programador());
			stmt.setLong(4, programador.getId_funcionario());

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

	public Programador selecionar(long id_funcionario) throws SQLException, ClassNotFoundException {
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

	public List<Programador> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM funcionario WHERE tp_funcionario = " + "\"programador\"" + " ORDER BY id_funcionario";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Programador> programadors = new ArrayList<>();

			while (rs.next()) {
				programadors.add(parser(rs));
			}

			return programadors;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Programador parser(ResultSet resultSet) throws SQLException {
		Programador c = new Programador();
		
		c.setId_funcionario(resultSet.getLong("id_funcionario"));
		c.setNm_funcionario(resultSet.getString("nm_funcionario"));
		c.setSl_funcionario(resultSet.getDouble("sl_funcionario"));
		c.setLg_programador(resultSet.getString("lg_programador"));
		c.setTp_funcionario(TipoFuncionario.valueOf(resultSet.getString("tp_funcionario")));

		return c;
	}
}