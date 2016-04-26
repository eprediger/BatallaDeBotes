package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.modelo.Tablero;

public class TableroTest {

	public Tablero tablero;
	
	@Before
	public void setUp() throws Exception {
	
		this.tablero = new Tablero();
	}

	@Test
	public void testElTableroSeCreaVacio() {

		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testAgregarBoteSumaUnBoteAlTablero() {
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testEliminarBoteRestaUnBoteAlTablero() {
		
		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertEquals(1, tablero.cantidadDeBotes());
		
		tablero.agregarBoteEnPosicion(4,'E');
		
		Assert.assertEquals(2, tablero.cantidadDeBotes());
		
		tablero.hundirBoteDePosicion(1,'A');
		
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testUnCasilleroSinBoteDevuelveQueEstaVacio() {
		
		Assert.assertFalse(tablero.hayUnBoteEnLaPosicion(1,'A'));
	}
	
	@Test
	public void testUnCasilleroConBoteDevuelveQueEstaLleno() {

		tablero.agregarBoteEnPosicion(1,'A');
		
		Assert.assertTrue(tablero.hayUnBoteEnLaPosicion(1,'A'));
	}
	
	@Test
	public void testAlVaciarElTableroNoTieneBotes() {

		tablero.agregarBoteEnPosicion(1,'A');
		
		tablero.reiniciarTablero();
		
		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
}