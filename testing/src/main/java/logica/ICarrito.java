package logica;



public interface ICarrito {

	/**
     * agrega una cantidad de un determinado producto 
     */
    public void agregarProducto(Producto p, int cant);
	
	/**
     * elimina cierta cantidad de un tipo de productos del carrito
     */
	public void disminuirProducto(Producto p, int cant);

    /**
     * elimina todos los productos de un tipo
     */
	public void eliminarProductos(Producto p);
		
    /**
     * elimina todos los productos de un tipo 
     */
    public void vaciar();    

    /**
     * devuleve el subtotal de un producto en particular
     */
	public double obtenerSubtotal(String nomP);
		
	/**
     * devuelve la cantidad de un producto particular en el carrito
     */
    public int obtenerCantidad(Producto p,String nomP);
	
	/**
     * devuelve el precio total
     */
	public double obtenerPrecioTotal();

         /**
     * calcula el total del carrito y crea una factura
     */
	public void pagar();

    /**
     * vincula con un sistema de clientes especifico
     */
	 public void configurarSistemaClientes(ISistemaClientes s);

     /**
     * vincula con un sistema de facturacion especifico
     */
	 public void configurarSistemaFacturacion(ISistemaFacturacion s);

}
