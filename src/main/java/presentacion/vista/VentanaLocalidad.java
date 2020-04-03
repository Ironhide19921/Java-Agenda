package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	private JButton btnAgregarLocalidad;
	private static VentanaLocalidad INSTANCE;


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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreLocalidad = new JLabel("Nombre Localidad");
		lblNombreLocalidad.setBounds(30, 41, 119, 16);
		panel.add(lblNombreLocalidad);
		
        
		txtNombre = new JTextField();
		txtNombre.setBounds(188, 36, 130, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		
		btnAgregarLocalidad = new JButton("Agregar");
		btnAgregarLocalidad.setBounds(150, 228, 117, 29);
		panel.add(btnAgregarLocalidad);
		
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


	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}
	
	public void cerrar()
	{
		this.txtNombre.setText("");
		this.dispose();


	}
	
	
}

