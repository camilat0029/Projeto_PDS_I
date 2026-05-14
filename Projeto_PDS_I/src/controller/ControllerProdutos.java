package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.CadastroProdutos;
import view.Login;
import view.ProdutosCRUD;
import view.TelaPrincipal;
import view.TelaVisualizarProduto;

public class ControllerProdutos extends ComponentAdapter{
	
	private CadastroProdutos cadastroProdutos;
	private ProdutosDAO produtosDAO;
	//private Produtos produtos;
	private ProdutosCRUD produtosCRUD;
	private NavegadorTelas navegadorTelas;
	private TelaVisualizarProduto visualizarProd;
	private UsuarioDAO usuarioDAO;
	private TelaPrincipal tela = new TelaPrincipal();
	
	
	public ControllerProdutos(CadastroProdutos cadastroProdutos, ProdutosDAO produtosDAO,
			NavegadorTelas navegadorTelas, ProdutosCRUD produtosCRUD, TelaVisualizarProduto visualizarProd, 
			UsuarioDAO usuarioDAO) {
		super();
		this.cadastroProdutos = cadastroProdutos;
		this.produtosDAO = produtosDAO;
		//this.produtos = produtos;
		this.navegadorTelas = navegadorTelas;
		this.produtosCRUD = produtosCRUD;
		this.visualizarProd = visualizarProd;
		this.usuarioDAO = usuarioDAO;
		
		this.produtosCRUD.addComponentListener(this);
		
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
				
			} else if(cadastroProdutos.getBtCadastrar().getText().equals("Atualizar")){
				
				editarProduto();
			}
			
		});
		
		this.cadastroProdutos.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparCamposTelaCadProdutos();
				navegadorTelas.mudarTela("PRODUTOSCRUD");
			}
		});
		
		
		this.produtosCRUD.visualizarProduto(e -> {
			
			visualizarUmProduto();
			
		});
		
		this.visualizarProd.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				voltarVisualizarProd();
				
			}
		});
		
		this.produtosCRUD.deslogar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(tela, "Deseja Sair da Conta?", "Sair", JOptionPane.YES_NO_OPTION);
				
				if(confirm == JOptionPane.YES_OPTION) {
					System.out.println(ControllerLogin.usuarioLogado);
					ControllerLogin.usuarioLogado = null;
					System.out.println(ControllerLogin.usuarioLogado);
					navegadorTelas.mudarTela("LOGIN");
				}
				
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
			Object[] informacoes  = {produtos2.getCodigoBarras(), produtos2.getNome(),  String.format("%.2f", produtos2.getValor()), 
					produtos2.getMarca(), produtos2.getFornecedora(), produtos2.getQuantidade(),
					produtos2.getCor(), produtos2.getDataFabricacao(), produtos2.getDataValidade()};
			
			produtosCRUD.tabelaModelo.addRow(informacoes);
		}
		
		
	}
	
	public void visualizarUmProduto() {
		
		int linhaSelecionada = produtosCRUD.tabelaProdutos.getSelectedRow();
		
		if (linhaSelecionada >= 0) {
			
			visualizarProd.getLbConteudoCodBarras().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
			visualizarProd.getLbConteudoNome().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 1).toString());
			visualizarProd.getLbConteudoValor().setText("R$ " + produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 2).toString());
			visualizarProd.getLbConteudoMarca().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 3).toString());
			visualizarProd.getLbConteudoForn().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 4).toString());
			visualizarProd.getLbConteudoQtd().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 5).toString());
			visualizarProd.getLbConteudoCor().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 6).toString());
			visualizarProd.getLbConteudoDtFab().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 7).toString());
			visualizarProd.getLbConteudoDtVal().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 8).toString());
			
			visualizarProd.getTaConteudoDesc().setText(produtosDAO.selecionarAtributoProduto(Integer.parseInt
			(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 0).toString())));
			
			navegadorTelas.mudarTela("VISUALIZARPRODUTO");
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para Visualizar um Produto!", "Informação", 1);
		}
		
	}
	
	
	public void cadastrarProdutos() {
		
		Produtos produtos = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		produtosCRUD.tabelaModelo = (DefaultTableModel) produtosCRUD.tabelaProdutos.getModel();
		
		try {
			int codigoBarras = Integer.parseInt(cadastroProdutos.getTfCodBarras().getText());
			produtos.setCodigoBarras(codigoBarras);
			
			if (codigoBarras < 0) {
				throw new IllegalArgumentException();
			}
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números \npara o Código de Barras \nExemplo: 1,2,3...", "Informação", 1);
			return;
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "O código de barras não pode ser negativo!", "Informação", 1);
			return;
		}
		
		
		produtos.setNome(cadastroProdutos.getTfNomeProduto().getText());
		
		
		try {
			
			float valor = Float.parseFloat(cadastroProdutos.getTfValor().getText().replace(",", ".").trim());
			produtos.setValor(valor);
			
			if (valor < 0) {
				throw new IllegalArgumentException();
			}
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um Valor Válido \nExemplo: 10,50", "Informação", 1);
			return;
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Digite um valor positivo \nExemplo: 15,50", "Informação", 1);
			return;
		}
		
		produtos.setMarca(cadastroProdutos.getTfMarca().getText());
		produtos.setFornecedora(cadastroProdutos.getTfFornecedora().getText());
		
		try {
			int quantidade = Integer.parseInt(cadastroProdutos.getTfQuantEstoque().getText());
			produtos.setQuantidade(quantidade);
			
			if(quantidade < 0) {
				throw new IllegalArgumentException();
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números \nInteiros para a quantidade \nExemplo: 1,2,3...", "Informação", 1);
			return;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "A quantidade não pode ser negativa!", "Informação", 1);
			return;
		}
		
		produtos.setDescricao(cadastroProdutos.getTaDescricao().getText());
		produtos.setCor(cadastroProdutos.getTfCor().getText());
		
		String dataValidade = validarEConverterData(cadastroProdutos.getTfDataVal().getText());
		String dataFabricacao = validarEConverterData(cadastroProdutos.getTfDataFabr().getText());
		
		if(dataValidade == null && dataFabricacao == null) {
			JOptionPane.showMessageDialog(null, "Digite datas validas! \nExemplo: dd/mm/yyyy \nou yyyy-mm-dd", "Informação", 1);
			return;
		}
		
		produtos.setDataValidade(dataValidade);
		produtos.setDataFabricacao(dataFabricacao);
		
		produtosDAO.adicionarProdutos(produtos);
		
		Object[] informacoes  = {produtos.getCodigoBarras(), produtos.getNome(), String.format("%.2f", produtos.getValor()), 
				produtos.getMarca(), produtos.getFornecedora(), produtos.getQuantidade(),
				produtos.getCor(), produtos.getDataFabricacao(), produtos.getDataValidade()};
		
		produtosCRUD.tabelaModelo.addRow(informacoes);
		
		limparCamposTelaCadProdutos();
		navegadorTelas.mudarTela("PRODUTOSCRUD");
		System.out.println("CLIQUE");
		
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
			cadastroProdutos.getTfValor().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 2).toString().replace(",", "."));
			cadastroProdutos.getTfMarca().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 3).toString());
			cadastroProdutos.getTfFornecedora().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 4).toString());
			cadastroProdutos.getTfQuantEstoque().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 5).toString());
			cadastroProdutos.getTfCor().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 6).toString());
			cadastroProdutos.getTfDataFabr().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 7).toString());
			cadastroProdutos.getTfDataVal().setText(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 8).toString());
			
			cadastroProdutos.setTaDescricao2(produtosDAO.selecionarAtributoProduto(Integer.parseInt
					(produtosCRUD.tabelaProdutos.getValueAt(linhaSelecionada, 0).toString())));
			
			
			cadastroProdutos.getTfCodBarras().setEditable(false);
			cadastroProdutos.getTfCodBarras().setFocusable(false);
			
			navegadorTelas.mudarTela("CADASTROPRODUTOS");
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para Editar um Produto!", "Informação", 1);
		}
		
	}
	
	public void editarProduto() {
		
		Produtos produtoAtualizado = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		
		produtoAtualizado.setNome(cadastroProdutos.getTfNomeProduto().getText());
		
		try {
			
			float valor = Float.parseFloat(cadastroProdutos.getTfValor().getText().replace(",", ".").trim());
			produtoAtualizado.setValor(valor);
			
			if (valor < 0) {
				throw new IllegalArgumentException();
			}
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um Valor Válido \nExemplo: 10,50", "Informação", 1);
			return;
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Digite um valor positivo \nExemplo: 15,50", "Informação", 1);
			return;
		}
		
		produtoAtualizado.setMarca(cadastroProdutos.getTfMarca().getText());
		produtoAtualizado.setFornecedora(cadastroProdutos.getTfFornecedora().getText());
		
		try {
			int quantidade = Integer.parseInt(cadastroProdutos.getTfQuantEstoque().getText());
			produtoAtualizado.setQuantidade(quantidade);
			
			if(quantidade < 0) {
				throw new IllegalArgumentException();
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números \nInteiros para a quantidade \nExemplo: 1,2,3...", "Informação", 1);
			return;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "A quantidade não pode ser negativa!", "Informação", 1);
			return;
		}

		produtoAtualizado.setDescricao(cadastroProdutos.getTaDescricao().getText());
		produtoAtualizado.setCor(cadastroProdutos.getTfCor().getText());
		
		String dataValidade = validarEConverterData(cadastroProdutos.getTfDataVal().getText());
		String dataFabricacao = validarEConverterData(cadastroProdutos.getTfDataFabr().getText());
		
		if(dataValidade == null && dataFabricacao == null) {
			JOptionPane.showMessageDialog(null, "Digite datas validas! \nExemplo: dd/mm/yyyy \nou yyyy-mm-dd", "Informação", 1);
			return;
		}
		
		produtoAtualizado.setDataValidade(dataValidade);
		produtoAtualizado.setDataFabricacao(dataFabricacao);

		try {
			int codigoBarras = Integer.parseInt(cadastroProdutos.getTfCodBarras().getText());
			produtoAtualizado.setCodigoBarras(codigoBarras);
			
			if (codigoBarras < 0) {
				throw new IllegalArgumentException();
			}
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite Somente Números \npara o Código de Barras \nExemplo: 1,2,3...", "Informação", 1);
			return;
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "O código de barras não pode ser negativo!", "Informação", 1);
			return;
		}
		
		produtosDAO.atualizarProdutos(produtoAtualizado);
		
		limparCamposTelaCadProdutos();
		navegadorTelas.mudarTela("PRODUTOSCRUD");
		System.out.println("CLIQUE");
		
	}
	
	public void limparCamposTelaCadProdutos() {
		
		cadastroProdutos.getTfCodBarras().setText("");
		cadastroProdutos.getTfCor().setText("");
		cadastroProdutos.getTfDataFabr().setText("");
		cadastroProdutos.getTfDataVal().setText("");
		cadastroProdutos.getTfFornecedora().setText("");
		cadastroProdutos.getTfMarca().setText("");
		cadastroProdutos.getTfNomeProduto().setText("");
		cadastroProdutos.getTfQuantEstoque().setText("");
		cadastroProdutos.getTfValor().setText("");
		cadastroProdutos.getTaDescricao().setText("");
		
	}
	
	public String validarEConverterData(String dataTexto) {

	    try {

	        DateTimeFormatter formatoEntrada =
	                DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        LocalDate data =
	                LocalDate.parse(dataTexto, formatoEntrada);

	        DateTimeFormatter formatoBanco =
	                DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        return data.format(formatoBanco);

	    } catch (DateTimeParseException e) {

	        return null;
	    }
	}
	
	//ARRUMAR
	public void voltarVisualizarProd() {
		
		Usuario usuarioLogado = ControllerLogin.usuarioLogado;
		
		System.out.println("FUNÇÃO: " + usuarioLogado.getFuncao());
		
			
			if(usuarioLogado.getFuncao().equals("Administrador")){
				System.out.println("FUN: " + usuarioLogado.getFuncao());
				
				navegadorTelas.mudarTela("PRODUTOSCRUD");
				
			}
			
			if(usuarioLogado.getFuncao().equals("Cliente")) {
				System.out.println("ÇÃO: " + usuarioLogado.getFuncao());
				navegadorTelas.mudarTela("COMPRAS");
				
			}
	}
}
