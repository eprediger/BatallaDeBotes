package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.modelo.Bote;
import fiuba.algo3.modelo.Lancha;
import fiuba.algo3.modelo.NoHayBoteException;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.YaHayBoteException;
import fiuba.algo3.modelo.Yate;

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
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testHundirBoteRestaUnBoteAlTablero() {
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(4,'E'));
		Assert.assertEquals(2, tablero.cantidadDeBotes());
		
		tablero.hundirEmbarcacionDePosicion(new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testUnCasilleroConBoteDevuelveQueEstaLleno() {

		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		
		Assert.assertTrue(tablero.hayUnBoteEnLaPosicion(new Posicion(1,'A')));
	}
	
	@Test
	public void testUnCasilleroSinBoteDevuelveQueEstaVacio() {
		
		Assert.assertFalse(tablero.hayUnBoteEnLaPosicion(new Posicion(1,'A')));
	}

	@Test
	public void testAlVaciarElTableroNoTieneBotes() {

		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(4,'A'));
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'G'));
		
		tablero.reiniciarTablero();
		
		Assert.assertEquals(0, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testAgregarUnaLanchaSumaUnaEmbarcacionAlTablero(){
		
		tablero.agregarEmbarcacionEnPosicion(new Lancha(), new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testAgregarUnYateSumaUnaEmbarcacionAlTablero(){
		
		tablero.agregarEmbarcacionEnPosicion(new Yate(), new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
	}
	
	@Test
	public void testTodosLasEmbarcacionesSumanYRestanAlTotalDeBotes() {
		
		tablero.agregarEmbarcacionEnPosicion(new Yate(), new Posicion(1,'A'));
		Assert.assertEquals(1, tablero.cantidadDeBotes());
		
		tablero.agregarEmbarcacionEnPosicion(new Lancha(), new Posicion(2,'A'));
		Assert.assertEquals(2, tablero.cantidadDeBotes());
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(3,'A'));
		Assert.assertEquals(3, tablero.cantidadDeBotes());
	}
	
	@Test (expected = YaHayBoteException.class )
	public void testQuererAgregarUnEmbarcacionDondeYaLaHayArrojaExcepcion() {
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		tablero.agregarEmbarcacionEnPosicion(new Lancha(), new Posicion(1,'A'));
		tablero.agregarEmbarcacionEnPosicion(new Yate(), new Posicion(1,'A'));
	}
	
	@Test(expected = NoHayBoteException.class)
	public void testQuererHundirUnaEmbarcacionDondeNoLoHayArrojaExcepcion() {
		
		tablero.hundirEmbarcacionDePosicion(new Posicion(2,'B'));
	}
	
	@Test
	public void testSePuedeAgregarCualquierEmbarcacionConUnMetodo() {
		
		tablero.agregarEmbarcacionEnPosicion(new Bote(), new Posicion(1,'A'));
		Assert.assertEquals(1, this.tablero.cantidadDeBotes());
		
		tablero.agregarEmbarcacionEnPosicion(new Lancha(), new Posicion(2,'A'));
		Assert.assertEquals(2, this.tablero.cantidadDeBotes());
		
		tablero.agregarEmbarcacionEnPosicion(new Yate(), new Posicion(3,'A'));
		Assert.assertEquals(3, this.tablero.cantidadDeBotes());
	}
}