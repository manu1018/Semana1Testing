package logica;



public class FactoryCarrito {

	static ICarrito carrito;
	
	public static ICarrito getCarrito(){
	
		if (carrito == null){

			carrito = new Carrito(new Cliente("NewCliente","202105"));
		}
		return carrito;
	}
}
