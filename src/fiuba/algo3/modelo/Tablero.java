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
				}
			}
		}
		return totalDeBotes;
	}

	public void agregarEmbarcacionEnPosicion(Embarcacion embarcacion, Posicion posicion) {
		
		if (mapa.get(posicion).esUnaEmbarcacion()) {
			
			throw new YaHayBoteException();
		}
		else mapa.put(posicion, embarcacion);
	}

	public void hundirEmbarcacionDePosicion(Posicion posicion) {
		
		if (mapa.get(posicion).esUnaEmbarcacion()) {
			
			mapa.remove(posicion);
			mapa.put(posicion, new Agua());
		}
		
		else throw new NoHayBoteException();
	}

	public boolean hayUnBoteEnLaPosicion(Posicion posicion) {
		
		return (this.mapa.get(posicion).esUnaEmbarcacion());
	}

	public void reiniciarTablero() {
		
		this.crearTableroVacio();		
	}
}