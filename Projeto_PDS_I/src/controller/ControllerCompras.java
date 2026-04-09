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

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import view.TelaCompras;

public class ControllerCompras extends ComponentAdapter{
	
	private TelaCompras telaCompras;
	private ProdutosDAO produtosDAO = new ProdutosDAO();
	private NavegadorTelas navegadorTelas;
	private int contador = 0;
	private int produtosPagina = 3;
	private List<Produtos> produtos;
	

	public ControllerCompras(TelaCompras telaCompras, NavegadorTelas navegadorTelas) {
		super();
		this.telaCompras = telaCompras;
		this.navegadorTelas = navegadorTelas;
		
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
		
		
	}
	
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
		contador = 0;
		this.primeirosProdutos();
	}

	public void primeirosProdutos() {
		telaCompras.getLbNomeProduto().setText(produtos.get(0).getNome());
		telaCompras.getLbValor().setText(String.valueOf("R$ " + String.format("%.2f", produtos.get(0).getValor())));
		
		telaCompras.getLbNomeProduto2().setText(produtos.get(1).getNome());
		telaCompras.getLbValor2().setText(String.valueOf("R$ " + String.format("%.2f", produtos.get(1).getValor())));
		
		telaCompras.getLbNomeProduto3().setText(produtos.get(2).getNome());
		telaCompras.getLbValor3().setText(String.valueOf("R$ " + String.format("%.2f", produtos.get(2).getValor())));
	}
	
	
	
	

}
