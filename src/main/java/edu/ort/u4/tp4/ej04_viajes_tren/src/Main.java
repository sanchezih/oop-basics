package edu.ort.u4.tp4.ej04_viajes_tren.src;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		reservas.add(new Reserva("res01", 1, new Recorrido(Estacion.BUENOS_AIRES, Estacion.LUJAN)));
		reservas.add(new Reserva("res02", 2, new Recorrido(Estacion.BUENOS_AIRES, Estacion.LUJAN)));
		reservas.add(new Reserva("res03", 2, new Recorrido(Estacion.BUENOS_AIRES, Estacion.BRAGADO)));


		Empresa empresa = new Empresa(reservas);
		System.out.println(empresa.cantVecesRecorrida(Estacion.BUENOS_AIRES));
		System.out.println(empresa.cantVecesRecorrida(Estacion.ALBERTI));
		System.out.println(empresa.cantVecesRecorrida(Estacion.BRAGADO));


	}

}