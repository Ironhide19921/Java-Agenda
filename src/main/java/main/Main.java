package main;

import modelo.Agenda;
import modelo.Localidad;
import modelo.Provincia;
import modelo.TipoContacto;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Localidad localidad = new Localidad(new DAOSQLFactory());
		TipoContacto tipoContacto = new TipoContacto(new DAOSQLFactory());
		Provincia provincia = new Provincia(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo, localidad, tipoContacto, provincia);
		controlador.inicializar();
	}
}
