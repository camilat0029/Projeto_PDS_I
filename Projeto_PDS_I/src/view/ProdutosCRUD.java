package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class ProdutosCRUD extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProdutosCRUD() {
		setBackground(new Color(208, 223, 251));
		
		setPreferredSize(new Dimension(900, 580));
		
		setMinimumSize(new Dimension(900, 580));
		setLayout(new MigLayout("", "[]", "[]"));

	}

}
