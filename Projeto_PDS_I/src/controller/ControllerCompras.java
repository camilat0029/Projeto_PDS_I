package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import view.TelaCompras;

public class ControllerCompras extends ComponentAdapter{
	
	private TelaCompras telaCompras;
	private ProdutosDAO produtosDAO = new ProdutosDAO();
	private int contador = 0;
	List<Produtos> produtos = produtosDAO.listarProdutos();

	public ControllerCompras(TelaCompras telaCompras) {
		super();
		this.telaCompras = telaCompras;
		
		this.telaCompras.proximosProdutos(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Clique");
				
				if(contador + 3 < produtos.size()) {
					contador += 3;
					atualizarTela();
				}
				
				
			}
		});
		
		
	}
	
	public void atualizarTela(){
		
		Produtos[] produtosExibidos = new Produtos[3];
		
		for (int i = 0; i < 3; i++) {
			contador = i+1;
			
			if (contador<produtos.size()) {
				produtosExibidos[i] = produtos.get(contador);
			} else {
				produtosExibidos[i] = null;
			}
			
		}
		
		if(produtosExibidos[0] != null) {
			telaCompras.getLbNomeProduto().setText(produtosExibidos[0].getNome());
			telaCompras.getLbValor().setText(String.valueOf(produtosExibidos[0].getValor()));
		}
		
		if(produtosExibidos[1] != null) {
			telaCompras.getLbNomeProduto2().setText(produtosExibidos[1].getNome());
			telaCompras.getLbValor2().setText(String.valueOf(produtosExibidos[1].getValor()));
		}
		
		if(produtosExibidos[2] != null) {
			telaCompras.getLbNomeProduto3().setText(produtosExibidos[2].getNome());
			telaCompras.getLbValor3().setText(String.valueOf(produtosExibidos[2].getValor()));
		}

	}
	
	public void componentShown(ComponentEvent e) {
		this.primeirosProdutos();
	}
	
	public void primeirosProdutos() {
		telaCompras.getLbNomeProduto().setText(produtos.get(0).getNome());
		telaCompras.getLbValor().setText(String.valueOf(produtos.get(0).getValor()));
		
		telaCompras.getLbNomeProduto2().setText(produtos.get(1).getNome());
		telaCompras.getLbValor2().setText(String.valueOf(produtos.get(1).getValor()));
		
		telaCompras.getLbNomeProduto3().setText(produtos.get(2).getNome());
		telaCompras.getLbValor3().setText(String.valueOf(produtos.get(2).getValor()));
		
		
	}
	
	
	
	

}
