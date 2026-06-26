package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import view.TelaCarrinhoCompras;
import view.TelaCompras;
import view.TelaConcluirCompra;
import view.TelaNotaFiscal;

public class ControllerCarrinhoCompras extends ComponentAdapter {

	private TelaCarrinhoCompras carrinhoCompras;
	private TelaCompras compras;
	private TelaConcluirCompra telaConcluirCompra;
	private TelaNotaFiscal telaNotaFiscal;
	private NavegadorTelas navegadorTelas;
	private ProdutosDAO produtosDAO = new ProdutosDAO();

	private int linhaSelecionada = -1;
	private int totalLinhas;

	public ControllerCarrinhoCompras(TelaCarrinhoCompras carrinhoCompras, TelaCompras compras,
			NavegadorTelas navegadorTelas, TelaConcluirCompra telaConcluirCompra, TelaNotaFiscal telaNotaFiscal) {
		super();
		this.carrinhoCompras = carrinhoCompras;
		this.compras = compras;
		this.navegadorTelas = navegadorTelas;
		this.telaConcluirCompra = telaConcluirCompra;
		this.telaNotaFiscal = telaNotaFiscal;

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

		this.carrinhoCompras.diminuirQtd(e -> {
			diminuirQuantEm1();
			valorTotal();
		});
		
		this.carrinhoCompras.removerProduto(e -> {
			removerProduto();
			valorTotal();
		});
		
		this.carrinhoCompras.concluirCompra(e -> {
			concluirCompra();
		});
		
		this.telaConcluirCompra.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegadorTelas.mudarTela("CARRINHOCOMPRAS");
			}
		});
		
		this.telaConcluirCompra.emitirNotaFiscal(e -> {
			emitirNotaFiscal();
		});
		
		this.telaNotaFiscal.voltar(new MouseAdapter() {
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
		
		boolean quantInsuficiente = false;

		if (linhaSelecionada >= 0) {

			int quantTabela = Integer
					.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 3).toString());
			int codigo = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(linhaSelecionada, 0).toString());

			for (int i = 0; i < totalLinhas; i++) {
				for (Produtos produtos : produto) {
					if (produtos.getCodigoBarras() == codigo) {
						if (produtos.getQuantidade() > quantTabela) {

							carrinhoCompras.tabelaCarrinho.setValueAt(quantTabela + 1, linhaSelecionada, 3);
							break;

						} else {
							quantInsuficiente = true;
						}
					}
				}
				if(quantInsuficiente == true) {
					JOptionPane.showMessageDialog(null,
							"Desculpe, mas já atingiu a quantidade \ntotal de nosso estoque deste produto!",
							"Informação", 1);
					return;
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
		
		Usuario usuarioLogado = ControllerLogin.usuarioLogado;
		
		
		telaConcluirCompra.getLbConteudoNome().setText(usuarioLogado.getNome());
		telaConcluirCompra.getLbConteudoCPF().setText(usuarioLogado.getCpf());
		telaConcluirCompra.getLbConteudoTotalPag().setText(carrinhoCompras.getLbValorTotal().getText());
		
		navegadorTelas.mudarTela("CONCLUIRCOMPRA");
		
		
	}
	
	public void emitirNotaFiscal() {
		
		
		List<Produtos> produto = produtosDAO.listarProdutos();
		Produtos produtoAtualizado = new Produtos(0, null, 0, null, null, 0, null, null, null, null);
		
		totalLinhas = carrinhoCompras.tabelaCarrinho.getRowCount();
		carrinhoCompras.tabCarrinhoModelo = (DefaultTableModel) carrinhoCompras.tabelaCarrinho.getModel();
		int novaQuant = 0;
		
		String radioButtonSelecionado = "";
		
		if(telaConcluirCompra.getRbCartaoCre().isSelected() == false &&  
				telaConcluirCompra.getRbCartaoDeb().isSelected() == false &&
				telaConcluirCompra.getRbPix().isSelected() == false) {
			
			JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento!", "Informação", 1);
			
		} else {
			if(telaConcluirCompra.getRbCartaoCre().isSelected()) {
				radioButtonSelecionado = telaConcluirCompra.getRbCartaoCre().getText();
			} else if (telaConcluirCompra.getRbCartaoDeb().isSelected()) {
				radioButtonSelecionado = telaConcluirCompra.getRbCartaoDeb().getText();
			} else if (telaConcluirCompra.getRbPix().isSelected()) {
				radioButtonSelecionado = telaConcluirCompra.getRbPix().getText();
			}
			
			
			
			Usuario usuarioLogado = ControllerLogin.usuarioLogado;
			
			telaNotaFiscal.getLbConteudoNome().setText(usuarioLogado.getNome());
			telaNotaFiscal.getLbConteudoCPF().setText(usuarioLogado.getCpf());
			telaNotaFiscal.getLbConteudoFormPag().setText(radioButtonSelecionado);
			telaNotaFiscal.getLbConteudoTotalPago().setText(carrinhoCompras.getLbValorTotal().getText());
			
			
			for (int i = 0; i < totalLinhas; i++) {
				
				int codigo = Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 0).toString());
				
				for (Produtos produtos : produto) {
					
					if(produtos.getCodigoBarras() == codigo) {
						
						telaNotaFiscal.getTaProdutos().append("Código de Barras: " + produtos.getCodigoBarras() + "\nProduto: " + produtos.getNome() +
								"\nValor: R$ " + produtos.getValor() + "\nQuantidade Adquirida:" + carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 3) + 
								"\nMarca: " + produtos.getMarca() + "\nFornecedora: " + produtos.getFornecedora() + "\nCor: " + produtos.getCor() + 
								"\nData de Fabricação: " + formatarData(produtos.getDataFabricacao()) + "\nData de Validade: " + formatarData(produtos.getDataValidade())+ 
								"\nDescrição: " + produtos.getDescricao() + "\n\n");
						
						novaQuant = produtos.getQuantidade() - Integer.parseInt(carrinhoCompras.tabCarrinhoModelo.getValueAt(i, 3).toString()) ;
						
						produtosDAO.atualizarQuatidade(codigo, novaQuant);
					}
				}
			}
			
			navegadorTelas.mudarTela("NOTAFISCAL");
		}
	}
	
	public String formatarData(String dataBanco) {

	    if (dataBanco == null || dataBanco.isBlank()) {
	        return "";
	    }

	    LocalDate data = LocalDate.parse(dataBanco);

	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    return data.format(formato);
	}
}
