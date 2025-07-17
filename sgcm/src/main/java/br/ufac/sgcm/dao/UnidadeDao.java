package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements InterfaceDao<Unidade> {

    PreparedStatement ps;
    ResultSet rs;
    Connection conexao;

    public UnidadeDao() {
        conexao = new ConexaoDB().getConexao();
    }

    public Unidade get(Long id) {
        Unidade u = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

}
