package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import view.CadastroProdutos;
import view.ProdutosCRUD;

public class ControllerProdutos extends ComponentAdapter{
	
	private CadastroProdutos cadastroProdutos;
	private ProdutosDAO produtosDAO;
	//private Produtos produtos;
	private ProdutosCRUD produtosCRUD;
	private NavegadorTelas navegadorTelas;
	
	
	
	public ControllerProdutos(CadastroProdutos cadastroProdutos, ProdutosDAO produtosDAO,
			NavegadorTelas navegadorTelas, ProdutosCRUD produtosCRUD ) {
		super();
		this.cadastroProdutos = cadastroProdutos;
		this.produtosDAO = produtosDAO;
		//this.produtos = produtos;
		this.navegadorTelas = navegadorTelas;
		this.produtosCRUD = produtosCRUD;
		
		this.produtosCRUD.adicionarProdutos(e ->{
			navegadorTelas.mudarTela("CADASTROPRODUTOS");
			System.out.println("CLIQUE");
		});

		this.produtosCRUD.removerProduto(e -> {
			
			removerProduto();
			
		});
		
		this.produtosCRUD.editarProduto(e ->{
			
			cadastroProdutos.getBtCadastrar().setText("Atualizar");
			colocarInformacoesTelaCadastroProduto();
			
		});
		
		this.cadastroProdutos.cadastrarProdutos(e ->{
			
			if(cadastroProdutos.getBtCadastrar().getText().equals("Cadastrar")) {
				cadastrarProdutos();
				navegadorTelas.mudarTela("PRODUTOSCRUD");
				
				System.out.println("CLIQUE");
			} else if(cadastroProdutos.getBtCadastrar().getText().equals("Atualizar")){
				navegadorTelas.mudarTela("LOGIN");
			}
			
		});
		
	}
	
	public void componentShown(ComponentEvent e) {
		this.informacoesJaCadastradasTabela();;
	}
	
	public void informacoesJaCadastradasTabela() {

		
		List<Produtos> produtos = this.produtosDAO.listarProdutos();
		produtosCRUD.tabelaModelo = (DefaultTableModel) produtosCRUD.tabelaProdutos.getModel();
		
		produtosCRUD.tabelaModelo.setRowCount(0);
		
		for (Produtos produtos2 : produtos) {
			Object[] informacoes  = {produtos2.getCodigoBarras(), produtos2.getNome(), "R$ " + String.format("%.2f", produtos2.getValor()), 
					produtos2.getMarca(), produtos2.getFornecedora(), produtos2.getQuantidade(),
					produtos2.getCor(), produtos2.getDataFabricacao(), produtos2.getDataValidade()};
			
			produtosCRUD.tabelaModelo.addRow(informacoes);
		}
		
		
	}
	
	
	public void cadastrarProdutos() {
		
		Produtos produtos = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		produtosCRUD.tabelaModelo = (DefaultTableModel) produtosCRUD.tabelaProdutos.getModel();
		
		produtos.setCodigoBarras(Integer.parseInt(cadastroProdutos.getTfCodBarras().getText()));
		produtos.setNome(cadastroProdutos.getTfNomeProduto().getText());
		produtos.setValor(Float.parseFloat(cadastroProdutos.getTfValor().getText()));
		produtos.setMarca(cadastroProdutos.getTfMarca().getText());
		produtos.setFornecedora(cadastroProdutos.getTfFornecedora().getText());
		produtos.setQuantidade(Integer.parseInt(cadastroProdutos.getTfQuantEstoque().getText()));
		produtos.setDescricao(cadastroProdutos.getTaDescricao().getText());
		produtos.setCor(cadastroProdutos.getTfCor().getText());
		produtos.setDataValidade(cadastroProdutos.getTfDataVal().getText());
		produtos.setDataFabricacao(cadastroProdutos.getTfDataFabr().getText());
		
		produtosDAO.adicionarProdutos(produtos);
		
		Object[] informacoes  = {produtos.getCodigoBarras(), produtos.getNome(), String.format("%.2f", produtos.getValor()), 
				produtos.getMarca(), produtos.getFornecedora(), produtos.getQuantidade(),
				produtos.getCor(), produtos.getDataFabricacao(), produtos.getDataValidade()};
		
		produtosCRUD.tabelaModelo.addRow(informacoes);
		
	}
	
	public void removerProduto() {
		
		Produtos produtos = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		int linhaSelecionada = produtosCRUD.tabelaProdutos.getSelectedRow();
		
		if (linhaSelecionada >= 0) {
			
			int codigoProduto = Integer.parseInt(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
			
			produtosDAO.excluirProduto(codigoProduto);
			produtosCRUD.tabelaModelo.removeRow(linhaSelecionada);
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para Excluir um Produto!", "Informação", 1);
		}
		
	}
	
	public void colocarInformacoesTelaCadastroProduto() {
		
		int linhaSelecionada = produtosCRUD.tabelaProdutos.getSelectedRow();
		
		if(linhaSelecionada >= 0) {
			
			cadastroProdutos.getTfCodBarras().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
			cadastroProdutos.getTfNomeProduto().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 1).toString());
			cadastroProdutos.getTfValor().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 2).toString());
			cadastroProdutos.getTfMarca().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 3).toString());
			cadastroProdutos.getTfFornecedora().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 4).toString());
			cadastroProdutos.getTfQuantEstoque().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 5).toString());
			cadastroProdutos.getTfCor().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 6).toString());
			cadastroProdutos.getTfDataFabr().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 7).toString());
			cadastroProdutos.getTfDataVal().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 8).toString());
			
			cadastroProdutos.getTfCodBarras().setEditable(false);
			cadastroProdutos.getTfCodBarras().setFocusable(false);
			
			navegadorTelas.mudarTela("CADASTROPRODUTOS");
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para Editar um Produto!", "Informação", 1);
		}
		
	}
	
	
	
	
	
	//TESTAR
	public void editarProduto() {
		
		Produtos produtoAtualizado = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		
		produtoAtualizado.setNome(cadastroProdutos.getTfNomeProduto().getText());
		produtoAtualizado.setValor(Float.parseFloat(cadastroProdutos.getTfValor().getText()));
		produtoAtualizado.setMarca(cadastroProdutos.getTfMarca().getText());
		produtoAtualizado.setFornecedora(cadastroProdutos.getTfFornecedora().getText());
		produtoAtualizado.setQuantidade(Integer.parseInt(cadastroProdutos.getTfQuantEstoque().getText()));
		produtoAtualizado.setDescricao("");
		produtoAtualizado.setCor(cadastroProdutos.getTfCor().getText());
		produtoAtualizado.setDataValidade(cadastroProdutos.getTfDataVal().getText());
		produtoAtualizado.setDataFabricacao(cadastroProdutos.getTfDataFabr().getText());
		produtoAtualizado.setCodigoBarras(Integer.parseInt(cadastroProdutos.getTfCodBarras().getText()));
		
		produtosDAO.atualizarProdutos(produtoAtualizado);
		
	}
	
	

}
