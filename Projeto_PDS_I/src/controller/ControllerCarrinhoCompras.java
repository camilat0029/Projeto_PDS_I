package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import view.TelaCarrinhoCompras;
import view.TelaCompras;

public class ControllerCarrinhoCompras extends ComponentAdapter {
	
	private TelaCarrinhoCompras carrinhoCompras;
	private TelaCompras compras;
	private NavegadorTelas navegadorTelas;
	
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
		
		
	}
	
	public void componentShown(ComponentEvent e) {
		this.valorTotal();
	}
	
	public void valorTotal() {
		
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		int totalLinhasTabela = carrinhoCompras.tabCarrinhoModelo.getRowCount();
		float total = 0;
		
		for (int i = 0; i < totalLinhasTabela; i++) {
			
			Object valorTabela = carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 1);
			Object quantTabela = carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 2);
			
			total = total + Float.parseFloat(valorTabela.toString().replace(",", ".")) * Float.parseFloat(quantTabela.toString().replace(",", "."));
			
		}
		
		carrinhoCompras.getLbValorTotal().setText("Valor Total = R$ " + String.format("%.2f", total));
	}
	
	

}
