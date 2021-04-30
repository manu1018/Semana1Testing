package logica;

import java.util.Iterator;
import java.util.LinkedList;
import javax.naming.CommunicationException;

class Carrito implements ICarrito {

	private LinkedList<Item> items;
	// el carrito se compone por una lista de <Producto, cantidad>

	Cliente cliente;
	String nombreCarrito;
	private ISistemaClientes sistCli;
	private ISistemaFacturacion sistFact;

	public Carrito(Cliente c) {
		cliente = c;
		sistCli = null;
		sistFact = null;
		try {
			nombreCarrito = c.getNombre();
		} catch (CommunicationException ce) {
			nombreCarrito = "General";
		}

		this.items = new LinkedList<Item>();
	}

	public void agregarProducto(Producto p, int cant) {
		try {
			Item i = this.obtenerItem(p.getNombre());
			if (i != null) {
				// Se arreglo el setCantidad
				i.setCantidad(cant);
			} else {
				items.add(new Item(p, cant));
			}
		} catch (NullPointerException e) {
		}
	}

	public void disminuirProducto(Producto p, int cant) {
		Item i = this.obtenerItem(p.getNombre());
		if (i != null) {
			// Se cambio la logica
			int cantidad = i.getCantidad() - cant;
			if (cantidad < 0) {
				i.setCantidad(0);
			} else {
				i.setCantidad(cantidad);
			}
		} else {
			items.add(new Item(p, cant));
		}
	}

	public void eliminarProductos(Producto p) {
		for (Item item : items) {
			if (item.getProducto() == p) {
				items.remove(item);
			}
		}
	}

	public double obtenerPrecioTotal() {
		double precioTotal = 0;
		for (Item item : items)
			// Se arreglo esta cuenta para obtener el precio total correcto
			precioTotal += item.getProducto().getPrecio() * item.getCantidad();
		return precioTotal;
	}

	public double obtenerSubtotal(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int obtenerCantidad(Producto p, String s) {
		try {
			// Se cambio getDescripcion() a getNombre()
			Item i = obtenerItem(p.getNombre());
			if (i != null) {
				return i.getCantidad();
			} else {
				return 0;
			}
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public void vaciar() {
		items.clear();
	}

	private Item obtenerItem(String s) {
		Iterator<Item> iter = items.iterator();
		while (iter.hasNext()) {
			Item actual = iter.next();
			if (actual.getProducto().getNombre().equals(s)) {
				return actual;
			}
		}
		return null;
	}

	public void pagar() {
		double total = (double) obtenerPrecioTotal();
		double descuento;

		try {
			descuento = sistCli.descuentoCliente(cliente);
		} catch (NoExisteClienteException e) {
			descuento = 0;
		}
		total = total * (1 - descuento);
		sistFact.facturar(total);
	}

	public void configurarSistemaClientes(ISistemaClientes s) {
		this.sistCli = s;
	}

	public void configurarSistemaFacturacion(ISistemaFacturacion s) {
		this.sistFact = s;
	}

}