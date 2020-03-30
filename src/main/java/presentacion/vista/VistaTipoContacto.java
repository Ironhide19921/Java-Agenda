package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//ORIGINAL --> import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dto.TipoContactoDTO;

public class VistaTipoContacto extends JFrame 
{
	private static final long serialVersionUID = 1L;
	// ORIGINAL --> private JPanel contentPane;
	private JTextField txtNombre;

	private JButton btnAgregarTipoContacto;
	private JButton btnEditarTipoContacto;
	private JButton btnBorrarTipoContacto;
	private static VistaTipoContacto INSTANCE;
	private JTable tablaTiposContacto;
	private DefaultTableModel modelTiposContacto;
	private String[] nombreColumnas = {"Nombre"};
	
	public static VistaTipoContacto getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VistaTipoContacto(); 	
			return new VistaTipoContacto();
		}
		else
			return INSTANCE;
	}

	private VistaTipoContacto() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 262);
		// ORIGINAL --> contentPane.add(panel);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane spTiposContacto = new JScrollPane();
		spTiposContacto.setBounds(10, 11, 400, 182);
		panel.add(spTiposContacto);
		
		modelTiposContacto = new DefaultTableModel(null,nombreColumnas);
		tablaTiposContacto = new JTable(modelTiposContacto);
		
		tablaTiposContacto.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaTiposContacto.getColumnModel().getColumn(0).setResizable(false);
		
		spTiposContacto.setViewportView(tablaTiposContacto);   
		
		
		btnAgregarTipoContacto = new JButton("Agregar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnAgregarTipoContacto.setBounds(10, 228, 83, 23);
		panel.add(btnAgregarTipoContacto);
		
		btnEditarTipoContacto = new JButton("Editar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnEditarTipoContacto.setBounds(109, 228, 89, 23);
		panel.add(btnEditarTipoContacto);
		
		btnBorrarTipoContacto = new JButton("Borrar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnBorrarTipoContacto.setBounds(208, 228, 89, 23);
		panel.add(btnBorrarTipoContacto);
		
		
		
		this.setVisible(false);
	}
	


	public JTable getTablaTiposContacto() {
		return tablaTiposContacto;
	}

	public void mostrarVentana()
	{
		this.setVisible(true);
		this.setSize(440,499);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}
	
	public DefaultTableModel getModelTiposContacto() 
	{
		return modelTiposContacto;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	public JButton getBtnAgregarTipoContacto() 
	{
		return btnAgregarTipoContacto;
	}
	
	public JButton getBtnBorrarTipoContacto() {
		return btnBorrarTipoContacto;
	}
	
	public void llenarTabla(List<TipoContactoDTO> tiposContactoEnTabla) {
		this.getModelTiposContacto().setRowCount(0); //Para vaciar la tabla
		this.getModelTiposContacto().setColumnCount(0);
		this.getModelTiposContacto().setColumnIdentifiers(this.getNombreColumnas());

		for (TipoContactoDTO p : tiposContactoEnTabla)
		{
			String nombre = p.getNombre();
			//String tel = p.getTelefono();
			Object[] fila = {nombre};
			this.getModelTiposContacto().addRow(fila);
		}
		
	}

	public void cerrar()
	{
		this.txtNombre.setText("");
		this.dispose();
	}
	
}

