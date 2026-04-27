package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;
import model.Produtos;

public class ProdutosDAO {
	
	// CREATE - Adicionar um novo produtos
    public void adicionarProdutos(Produtos produtos) {
        String sql = "INSERT INTO produtos (codigoBarras, nome, valor, marca, fornecedora, quantidade, descricao, "
        		+ "cor, dataValidade, dataFabricacao) "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, produtos.getCodigoBarras());
            pstm.setString(2, produtos.getNome());
            pstm.setFloat(3, produtos.getValor());
            pstm.setString(4, produtos.getMarca());
            pstm.setString(5, produtos.getFornecedora());
            pstm.setInt(6, produtos.getQuantidade());
            pstm.setString(7, produtos.getDescricao());
            pstm.setString(8, produtos.getCor());
            pstm.setString(9, produtos.getDataValidade());
            pstm.setString(10, produtos.getDataFabricacao());
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
    
 // READ - Listar todos os produdos
    public List<Produtos> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        List<Produtos> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produtos produto = new Produtos(0, sql, 0, sql, sql, 0, sql, sql, sql, sql);
                produto.setCodigoBarras(rset.getInt("codigoBarras"));
                produto.setNome(rset.getString("nome"));
                produto.setValor(rset.getFloat("valor"));
                produto.setMarca(rset.getString("marca"));
                produto.setFornecedora(rset.getString("fornecedora"));
                produto.setQuantidade(rset.getInt("quantidade"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setCor(rset.getString("cor"));
                produto.setDataValidade(rset.getString("dataValidade"));
                produto.setDataFabricacao(rset.getString("dataFabricacao"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return produtos;
    }
    

    // UPDATE - Atualizar um prduto existente
    public void atualizarProdutos(Produtos produtos) {
        String sql = "UPDATE produtos SET nome = ?, valor = ?, marca = ?, fornecedora = ?, quantidade = ?,"
        		+ "descricao = ?, cor = ?, dataValidade = ?, dataFabricacao = ? WHERE codigoBarras = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produtos.getNome());
            pstm.setFloat(2, produtos.getValor());
            pstm.setString(3, produtos.getMarca());
            pstm.setString(4, produtos.getFornecedora());
            pstm.setInt(5, produtos.getQuantidade());
            pstm.setString(6, produtos.getDescricao());
            pstm.setString(7, produtos.getCor());
            pstm.setString(8, produtos.getDataValidade());
            pstm.setString(9, produtos.getDataFabricacao());
            pstm.setInt(10, produtos.getCodigoBarras());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    // DELETE - Excluir um produto pelo ID
    public void excluirProduto(int codigoBarras) {
        String sql = "DELETE FROM produtos WHERE codigoBarras = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, codigoBarras);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    
    // Select - Selecionar a descricao pelo codigo
    public String selecionarAtributoProduto(int codigoBarras ) {
    	String sql = "SELECT descricao FROM produtos WHERE codigoBarras = ?";
    	 Connection conexao = null;
         PreparedStatement pstm = null;
         ResultSet rset = null;
         
         String descricao = "";
         
         try {
             conexao = BancoDeDados.conectar();
             pstm = conexao.prepareStatement(sql);
             pstm.setInt(1, codigoBarras);
             rset = pstm.executeQuery();
             
             if(rset.next()) {
            	 descricao = rset.getString("descricao");
             }
         }catch (SQLException e) {
             e.printStackTrace();
         } finally {
         	BancoDeDados.desconectar(conexao);
         }
         
         return descricao;
    }
    
    // UPDATE - Atualizar quantidade
    public void atualizarQuatidade(int codigoBarras, int quantidade) {
        String sql = "UPDATE produtos SET quantidade = ? WHERE codigoBarras = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            
            pstm.setInt(1, quantidade);
            pstm.setInt(2, codigoBarras);
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}
