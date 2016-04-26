package fiuba.algo3.modelo;

public class Posicion {

	int fila;
	char columna;
	
	public Posicion(int fila, char columna) {
		
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public char getColumna() {
		return columna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}	
}
