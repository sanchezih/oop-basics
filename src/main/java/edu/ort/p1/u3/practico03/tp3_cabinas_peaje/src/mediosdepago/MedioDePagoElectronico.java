package edu.ort.p1.u3.practico03.tp3_cabinas_peaje.src.mediosdepago;

public abstract class MedioDePagoElectronico extends MedioDePago {

	private int cantDiasDemoraPago;

	public MedioDePagoElectronico(int cantDiasDemoraPago) {
		super();
		this.cantDiasDemoraPago = cantDiasDemoraPago;
	}

	public int getCantDiasDemoraPago() {
		return cantDiasDemoraPago;
	}

	public void setCantDiasDemoraPago(int cantDiasDemoraPago) {
		this.cantDiasDemoraPago = cantDiasDemoraPago;
	}
}