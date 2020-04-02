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
import dto.TipoContactoDTO;

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
	private JComboBox<String> comboBoxLocalidad;
	private JComboBox<String> comboBoxTipoContacto;
	private JTextField txtCodPostal;
	private JTextField txtEquipoPref;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;

	
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 40, 490, 650);
		
		JPanel panel = new JPanel();
//		panel.setBounds(100, 100, 490, 450);
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
        
        JLabel lblTipoContacto = new JLabel("TipoContacto");
        lblTipoContacto.setBounds(30, 400, 75, 16);
        panel.add(lblTipoContacto);
        
        JLabel lblCodigoPostal = new JLabel("Codigo Postal");
        lblCodigoPostal.setBounds(30, 450, 80, 16);
        panel.add(lblCodigoPostal);
		
        JLabel lblEquipoPref = new JLabel("Equipo Preferido");
        lblEquipoPref.setBounds(30, 500, 95, 16);
        panel.add(lblEquipoPref);
        
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
        
        comboBoxLocalidad = new JComboBox<String>();
        comboBoxLocalidad.setBounds(188, 350, 130, 27);
        panel.add(comboBoxLocalidad);
        
        comboBoxTipoContacto = new JComboBox<String>();
        comboBoxTipoContacto.setBounds(188, 400, 130, 27);
        panel.add(comboBoxTipoContacto);
        
        txtCodPostal = new JTextField();
        txtCodPostal.setBounds(188, 450, 130, 26);
        panel.add(txtCodPostal);
        txtCodPostal.setColumns(10);
        
        txtEquipoPref = new JTextField();
        txtEquipoPref.setBounds(188, 500, 130, 26);
        panel.add(txtEquipoPref);
        txtEquipoPref.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(150, 550, 117, 29);
		panel.add(btnAgregarPersona);
		
		this.setVisible(false);
	}

	public void rellenarListaLocalidades(List<LocalidadDTO> localidades) {
		this.comboBoxLocalidad.removeAllItems();
		for (LocalidadDTO valor : localidades)
        {
        	this.comboBoxLocalidad.addItem(valor.getNombre());
        }
	}
	
	public void rellenarListaTiposContacto(List<TipoContactoDTO> tiposContacto) {
		this.comboBoxTipoContacto.removeAllItems();
		for (TipoContactoDTO valor : tiposContacto)
        {
        	this.comboBoxTipoContacto.addItem(valor.getNombre());
        }
	}
	
	public JComboBox<String> getComboBoxLocalidad() {
		return this.comboBoxLocalidad;
	}

	public void setComboBoxLocalidad(JComboBox<String> comboBoxLocalidad) {
		this.comboBoxLocalidad = comboBoxLocalidad;
	}
	
	public JComboBox<String> getComboBoxTipoContacto() {
		return this.comboBoxTipoContacto;
	}

	public void setComboBoxTipoContacto(JComboBox<String> comboBoxTipoContacto) {
		this.comboBoxTipoContacto = comboBoxTipoContacto;
	}

	public void mostrarVentana()
	{
		this.setVisible(true);
		this.setSize(440,630);
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
	
	public JTextField getTxtCodPostal() {
		return txtCodPostal;
	}
	
	public JTextField getTxtEquipoPref() {
		return txtEquipoPref;
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
		this.txtCodPostal.setText("");
		this.txtEquipoPref.setText("");
		this.dispose();
	}
	
	
}

