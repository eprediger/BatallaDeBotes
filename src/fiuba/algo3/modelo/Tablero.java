package fiuba.algo3.modelo;

import java.util.Hashtable;
import java.util.Map;

public class Tablero {

	private Map<Posicion,HabitanteMapa> mapa;
	private int totalDeBotes;
	
	public Tablero() {
		
		this.mapa = new Hashtable<Posicion,HabitanteMapa>();
		this.totalDeBotes = 0;
	}
	
	public void crearTableroVacio(){
		
		for(int i = 1; i <= 8; i++){
			for(char letra = 'A'; letra <= 'H'; letra++){
				
				Posicion nuevaPosicion = new Posicion(i,letra);
				mapa.put(nuevaPosicion, new Agua());
			}
		}
		this.totalDeBotes = 0;
	}

	public int cantidadDeBotes() {
		
		return this.totalDeBotes;
	}

	public void agregarBoteEnPosicion(int fila, char columna) {
		
		mapa.putIfAbsent(new Posicion(fila,columna), new Bote());
		
		this.totalDeBotes++;
	}

	public void removerBoteEnPosicion(int fila, char columna) {

		Posicion posicion = new Posicion(fila,columna);
		
		mapa.remove(posicion);
		
		mapa.put(posicion, new Agua());
		
		this.totalDeBotes--;
	}

	public boolean laPosicionTieneUnBote(int fila, char columna) {

		return this.mapa.containsKey(new Posicion(fila,columna));
	}

	public void reiniciarTablero() {
		
		this.crearTableroVacio();		
	}
}