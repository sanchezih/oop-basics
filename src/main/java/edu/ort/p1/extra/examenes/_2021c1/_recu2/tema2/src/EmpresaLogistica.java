package edu.ort.p1.extra.examenes._2021c1._recu2.tema2.src;

public class EmpresaLogistica {

	public final static int CANT_CAMIONES = 80;
	public final static int CANT_CHOFERES = 20;

	private Camion[] camiones = new Camion[CANT_CAMIONES];
	private Chofer[] choferes = new Chofer[CANT_CHOFERES];
	private ColaDeViajes viajesContratados;

	public EmpresaLogistica() {
		super();
		this.viajesContratados = new ColaDeViajes();
	}

	public int cantViajesSinDestino(String nombreDestino) {
		Viaje viajeAux;
		Viaje centinela = new Viaje(null, null, null);
		int cant = 0;

		viajesContratados.add(centinela);
		viajeAux = viajesContratados.remove();

		while (viajeAux != centinela) {
			if (!viajeAux.contieneDestino(nombreDestino)) {
				cant++;
			}
			viajesContratados.add(viajeAux);
			viajeAux = viajesContratados.remove();
		}
		return cant;
	}

	public void informarDestinosPorCamionChofer() {

		Viaje viajeAux;
		Viaje centinela = new Viaje(null, null, null);
		int[][] mat = new int[CANT_CAMIONES][CANT_CHOFERES];

		viajesContratados.add(centinela);
		viajeAux = viajesContratados.remove();

		while (viajeAux != centinela) {
			acumularEnMatriz(mat, viajeAux);
			viajesContratados.add(viajeAux);
			viajeAux = viajesContratados.remove();
		}
		mostrarMatriz(mat);
	}

	private void acumularEnMatriz(int[][] mat, Viaje viaje) {
		int indexCamion;
		int indexChofer;

		indexChofer = viaje.getLegajoChofer() - 1;
		indexCamion = idxCamion(viaje.getPatenteDeCamion());
		mat[indexCamion][indexChofer] += viaje.cantDestinos();
	}

	private int idxCamion(int patente) {
		int i = this.camiones.length-1;
		while (i >= 0 && this.camiones[i].getNroPatente() != patente) {
			i--;
		}
		return i;
	}

	/*----------------------------------------------------------------------------*/

	public void agregarViaje(Viaje viaje) {
		this.viajesContratados.add(viaje);
	}

	public void mostrarCantDeViajesProgramadosQueNoIncluyenAlDestino(String destino) {
		int cant = 0;
		cant = cantViajesSinDestino(destino);
		System.out.println("Ejercicio B\nDe los viajes programados, " + cant + " no incluyen al destino " + destino);
	}

	private void mostrarMatriz(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println("Para el camion " + this.camiones[i] + ": ");
			System.out.println("Total destinos recorridos por chofer");
			for (int j = 0; j < mat[i].length; j++) {
				System.out.println("Chofer " + this.choferes[j] + ": ");
				System.out.println(mat[i][j] + " destinos recorridos");
			}
			System.out.println("\n");

		}
	}

}
