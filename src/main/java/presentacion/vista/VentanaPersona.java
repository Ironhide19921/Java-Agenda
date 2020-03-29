package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dto.LocalidadDTO;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCumple;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDepto;
	private JComboBox comboBoxLocalidad;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
//	private List<LocalidadDTO> localidades;
//	private static Localidad localidad;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
//		this.localidad = localidad;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(30, 41, 119, 16);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(30, 79, 61, 16);
		panel.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 123, 61, 16);
        panel.add(lblEmail);
        
        JLabel lblCumple = new JLabel("Fecha de cumpleaños");
        lblCumple.setBounds(30, 164, 141, 16);
        panel.add(lblCumple);
        
        JLabel lblCalle = new JLabel("Calle");
        lblCalle.setBounds(30, 202, 61, 16);
        panel.add(lblCalle);
        
        JLabel lblAltura = new JLabel("Altura");
        lblAltura.setBounds(30, 239, 61, 16);
        panel.add(lblAltura);
        
        JLabel lblPiso = new JLabel("Piso");
        lblPiso.setBounds(30, 279, 61, 16);
        panel.add(lblPiso);
        
        JLabel lblDepto = new JLabel("Depto");
        lblDepto.setBounds(30, 316, 61, 16);
        panel.add(lblDepto);
        
        JLabel lblLocalidad = new JLabel("Localidad");
        lblLocalidad.setBounds(30, 354, 61, 16);
        panel.add(lblLocalidad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(188, 36, 130, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(188, 74, 130, 26);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
        txtEmail.setBounds(188, 118, 130, 26);
        panel.add(txtEmail);
        txtEmail.setColumns(10);
        
        txtCumple = new JTextField();
        txtCumple.setBounds(188, 156, 130, 26);
        panel.add(txtCumple);
        txtCumple.setColumns(10);
        
        txtCalle = new JTextField();
        txtCalle.setBounds(188, 197, 130, 26);
        panel.add(txtCalle);
        txtCalle.setColumns(10);
        
        txtAltura = new JTextField();
        txtAltura.setBounds(188, 235, 130, 26);
        panel.add(txtAltura);
        txtAltura.setColumns(10);
        
        txtPiso = new JTextField();
        txtPiso.setBounds(188, 273, 130, 26);
        panel.add(txtPiso);
        txtPiso.setColumns(10);
        
        txtDepto = new JTextField();
        txtDepto.setBounds(188, 311, 130, 26);
        panel.add(txtDepto);
        txtDepto.setColumns(10);
        
//        JComboBox<LocalidadDTO> comboBoxLocalidad = new JComboBox<LocalidadDTO>();
        comboBoxLocalidad = new JComboBox<String>();
        comboBoxLocalidad.setBounds(188, 350, 130, 27);
//        List<LocalidadDTO> valores = rellenarListaLocalidades();
        
        
//        comboBoxLocalidad.addItem("Uno");
//        comboBoxLocalidad.addItem("Dos");
//        comboBoxLocalidad.addItem("Tres");
        panel.add(comboBoxLocalidad);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(317, 442, 117, 29);
		panel.add(btnAgregarPersona);
		
		this.setVisible(false);
	}

	@SuppressWarnings("unchecked")
	public void rellenarListaLocalidades(List<LocalidadDTO> localidades) {
		
		for (LocalidadDTO valor : localidades)
        {
        	this.comboBoxLocalidad.addItem(valor.getNombre());
        }
	}
	
//	private List<LocalidadDTO> rellenarListaLocalidades()
//	{
//		String consulta = "select * from localidades";
//		return null;
////		return this.localidad.obtenerLocalidades();
//	}
	
	public JComboBox getComboBoxLocalidad() {
		return comboBoxLocalidad;
	}

	public void setComboBoxLocalidad(JComboBox comboBoxLocalidad) {
		this.comboBoxLocalidad = comboBoxLocalidad;
	}

//	public void setLocalidades(List<LocalidadDTO> localidades) {
//		this.localidades = localidades;
//	}

	public void mostrarVentana()
	{
		this.setVisible(true);
		this.setSize(440,499);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtCumple() {
		return txtCumple;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JTextField getTxtDepto() {
		return txtDepto;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText("");
		this.txtTelefono.setText("");
		this.txtEmail.setText("");
		this.txtCumple.setText("");
		this.txtCalle.setText("");
		this.txtAltura.setText("");
		this.txtPiso.setText("");
		this.txtDepto.setText("");
		this.dispose();
	}
	
	
}

