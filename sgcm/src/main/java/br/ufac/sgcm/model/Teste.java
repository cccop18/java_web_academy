package br.ufac.sgcm.model;

import java.sql.Connection;

import br.ufac.sgcm.dao.ConexaoDB;

public class Teste {
    public static void main(String[] args) {
        Especialidade e1 = new Especialidade();
        e1.setNome("Cardiologista");
        System.out.println(e1.getNome());

        // Criar um objeto da classe ConxeaoDB
        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = conexao.getConexao();
        if (instancia != null)
            System.out.println("Conexão realizada com sucesso!");
        else
            System.out.println("Falha na conexão.");

    }
}
