package presentacion.vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dto.ProvinciaDTO;

public class VentanaLocalidad extends JFrame
{
    private static final long serialVersionUID = 1L;
    //private JTextField txtNombrePais;
    //private JTextField txtNombreProv;
    private JTextField txtNombreLoc;
    private JComboBox<String> comboBoxPais;
    private JComboBox<String> comboBoxProv;
    private JComboBox<String> comboBoxLoc;

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
   	 
   	 JLabel lblNombrePais = new JLabel("Pais");
   	 lblNombrePais.setBounds(30, 41, 119, 16);
   	 panel.add(lblNombrePais);

   	 JLabel lblNombreProv = new JLabel("Provincia");
   	 lblNombreProv.setBounds(30, 81, 119, 16);
   	 panel.add(lblNombreProv);
   	 
   	 JLabel lblNombreLoc = new JLabel("Localidad");
   	 lblNombreLoc.setBounds(30, 120, 119, 16);
   	 panel.add(lblNombreLoc);
   	 
   	 /*txtNombrePais = new JTextField();
   	 txtNombrePais.setBounds(188, 36, 130, 26);
   	 panel.add(txtNombrePais);
   	 txtNombrePais.setColumns(10);*/
   	 
   	 comboBoxPais = new JComboBox<String>();
    	comboBoxPais.setBounds(188, 36, 130, 27);
    	comboBoxPais.addItem("Argentina");
    	panel.add(comboBoxPais);
   	 
   	 /*txtNombreProv = new JTextField();
   	 txtNombreProv.setBounds(188, 66, 130, 26);
   	 panel.add(txtNombreProv);
   	 txtNombreProv.setColumns(10);*/
   	 
    	comboBoxProv = new JComboBox<String>();
    	comboBoxProv.setBounds(188, 76, 190, 27);
    	panel.add(comboBoxProv);
   	 
    	comboBoxLoc = new JComboBox<String>();
    	comboBoxLoc.setBounds(188, 116, 190, 27);
    	panel.add(comboBoxLoc);
   	 
   	 /*txtNombreLoc = new JTextField();
   	 txtNombreLoc.setBounds(188, 116, 130, 26);
   	 panel.add(txtNombreLoc);
   	 txtNombreLoc.setColumns(10);*/

   	 
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
    
    /*public JTextField getTxtNombrePais(){
   	 return txtNombrePais;
    }*/
    
    public JComboBox<String> getcomboBoxPais(){
   	 return comboBoxPais;
    }
    
    /*public JTextField getTxtNombreProv(){
   	 return txtNombreProv;
    }*/
    
    public JComboBox<String> getcomboBoxProv(){
   	 return comboBoxProv;
    }
    
    public JTextField getTxtNombreLoc(){
   	 return txtNombreLoc;
    }
    
    public JComboBox<String> getComboBoxLoc(){
   	 return comboBoxLoc;
    }


    public JButton getBtnAgregarLocalidad() {
   	 return btnAgregarLocalidad;
    }
    
    public void cerrar(){
   	 this.txtNombreLoc.setText("");
   	 this.dispose();
    }
    
    public void rellenarListaProvincias(List<ProvinciaDTO> provincias) {
   	 for (ProvinciaDTO valor : provincias){
   		 this.comboBoxProv.addItem(valor.getNombreProvincia());
    	}
    }
    
    public void cargarListaLocalidades(List<ProvinciaDTO> provincias, String nombreProv) {
    	 this.comboBoxLoc.removeAllItems();
    	 for (ProvinciaDTO valor : provincias){
    		 if(valor.getNombreProvincia().equalsIgnoreCase(nombreProv)) {
    			 this.comboBoxLoc.addItem(valor.getNombreLocalidad());
    		 }
    	 }
    }
    
}
