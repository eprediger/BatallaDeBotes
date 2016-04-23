package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.modelo.Tablero;

public class TableroTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testElTableroSeCreaVacio() {

		Tablero tablero = new Tablero();
		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testAgregarBoteSumaUnBoteAlTablero() {
		
		Tablero tablero = new Tablero();
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testEliminarBoteRestaUnBoteAlTablero() {
		
		Tablero tablero = new Tablero();
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertEquals(1, tablero.cantidadDeBotes());
		
		tablero.removerBoteEnPosicion(1,'A');
		
		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testUnCasilleroSinBoteDevuelveQueEstaVacio() {
		
		Tablero tablero = new Tablero();
		
		Assert.assertFalse(tablero.laPosicionTieneUnBote(1,'A'));
	}
	
	@Test
	public void testUnCasilleroConBoteDevuelveQueEstaLleno() {
		
		Tablero tablero = new Tablero();
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertTrue(tablero.laPosicionTieneUnBote(1,'A'));
	}
	
	@Test
	public void testAlVaciarElTableroNoTieneBotes() {
		
		Tablero tablero = new Tablero();
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		tablero.reiniciarTablero();
		
		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
}