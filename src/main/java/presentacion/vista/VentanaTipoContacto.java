package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaTipoContacto extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	private JButton btnAgregarTipoContacto;
	private static VentanaTipoContacto INSTANCE;
	
	public static VentanaTipoContacto getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaTipoContacto(); 	
			return new VentanaTipoContacto();
		}
		else
			return INSTANCE;
	}

	private VentanaTipoContacto() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreTipoContacto = new JLabel("Nombre TipoContacto");
		lblNombreTipoContacto.setBounds(30, 41, 119, 16);
		panel.add(lblNombreTipoContacto);
		
        
		txtNombre = new JTextField();
		txtNombre.setBounds(188, 36, 130, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		btnAgregarTipoContacto = new JButton("Agregar");
		btnAgregarTipoContacto.setBounds(150, 228, 117, 29);
		panel.add(btnAgregarTipoContacto);
		
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
	

	public JButton getBtnAgregarTipoContacto() 
	{
		return btnAgregarTipoContacto;
	}

	public void cerrar()
	{
		this.txtNombre.setText("");
		this.dispose();
	}
	

	
}

