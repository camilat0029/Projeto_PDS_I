package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;
import model.Usuario;

public class UsuarioDAO {
	
	// CREATE - Adicionar um novo usuário
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, cpf, administrador) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setBoolean(3, usuario.isAdministrador());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // READ - Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Usuario usuario = new Usuario(sql, sql, false);
                usuario.setNome(rset.getString("nome"));
                usuario.setCpf(rset.getString("cpf"));
                usuario.setAdministrador(rset.getBoolean("administrador")); //Talvez seja assim
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return usuarios;
    }
    
    // UPDATE - Atualizar um usuário existente
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, administrador = ? WHERE cpf = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setBoolean(2, usuario.isAdministrador());
            pstm.setString(3, usuario.getCpf());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    // DELETE - Excluir um usuário pelo ID
    public void excluirUsuario(String cpf) {
        String sql = "DELETE FROM usuarios WHERE cpf = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}
