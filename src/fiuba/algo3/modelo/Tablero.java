package fiuba.algo3.modelo;

import java.util.Hashtable;
import java.util.Map;

public class Tablero {

	private Map<Posicion,HabitanteMapa> mapa;
	
	public Tablero() {
		
		this.mapa = new Hashtable<Posicion,HabitanteMapa>();
		this.crearTableroVacio();
	}
	
	public void crearTableroVacio(){
		
		for(int i = 1; i <= 8; i++){
			for(char letra = 'A'; letra <= 'H'; letra++){
				
				mapa.put(new Posicion(i,letra), new Agua());
			}
		}
	}

	public int cantidadDeBotes() {
		
		int totalDeBotes = 0;
		
		for(int i = 1; i <= 8; i++){
			for(char letra = 'A'; letra <= 'H'; letra++){
				
				if (mapa.get(new Posicion(i,letra)).esUnaEmbarcacion()){
					
					totalDeBotes++;
				};
			}
		}
		return totalDeBotes;
	}

	public void agregarBoteEnPosicion(int fila, char columna) {
		
		mapa.put(new Posicion(fila,columna), new Bote());
	}

	public void hundirBoteDePosicion(int fila, char columna) {

		Posicion posicion = new Posicion(fila,columna);
		
		mapa.remove(posicion);
		
		mapa.put(posicion, new Agua());
	}

	public boolean hayUnBoteEnLaPosicion(int fila, char columna) {
		
		return (this.mapa.get(new Posicion(fila, columna)).esUnaEmbarcacion());
	}

	public void reiniciarTablero() {
		
		this.crearTableroVacio();		
	}
}