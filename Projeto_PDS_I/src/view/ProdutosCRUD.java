package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ProdutosCRUD extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btAdicionar, btEditar, btRemover;
	private JButton btVisualizar;
	
	private JScrollPane scrollPane;
	public JTable tabelaProdutos;

	public DefaultTableModel tabelaModelo;
	private JLabel lbDeslogar;
	

	/**
	 * Create the panel.
	 */
	public ProdutosCRUD() {
		
		setBackground(new Color(208, 223, 251));
		setPreferredSize(new Dimension(1020, 640));
		setMinimumSize(new Dimension(1020, 640));
		
		setLayout(new MigLayout("gap 30", "[][grow][223][223][][grow]", "[70][][][][][166.00][grow]"));
		
		lbDeslogar = new JLabel("Deslogar");
		lbDeslogar.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(lbDeslogar, "cell 4 0,alignx right");
		
		JLabel lbProdutos = new JLabel("Estoque de Produtos");
		lbProdutos.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		add(lbProdutos, "cell 1 2 4 1,alignx center");
		
		btVisualizar = new JButton("Visualizar Produto");
		btVisualizar.setBackground(new Color(188, 199, 247));
		btVisualizar.setFont(new Font("Georgia", Font.PLAIN, 20));
		add(btVisualizar, "cell 1 3,growx");
		btVisualizar.setBorderPainted(false);
		
		btAdicionar = new JButton("Adicionar Produto");
		btAdicionar.setFont(new Font("Georgia", Font.PLAIN, 20));
		btAdicionar.setBackground(new Color(188, 199, 243));
		add(btAdicionar, "cell 2 3,growx");
		
		btAdicionar.setBorderPainted(false);
		
		btEditar = new JButton("Editar Produto");
		btEditar.setBackground(new Color(188, 199, 243));
		btEditar.setFont(new Font("Georgia", Font.PLAIN, 22));
		add(btEditar, "cell 3 3,growx");
		btEditar.setBorderPainted(false);
		
		btRemover = new JButton("Remover Produto");
		btRemover.setFont(new Font("Georgia", Font.PLAIN, 22));
		btRemover.setBackground(new Color(188, 199, 243));
		add(btRemover, "cell 4 3,growx");
		btRemover.setBorderPainted(false);
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 4 4 2,grow");
		
		tabelaProdutos = new JTable();
		tabelaProdutos.setBackground(new Color(255, 255, 255));
		tabelaProdutos.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 12));
		tabelaProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"Código", "Nome", "Valor(R$)", "Marca", "Fornecedora", "Quantidade", "Cor", "Data-Fab", "Data-Val"}
			) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
	});
		scrollPane.setViewportView(tabelaProdutos);
		

	}
	
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}

	public void deslogar(MouseListener mouseListener) {
		this.lbDeslogar.addMouseListener(mouseListener);
	}
	
	public void adicionarProdutos(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}
	
	public void editarProduto(ActionListener actionListener) {
		this.btEditar.addActionListener(actionListener);
	}
	
	public void removerProduto(ActionListener actionListener) {
		this.btRemover.addActionListener(actionListener);
	}
	
	public void visualizarProduto(ActionListener actionListener) {
		this.btVisualizar.addActionListener(actionListener);
	}

}
