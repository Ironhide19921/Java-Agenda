package presentacion.vista;

import java.awt.BorderLayout;

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

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	// ORIGINAL --> private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCumple;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JButton btnAgregarLocalidad;
	private JButton btnEditarLocalidad;
	private JButton btnBorrarLocalidad;
	private static VentanaLocalidad INSTANCE;
	private JTable tablaLocalidades;
	private DefaultTableModel modelLocalidades;
	private String[] nombreColumnas = {"Localidad"};
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaLocalidad(); 	
			return new VentanaLocalidad();
		}
		else
			return INSTANCE;
	}

	private VentanaLocalidad() 
	{
		super();
		
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// ORIGINAL --> setBounds(100, 100, 543, 183);
		setBounds(100, 100, 450, 300);
		// ORIGINAL --> contentPane = new JPanel();
		// ORIGINAL --> contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// ORIGINAL --> setContentPane(contentPane);
		// ORIGINAL --> contentPane.setLayout(null);
		
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
        
        JLabel lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setBounds(30, 354, 61, 16);
        panel.add(lblLocalidad);
		
		
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
	
	public void mostrarVentana()
	{
		this.setVisible(true);
		this.setSize(440,499);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

//	public JTextField getTxtTelefono() 
//	{
//		return txtTelefono;
//	}
//	
//	public JTextField getTxtEmail() {
//		return txtEmail;
//	}
//
//	public JTextField getTxtCumple() {
//		return txtCumple;
//	}
//
//	public JTextField getTxtCalle() {
//		return txtCalle;
//	}
//
//	public JTextField getTxtAltura() {
//		return txtAltura;
//	}
//
//	public JTextField getTxtPiso() {
//		return txtPiso;
//	}
//
//	public JTextField getTxtDepto() {
//		return txtDepto;
//	}

	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}

	public void cerrar()
	{
		this.txtNombre.setText("");
//		this.txtTelefono.setText("");
//		this.txtEmail.setText("");
//		this.txtCumple.setText("");
//		this.txtCalle.setText("");
//		this.txtAltura.setText("");
//		this.txtPiso.setText("");
//		this.txtDepto.setText("");
		this.dispose();
	}
	
}

