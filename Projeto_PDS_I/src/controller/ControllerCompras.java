package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import view.TelaCarrinhoCompras;
import view.TelaCompras;
import view.TelaVisualizarProduto;

public class ControllerCompras extends ComponentAdapter{
	
	private TelaCompras telaCompras;
	private ProdutosDAO produtosDAO = new ProdutosDAO();
	private NavegadorTelas navegadorTelas;
	private TelaVisualizarProduto visualizarProduto;
	private TelaCarrinhoCompras carrinhoCompras;
	
	private int contador = 0, produtosPagina = 3, codigoBarrasPanel, codigoBarrasPanel2, codigoBarrasPanel3;
	private List<Produtos> produtos;
	
	public ControllerCompras(TelaCompras telaCompras, NavegadorTelas navegadorTelas, 
			TelaVisualizarProduto visualizarProduto, TelaCarrinhoCompras carrinhoCompras) {
		super();
		this.telaCompras = telaCompras;
		this.navegadorTelas = navegadorTelas;
		this.visualizarProduto = visualizarProduto;
		this.carrinhoCompras = carrinhoCompras;
		
		produtos = produtosDAO.listarProdutos();
		
		this.telaCompras.proximosProdutos(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Clique");
				atualizarProdutosTelaProximo();
				
			}
		});
		
		this.telaCompras.voltarProdutos(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Clique");
				atualizarProdutosTelaVoltar();
				
			}
		});
		
		this.telaCompras.carrinhoCompras(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				navegadorTelas.mudarTela("CARRINHOCOMPRAS");
				
			}
		});
		
		this.telaCompras.saibaMais(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saibaMais(codigoBarrasPanel);
				System.out.println("CLIQUE");
			}
		});
		
		this.telaCompras.saibaMais2(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saibaMais(codigoBarrasPanel2);
				System.out.println("CLIQUE");
			}
		});
		
		this.telaCompras.saibaMais3(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saibaMais(codigoBarrasPanel3);
				System.out.println("CLIQUE");
			}
		});
		
		this.telaCompras.addCarrinho(e -> {
			
			adicionarCarrinho(codigoBarrasPanel);
		
		});
		
		this.telaCompras.addCarrinho2(e -> {
			
			adicionarCarrinho(codigoBarrasPanel2);
			
		});
		
		this.telaCompras.addCarrinho3(e -> {
			
			adicionarCarrinho(codigoBarrasPanel3);
			
		});
	
	}
	
	//Arrumar caso a quantidade chegue a zero
	public void atualizarTela(){
		
		Produtos[] produtosExibidos = new Produtos[3];
		
		for (int i = 0; i < 3; i++) {
			
			int indice = contador + i;
			
			if (indice < produtos.size()) {
				produtosExibidos[i] = produtos.get(indice);
			} else {
				produtosExibidos[i] = null;
			}
			
		}
		
		
		
		if(produtosExibidos[0] != null) {
			telaCompras.getLbNomeProduto().setText(produtosExibidos[0].getNome());
			telaCompras.getLbValor().setText(String.valueOf("R$ " + String.format("%.2f", produtosExibidos[0].getValor())));
			telaCompras.getLbSaibaMais().setText("Saiba Mais");
			telaCompras.getLbValor().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho().setText("Adicionar ao Carrinho");
			telaCompras.getBtAddCarrinho().setBackground(new Color(188, 199, 243));
			telaCompras.getBtAddCarrinho().setEnabled(true);
			telaCompras.getLbSaibaMais().setEnabled(true);
			
			codigoBarrasPanel = produtosExibidos[0].getCodigoBarras();
			
		}else {
			telaCompras.getLbNomeProduto().setText("");
			telaCompras.getLbValor().setText("Esgotado");
			telaCompras.getLbSaibaMais().setText("");
			telaCompras.getLbValor().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho().setText("");
			telaCompras.getBtAddCarrinho().setBackground(new Color(0,0,0,0));
			telaCompras.getBtAddCarrinho().setEnabled(false);
			telaCompras.getLbSaibaMais().setEnabled(false);
			
		}
		
		
		if(produtosExibidos[1] != null) {
			telaCompras.getLbNomeProduto2().setText(produtosExibidos[1].getNome());
			telaCompras.getLbValor2().setText(String.valueOf("R$ " + String.format("%.2f", produtosExibidos[1].getValor())));
			telaCompras.getLbSaibaMais2().setText("Saiba Mais");
			telaCompras.getLbValor2().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho2().setText("Adicionar ao Carrinho");
			telaCompras.getBtAddCarrinho2().setBackground(new Color(188, 199, 243));
			telaCompras.getBtAddCarrinho2().setEnabled(true);
			telaCompras.getLbSaibaMais2().setEnabled(true);
			
			codigoBarrasPanel2 = produtosExibidos[1].getCodigoBarras();
			
		}else {
			telaCompras.getLbNomeProduto2().setText("");
			telaCompras.getLbValor2().setText("Esgotado");
			telaCompras.getLbSaibaMais2().setText("");
			telaCompras.getLbValor2().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho2().setText("");
			telaCompras.getBtAddCarrinho2().setBackground(new Color(0,0,0,0));
			telaCompras.getBtAddCarrinho2().setEnabled(false);
			telaCompras.getLbSaibaMais2().setEnabled(false);
			
		}
		
		if(produtosExibidos[2] != null) {
			telaCompras.getLbNomeProduto3().setText(produtosExibidos[2].getNome());
			telaCompras.getLbValor3().setText(String.valueOf("R$ " + String.format("%.2f", produtosExibidos[2].getValor())));
			telaCompras.getLbSaibaMais3().setText("Saiba Mais");
			telaCompras.getLbValor3().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho3().setText("Adicionar ao Carrinho");
			telaCompras.getBtAddCarrinho3().setBackground(new Color(188, 199, 243));
			telaCompras.getBtAddCarrinho3().setEnabled(true);
			telaCompras.getLbSaibaMais3().setEnabled(true);
			
			codigoBarrasPanel3 = produtosExibidos[2].getCodigoBarras();
			
		} else {
			telaCompras.getLbNomeProduto3().setText("");
			telaCompras.getLbValor3().setText("Esgotado");
			telaCompras.getLbSaibaMais3().setText("");
			telaCompras.getLbValor3().setFont(new Font("Georgia", Font.PLAIN, 20));
			telaCompras.getBtAddCarrinho3().setText("");
			telaCompras.getBtAddCarrinho3().setBackground(new Color(0,0,0,0));
			telaCompras.getBtAddCarrinho3().setEnabled(false);
			telaCompras.getLbSaibaMais3().setEnabled(false);
			
		}

	}
	
	public void atualizarProdutosTelaProximo() {
		if(contador + produtosPagina < produtos.size()) {
			contador+=produtosPagina;
			atualizarTela();
		}
	}
	
	public void atualizarProdutosTelaVoltar() {
		if(contador - produtosPagina >= 0) {
			contador-=produtosPagina;
			atualizarTela();
		}
	}
	
	public void componentShown(ComponentEvent e) {
		produtos = produtosDAO.listarProdutos();
		contador = 0;
		 atualizarTela();
	}
	
	public void saibaMais(int codigoBarras) {
		
		Produtos produtoPanel = null;
		
		for (Produtos produto : produtos) {
			
			if(produto.getCodigoBarras() == codigoBarras) {
				
				
				produtoPanel = produto;
				
				break;
				
			}
		}

		if(produtoPanel == null) {
			System.out.println("Produto não encontrado");
			return;
		}
		
		navegadorTelas.mudarTela("VISUALIZARPRODUTO");
		
		visualizarProduto.getLbConteudoCodBarras().setText(String.valueOf(produtoPanel.getCodigoBarras()));
		visualizarProduto.getLbConteudoNome().setText(produtoPanel.getNome());
		visualizarProduto.getLbConteudoValor().setText(String.valueOf(produtoPanel.getValor()));
		visualizarProduto.getLbConteudoMarca().setText(produtoPanel.getMarca());
		visualizarProduto.getLbConteudoForn().setText(produtoPanel.getFornecedora());
		visualizarProduto.getLbConteudoQtd().setText(String.valueOf(produtoPanel.getQuantidade()));
		visualizarProduto.getLbConteudoCor().setText(produtoPanel.getCor());
		visualizarProduto.getLbConteudoDtFab().setText(produtoPanel.getDataFabricacao());
		visualizarProduto.getLbConteudoDtVal().setText(produtoPanel.getDataValidade());
		visualizarProduto.getTaConteudoDesc().setText(produtoPanel.getDescricao());
	
	}
	
	public void adicionarCarrinho(int codigoBarras) {
		
		Produtos produtoPanel = null;
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		boolean produtoJaAdd = false;
		
		int totalLinhastabela = carrinhoCompras.tabCarrinhoModelo.getRowCount();
		
		for (Produtos produto : produtos) {
			
			if(produto.getCodigoBarras() == codigoBarras) {
				
				produtoPanel = produto;
				break;
			}
			
		}
		
		if (produtoPanel == null) {
			System.out.println("Produto não encontrado");
			return;
		}
		
		
		for (int i = 0; i < totalLinhastabela; i++) {
			
			Object codigoTabela = carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 0);
			
			if (codigoTabela != null && codigoTabela.equals(produtoPanel.getCodigoBarras())) {
				
				
				int quantAtual = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 3).toString());
				
				if(quantAtual < produtoPanel.getQuantidade()) {
					
					carrinhoCompras.tabCarrinhoModelo.setValueAt(quantAtual + 1, i, 3);
					JOptionPane.showMessageDialog(null, "Produto Adicionado ao Carrinho com Sucesso!", "Informação", 1);
					
				}  else {
					JOptionPane.showMessageDialog(null, "Desculpe, mas já atingiu a quantidade \ntotal de nosso estoque deste produto!", 
							"Informação", 1);
					
					carrinhoCompras.tabCarrinhoModelo.setValueAt(quantAtual, i, 2);
				}
				
				produtoJaAdd = true; 
				break;
			} 
			
			
			
		}
		
		if(produtoJaAdd == false) {
			Object[] informacoes  = {produtoPanel.getCodigoBarras(), produtoPanel.getNome(),  String.format("%.2f", produtoPanel.getValor()), 1};
			
			JOptionPane.showMessageDialog(null, "Produto Adicionado ao Carrinho com Sucesso!", "Informação", 1);
			carrinhoCompras.tabCarrinhoModelo.addRow(informacoes);
		}
		
	}
	
}
