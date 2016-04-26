package fiuba.algo3.tests;

import org.junit.Test;

import fiuba.algo3.modelo.Posicion;
import org.junit.Assert;

public class PosicionTest {

	@Test
	public void testLaPosicionSeCreaConLaFilaYColumnaCorrecta() {
		
		Posicion nuevaPosicion = new Posicion(1,'A');
		
		Assert.assertEquals(1, nuevaPosicion.getFila());
		Assert.assertEquals('A', nuevaPosicion.getColumna());
	}

}
