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


		this.carrinhoCompras.aumentarQtd(e -> {
			aumentarQuantEm1();
			valorTotal();
		});

		this.carrinhoCompras.diminuirQtd(e -> {
			diminuirQuantEm1();
			valorTotal();
		});
		
		this.carrinhoCompras.removerProduto(e -> {
			removerProduto();
			valorTotal();
		});
		
		this.carrinhoCompras.concluirCompra(e -> {
			JOptionPane.showMessageDialog(null, "Compra Concluída", "Informação", 1);
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

			total = total + Float.parseFloat(valorTabela.toString().replace(",", "."))
					* Float.parseFloat(quantTabela.toString().replace(",", "."));

		}

		carrinhoCompras.getLbValorTotal().setText("Valor Total = R$ " + String.format("%.2f", total));
	}

	public void aumentarQuantEm1() {

		List<Produtos> produto = produtosDAO.listarProdutos();
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();

		linhaSelecionada = carrinhoCompras.tabelaCarrinho.getSelectedRow();
		totalLinhas = carrinhoCompras.tabelaCarrinho.getRowCount();

		if (linhaSelecionada >= 0) {

			int quantTabela = Integer
					.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 3).toString());
			int codigo = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 0).toString());

			for (int i = 0; i < totalLinhas; i++) {
				for (Produtos produtos : produto) {
					if (produtos.getCodigoBarras() == codigo) {
						if (produtos.getQuantidade() > quantTabela) {

							carrinhoCompras.tabelaCarrinho.setValueAt(quantTabela + 1, linhaSelecionada, 3);
							

						} else {
							JOptionPane.showMessageDialog(null,
									"Desculpe, mas já atingiu a quantidade \ntotal de nosso estoque deste produto!",
									"Informação", 1);
							
						}
						break;
					}
				}

			}
		} else {

			JOptionPane.showMessageDialog(null, "Selecione uma linha para adicionar", "Informação", 1);

		}
	}

	public void diminuirQuantEm1() {

		List<Produtos> produto = produtosDAO.listarProdutos();
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();

		linhaSelecionada = carrinhoCompras.tabelaCarrinho.getSelectedRow();
		totalLinhas = carrinhoCompras.tabelaCarrinho.getRowCount();

		if (linhaSelecionada >= 0) {

			int quantTabela = Integer
					.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 3).toString());
			int codigo = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 0).toString());

			for (Produtos produtos : produto) {
				if (produtos.getCodigoBarras() == codigo) {
					if (quantTabela > 0) {

						carrinhoCompras.tabelaCarrinho.setValueAt(quantTabela - 1, linhaSelecionada, 3);
						
						if ((quantTabela - 1) <= 0) {

							carrinhoCompras.tabCarrinhoModelo.removeRow(linhaSelecionada);
							JOptionPane.showMessageDialog(null, "Produto Removido!", "Informação", 1);
							
						}
						break;
					}  
				}
			}
		} else {

			JOptionPane.showMessageDialog(null, "Selecione uma linha para adicionar", "Informação", 1);

		}
	}
	
	public void removerProduto() {
		
		linhaSelecionada = carrinhoCompras.tabelaCarrinho.getSelectedRow();
		
		if(linhaSelecionada >= 0) {
			
			carrinhoCompras.tabCarrinhoModelo.removeRow(linhaSelecionada);
			JOptionPane.showMessageDialog(null, "Produto Removido!", "Informação", 1);
			
		}
		
		
	}
	
	public void concluirCompra() {
		
		totalLinhas = carrinhoCompras.tabelaCarrinho.getRowCount();
		
		List<Produtos> produto = produtosDAO.listarProdutos();
		Produtos produtoAtualizado = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		
		for (int i = 0; i < totalLinhas; i++) {
			
			for (Produtos produtos : produto) {
				
		
				
				produtosDAO.atualizarProdutos(produtoAtualizado);
				
			}
			
		}
		
		
	}
}
