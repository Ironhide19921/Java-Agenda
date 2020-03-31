package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import modelo.Localidad;
import modelo.TipoContacto;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VistaTipoContacto;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipoContacto;
import presentacion.vista.Vista;
import presentacion.vista.VistaLocalidad;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private List<LocalidadDTO> localidadesEnTabla;
		private List<TipoContactoDTO> tiposContactoEnTabla;
		private VentanaPersona ventanaPersona;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaTipoContacto ventanaTipoContacto;
		private VistaLocalidad vistaLocalidad;
		private VistaTipoContacto vistaTipoContacto;
		private Agenda agenda;
		private Localidad localidad;
		private TipoContacto tipoContacto;
		
		public Controlador(Vista vista, Agenda agenda, Localidad localidad, TipoContacto tipoContacto)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnEditar().addActionListener(e->editarPersona(e));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnAbmLocalidad().addActionListener(l->mostrarVistaLocalidad(l));
			this.vista.getBtnAbmTipoContacto().addActionListener(i->mostrarVistaTipoContacto(i));
			
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			
			this.vistaLocalidad = VistaLocalidad.getInstance();
			this.vistaLocalidad.getBtnAgregarLocalidad().addActionListener(v->mostrarVentanaLocalidad(v));
			this.vistaLocalidad.getBtnEditarLocalidad().addActionListener(e->editarLocalidad(e));
			this.vistaLocalidad.getBtnBorrarLocalidad().addActionListener(b->borrarLocalidad(b));
			
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaLocalidad.getBtnAgregarLocalidad().addActionListener(h->guardarLocalidad(h));
			
			this.vistaTipoContacto = VistaTipoContacto.getInstance();
			this.vistaTipoContacto.getBtnAgregarTipoContacto().addActionListener(w->mostrarVentanaTipoContacto(w));
			this.vistaTipoContacto.getBtnEditarTipoContacto().addActionListener(e->editarTipoContacto(e));
			this.vistaTipoContacto.getBtnBorrarTipoContacto().addActionListener(z->borrarTipoContacto(z));
			
			this.ventanaTipoContacto = VentanaTipoContacto.getInstance();
			this.ventanaTipoContacto.getBtnAgregarTipoContacto().addActionListener(y->guardarTipoContacto(y));
			
			this.agenda = agenda;
			this.localidad = localidad;
			this.tipoContacto = tipoContacto;
		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.consultarLocalidades();
			this.consultarTiposContacto();
			this.ventanaPersona.mostrarVentana();
		}

		private void mostrarVistaLocalidad(ActionEvent l) {
			this.vistaLocalidad.mostrarVentana();
		}
		
		private void mostrarVistaTipoContacto(ActionEvent i) {
			this.vistaTipoContacto.mostrarVentana();
		}
		
		private void mostrarVentanaLocalidad(ActionEvent v) {
			this.ventanaLocalidad.mostrarVentana();
		}
		
		private void mostrarVentanaTipoContacto(ActionEvent w) {
			this.ventanaTipoContacto.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();
			String cumple = ventanaPersona.getTxtCumple().getText();
			String calle = ventanaPersona.getTxtCalle().getText();
			String altura = ventanaPersona.getTxtAltura().getText();
			String piso = ventanaPersona.getTxtPiso().getText();
			String depto = ventanaPersona.getTxtDepto().getText();
			String loc = String.valueOf(ventanaPersona.getComboBoxLocalidad().getSelectedItem());
			String tipo = String.valueOf(ventanaPersona.getComboBoxTipoContacto().getSelectedItem());

			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, cumple, calle, altura, piso, depto, loc, tipo);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}
		
		private void editarPersona(ActionEvent e) {
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				int id = Integer.parseInt(String.valueOf(this.vista.getModelPersonas().getValueAt(fila,0)));
				String nombre = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,1));
				String tel = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,2));
				String email = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,3));
				String cumple = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,4));
				String calle = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,5));
				String altura = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,6));
				String piso = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,7));
				String depto = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,8));
				String loc = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,9));
				String tipo = String.valueOf(this.vista.getModelPersonas().getValueAt(fila,10));
				PersonaDTO nuevaPersona = new PersonaDTO(id, nombre, tel, email, cumple, calle, altura, piso, depto, loc, tipo);
				this.agenda.editarPersona(nuevaPersona);
				this.refrescarTabla();
			}
		}
		
		private void editarLocalidad(ActionEvent e) {
			int[] filasSeleccionadas = this.vistaLocalidad.getTablaLocalidades().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				int id = Integer.parseInt(String.valueOf(this.vistaLocalidad.getModelLocalidades().getValueAt(fila, 0)));
				String nombre = String.valueOf(this.vistaLocalidad.getModelLocalidades().getValueAt(fila,1));
				LocalidadDTO nuevaLocalidad = new LocalidadDTO(id, nombre);
				this.localidad.editarLocalidad(nuevaLocalidad);
				this.refrescarTablaLocalidades();
			}
		}
		private void editarTipoContacto(ActionEvent e) {
			int[] filasSeleccionadas = this.vistaTipoContacto.getTablaTiposContacto().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				int id = Integer.parseInt(String.valueOf(this.vistaTipoContacto.getModelTiposContacto().getValueAt(fila, 0)));
				String nombre = String.valueOf(this.vistaTipoContacto.getModelTiposContacto().getValueAt(fila,1));
				TipoContactoDTO nuevaTipoContacto= new TipoContactoDTO(id, nombre);
				this.tipoContacto.editarTipoContacto(nuevaTipoContacto);
				this.refrescarTablaTiposContacto();
			}
		}
		
		private void guardarLocalidad(ActionEvent h) {
			String nombre = this.ventanaLocalidad.getTxtNombre().getText();
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, nombre);
			this.localidad.agregarLocalidad(nuevaLocalidad);
			this.refrescarTablaLocalidades();
			this.ventanaLocalidad.cerrar();
		}
		
		private void guardarTipoContacto(ActionEvent y) {
			String nombre = this.ventanaTipoContacto.getTxtNombre().getText();
			TipoContactoDTO nuevaTipoContacto = new TipoContactoDTO(0, nombre);
			this.tipoContacto.agregarTipoContacto(nuevaTipoContacto);
			this.refrescarTablaTiposContacto();
			this.ventanaTipoContacto.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void borrarLocalidad(ActionEvent b)
		{
			int[] filasSeleccionadas = this.vistaLocalidad.getTablaLocalidades().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.localidad.borrarLocalidad(this.localidadesEnTabla.get(fila));
			}
			
			this.refrescarTablaLocalidades();
		}
		
		public void borrarTipoContacto(ActionEvent b)
		{
			int[] filasSeleccionadas = this.vistaTipoContacto.getTablaTiposContacto().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.tipoContacto.borrarTipoContacto(this.tiposContactoEnTabla.get(fila));
			}
			
			this.refrescarTablaTiposContacto();
		}


		
		public void inicializar()
		{
			this.refrescarTabla();
			this.refrescarTablaLocalidades();
			this.refrescarTablaTiposContacto();
			this.consultarLocalidades();
			this.consultarTiposContacto();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}
		
		private void refrescarTablaLocalidades()
		{
			this.localidadesEnTabla = localidad.obtenerLocalidades();
			this.vistaLocalidad.llenarTabla(this.localidadesEnTabla);

		}
		
		private void refrescarTablaTiposContacto()
		{
			this.tiposContactoEnTabla = tipoContacto.obtenerTiposContacto();
			this.vistaTipoContacto.llenarTabla(this.tiposContactoEnTabla);
		}
		
		private void consultarLocalidades()
		{
			this.ventanaPersona.rellenarListaLocalidades(localidad.obtenerLocalidades());	
		}
		
		private void consultarTiposContacto()
		{
			this.ventanaPersona.rellenarListaTiposContacto(tipoContacto.obtenerTiposContacto());	
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
