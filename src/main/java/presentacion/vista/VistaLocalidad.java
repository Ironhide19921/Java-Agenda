package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//ORIGINAL --> import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.LocalidadDTO;
import dto.PersonaDTO;

public class VistaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	// ORIGINAL --> private JPanel contentPane;
	private JTextField txtNombre;

	private JButton btnAgregarLocalidad;
	private JButton btnEditarLocalidad;
	private JButton btnBorrarLocalidad;
	private static VistaLocalidad INSTANCE;
	private JTable tablaLocalidades;
	private DefaultTableModel modelLocalidades;
	private String[] nombreColumnas = {"Nombre"};
	
	public static VistaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VistaLocalidad(); 	
			return new VistaLocalidad();
		}
		else
			return INSTANCE;
	}

	private VistaLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 262);
		// ORIGINAL --> contentPane.add(panel);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 400, 182);
		panel.add(spLocalidades);
		
		modelLocalidades = new DefaultTableModel(null,nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidades);
		
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
		
		spLocalidades.setViewportView(tablaLocalidades);   
		
		
		btnAgregarLocalidad = new JButton("Agregar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnAgregarLocalidad.setBounds(10, 228, 83, 23);
		panel.add(btnAgregarLocalidad);
		
		btnEditarLocalidad = new JButton("Editar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnEditarLocalidad.setBounds(109, 228, 89, 23);
		panel.add(btnEditarLocalidad);
		
		btnBorrarLocalidad = new JButton("Borrar");
		// ORIGINAL --> btnAgregarPersona.setBounds(208, 92, 89, 23);
		btnBorrarLocalidad.setBounds(208, 228, 89, 23);
		panel.add(btnBorrarLocalidad);
		
		
		
		this.setVisible(false);
	}
	


	public JTable getTablaLocalidades() {
		return tablaLocalidades;
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
	
	public DefaultTableModel getModelLocalidades() 
	{
		return modelLocalidades;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}
	
	public JButton getBtnBorrarLocalidad() {
		return btnBorrarLocalidad;
	}
	
	public void llenarTabla(List<LocalidadDTO> localidadesEnTabla) {
		this.getModelLocalidades().setRowCount(0); //Para vaciar la tabla
		this.getModelLocalidades().setColumnCount(0);
		this.getModelLocalidades().setColumnIdentifiers(this.getNombreColumnas());

		for (LocalidadDTO p : localidadesEnTabla)
		{
			String nombre = p.getNombre();
			//String tel = p.getTelefono();
			Object[] fila = {nombre};
			this.getModelLocalidades().addRow(fila);
		}
		
	}

	public void cerrar()
	{
		this.txtNombre.setText("");
		this.dispose();
	}
	
}

