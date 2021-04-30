package logica;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCarrito {

	private Cliente cliente;
	private Carrito carrito;
	private Producto p1;
	private Producto p2;

	@BeforeEach
	void setUp() {
		cliente = new Cliente("Luis", "112233");
		carrito = new Carrito(cliente);
		p1 = new Producto(50, "Mayonesa", "Light");
		p2 = new Producto(100, "Maní", "Salado");
		
	}

	// Agregar Producto [TEST]
	@Test
	public void testAgregarProducto() {
		carrito.agregarProducto(p1, 3);
		int resultadoEsperado = 3;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(resultadoEsperado == x);
	}

	@Test
	public void testAgregarProductoNulo() {
		carrito.agregarProducto(null, 1);
		int resultadoEsperado = 0;
		int x = carrito.obtenerCantidad(null, "");
		assertTrue(resultadoEsperado == x);
	}

	// Disminuir Producto [TEST]
	@Test
	public void testDisminuirProducto() {
		carrito.agregarProducto(p1, 5);
		carrito.disminuirProducto(p1, 3);
		int resultadoEsperado = 2;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(resultadoEsperado == x);
	}

	@Test
	public void testDisminuirProductoResta() {
		carrito.agregarProducto(p1, 5);
		carrito.disminuirProducto(p1, 6);
		int resultadoEsperado = 0;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(resultadoEsperado == x);
	}

	// Obtener Precio Total [TEST]
	@Test
	public void testObtenerPrecioTotal() {
		carrito.agregarProducto(p2, 3); // 100 * 3
		carrito.agregarProducto(p1, 2); // 50 * 2
		double resultadoEsperado = 300 + 100;
		double total = carrito.obtenerPrecioTotal();
		assertTrue(total == resultadoEsperado);
		
	}

	@Test
	public void testPrecioTotal() {
		carrito.agregarProducto(p1, 2); // 50 * 2
		double resultadoEsperado = 100;
		double total = carrito.obtenerPrecioTotal();
		assertTrue(total == resultadoEsperado);
	}

	// Obtener Cantidad [TEST]
	@Test
	public void testObtenerCantidadProducto() {
		int cantidad = 2;
		carrito.agregarProducto(p1, cantidad);
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(x == cantidad);
	}

	@Test
	public void testObtenerCantidadProductoNula() {
		int resultado = 0;
		int x = carrito.obtenerCantidad(null, "No se encontro el producto");
		assertTrue(x == resultado);
	}

}
