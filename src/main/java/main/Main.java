package main;

import modelo.Agenda;
import modelo.Localidad;
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
		Controlador controlador = new Controlador(vista, modelo, localidad);
		controlador.inicializar();
	}
}
