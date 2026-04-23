package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import view.TelaCarrinhoCompras;
import view.TelaCompras;

public class ControllerCarrinhoCompras extends ComponentAdapter {
	
	private TelaCarrinhoCompras carrinhoCompras;
	private TelaCompras compras;
	private NavegadorTelas navegadorTelas;
	private ProdutosDAO produtosDAO = new ProdutosDAO();
	
	private int linhaSelecionada = -1;
	private int totalLinhas;
	
	
	public ControllerCarrinhoCompras(TelaCarrinhoCompras carrinhoCompras, TelaCompras compras,
			NavegadorTelas navegadorTelas) {
		super();
		this.carrinhoCompras = carrinhoCompras;
		this.compras = compras;
		this.navegadorTelas = navegadorTelas;
		
		this.carrinhoCompras.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				navegadorTelas.mudarTela("COMPRAS");
				
			}
		});
		
		this.carrinhoCompras.aumentarQtd(e -> {
			aumentarQuantEm1();
			valorTotal();
		});
		
		
	}
	
	
	public void componentShown(ComponentEvent e) {
		this.valorTotal();
	}
	
	public void valorTotal() {
		
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		int totalLinhasTabela = carrinhoCompras.tabCarrinhoModelo.getRowCount();
		float total = 0;
		
		for (int i = 0; i < totalLinhasTabela; i++) {
			
			Object valorTabela = carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 2);
			Object quantTabela = carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 3);
			
			total = total + Float.parseFloat(valorTabela.toString().replace(",", ".")) * Float.parseFloat(quantTabela.toString().replace(",", "."));
			
		}
		
		carrinhoCompras.getLbValorTotal().setText("Valor Total = R$ " + String.format("%.2f", total));
	}
	
	public void aumentarQuantEm1() {
		
		List<Produtos> produto = produtosDAO.listarProdutos(); 
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		
		linhaSelecionada = carrinhoCompras.tabelaCarrinho.getSelectedRow();
		totalLinhas = carrinhoCompras.tabelaCarrinho.getRowCount();
		
		if(linhaSelecionada >= 0) {
			
			int quantTabela = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 3).toString());
			int codigo = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 0).toString());
			
			for (int i = 0; i < totalLinhas; i++) {
				for (Produtos produtos : produto) {
					if(produtos.getCodigoBarras() == codigo) {
						if(produtos.getQuantidade() > quantTabela) {
							
							carrinhoCompras.tabelaCarrinho.setValueAt(quantTabela + 1, linhaSelecionada, 3);
							break;
							
						} else {
							JOptionPane.showMessageDialog(null, "Desculpe, mas já atingiu a quantidade \ntotal de nosso estoque deste produto!", 
									"Informação", 1);
							break;
						}
					}
				}
				
			}
		} else {
			
			JOptionPane.showMessageDialog(null, "Selecione uma linha para adicionar", "Informação", 1);
			
		}
	}
}
