package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.PersonaDTO;

import javax.swing.JButton;

import persistencia.conexion.Conexion;

public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnAbmLocalidades;
	private JButton btnAbmTiposContacto;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"id","Nombre y apellido","Telefono","Email","Cumplea�os",
			"Calle","Altura","Piso","Depto","Localidad","Tipo de contacto", "Cod Postal", "Equipo Pref"};

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();

		frame.setBounds(100, 100, 1065, 350);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 1045, 262);

		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 1030, 182);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(170);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(4).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(5).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(5).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(6).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(6).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(7).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(7).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(8).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(8).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(9).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(9).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(10).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(10).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(11).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(11).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 228, 118, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(132, 228, 118, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(254, 228, 118, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(376, 228, 118, 23);
		panel.add(btnReporte);
		
		btnAbmLocalidades = new JButton("Localidades");
		btnAbmLocalidades.setBounds(498, 228, 118, 23);
		panel.add(btnAbmLocalidades);
		
		btnAbmTiposContacto = new JButton("TiposContacto");
		btnAbmTiposContacto.setBounds(620, 228, 118, 23);
		panel.add(btnAbmTiposContacto);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estás seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public JButton getBtnAbmLocalidad() 
	{
		return btnAbmLocalidades;
	}
	
	public JButton getBtnAbmTipoContacto() 
	{
		return btnAbmTiposContacto;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDTO p : personasEnTabla)
		{
			int id = p.getIdPersona();	
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String email = p.getEmail();
			String cumple = p.getCumpleanios();
			String calle = p.getCalle();
			String altura = p.getAltura();
			String piso = p.getPiso();
			String depto = p.getDepto();
			String loc = p.getLoc();
			String tipo = p.getTipo();
			String codPos = p.getCodPostal();
			String eqPref = p.getEquipoPref();
			Object[] fila = {id, nombre, tel, email, cumple, calle, altura, piso, depto, loc, tipo, codPos, eqPref};
			this.getModelPersonas().addRow(fila);
		}
		
	}
}
