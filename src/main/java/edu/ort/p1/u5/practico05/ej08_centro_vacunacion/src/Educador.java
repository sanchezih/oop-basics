package edu.ort.p1.u5.practico05.ej08_centro_vacunacion.src;

public class Educador extends Persona {
	
	private NivelEducacion nivelEducacion;

	public Educador(String dni, String nombre, int edad, boolean pacRiesgo, NivelEducacion nivelEducacion) {
		super(dni, nombre, edad, pacRiesgo);
		this.nivelEducacion = nivelEducacion;
	}

	public int getprioridad() {
		int prioridad = super.PRIORIDAD_MEDIA;
		if ((super.getprioridad() == super.PRIORIDAD_MAXIMA) || this.nivelEducacion == NivelEducacion.INICIAL) {
			prioridad = super.PRIORIDAD_MAXIMA;
		}
		return prioridad;
	}

	@Override
	public String toString() {
		return super.toString() + "Educador [nivelEducacion=" + nivelEducacion + "]";
	}

}
