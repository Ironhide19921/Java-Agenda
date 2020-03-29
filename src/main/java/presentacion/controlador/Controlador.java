package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Agenda;
import modelo.Localidad;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VistaLocalidad;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private List<LocalidadDTO> localidadesEnTabla;
		private VentanaPersona ventanaPersona;
		private VistaLocalidad vistaLocalidad;
		private VentanaLocalidad ventanaLocalidad;
		private Agenda agenda;
		private Localidad localidad;
		
		public Controlador(Vista vista, Agenda agenda, Localidad localidad)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnAbmLocalidad().addActionListener(l->mostrarVistaLocalidad(l));
			
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			// Agregado evento agregarLocalidad
			this.vistaLocalidad = VistaLocalidad.getInstance();
			this.vistaLocalidad.getBtnAgregarLocalidad().addActionListener(v->mostrarVentanaLocalidad(v));
			this.vistaLocalidad.getBtnBorrarLocalidad().addActionListener(b->borrarLocalidad(b));
			
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaLocalidad.getBtnAgregarLocalidad().addActionListener(h->guardarLocalidad(h));
			
			this.agenda = agenda;
			this.localidad = localidad;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}
		// Agregado metodo agregarLocalidad
		private void mostrarVistaLocalidad(ActionEvent l) {
			this.vistaLocalidad.mostrarVentana();
		}
		
		private void mostrarVentanaLocalidad(ActionEvent v) {
			this.ventanaLocalidad.mostrarVentana();
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
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, cumple, calle, altura, piso, depto);
			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}
		
		private void guardarLocalidad(ActionEvent p) {
			String nombre = this.ventanaLocalidad.getTxtNombre().getText();
			System.out.println(nombre);
//			String tel = ventanaPersona.getTxtTelefono().getText();
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, nombre);
			System.out.println(nuevaLocalidad.getNombre());
			this.localidad.agregarLocalidad(nuevaLocalidad);
			this.refrescarTablaLocalidades();
			this.ventanaLocalidad.cerrar();
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
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.refrescarTablaLocalidades();
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
			//this.vista.llenarTabla(this.localidadesEnTabla);
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
