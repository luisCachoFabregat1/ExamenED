/**
 * 
 */
package clases;

/**
*@author luiscachofabregat
*
*
 */
public class Producto {
    /**
     * Atributos
     */
    protected String nombre;
    private double precio;
    private int cantidad;
    private  double precioTotalProducto;


    /**
     * Contructor de la clase Producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     */
    Producto(String nombre, double precio) {
        this.nombre=nombre;
        this.precio=precio;
        setCantidad(this.cantidad);
        precioTotalProducto=getPrecio()*getCantidad();
    }

    Producto(){}

    /**
     * Getter del nombre
     * @return nombre del producto
     */
    public String getNombre() {
            return this.nombre;
    }

    /**
     * Setter del nombre
     * @param nombre nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del precio
     * @return precio con dos decimales
     */
    public double getPrecio() {
        return ((double) Math.round(precio * 100d) / 100d);
    }

    /**
     * Setter del precio unitario del producto
     * @param precio preico del producto
     */
    public void setPrecio(double precio) {
        // Numero con solo dos decimales
        this.precio = ((double) Math.round(precio * 100d) / 100d);
    }

    /**
     * Getter de la cantidad
     * @return cantidad
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Setter de la cantidad
     * @param cantidad cantidad de productos
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Getter del Precio total del producto que es la cantidad por el precio por unidad
     * @return precio total del producto
     */
    public double getPrecioTotalProducto() {
        return  ((double)Math.round(this.precioTotalProducto * 100d) / 100d);
    }

    /**
     * Setter del precio total de producto
     * @param precioTotalProducto precio de la cantidad de productos
     */
    public void setPrecioTotalProducto(double precioTotalProducto) {
        this.precioTotalProducto =precioTotalProducto;
    }

    /**
     * Devuelve los datos de los productos
     */
    public void mostrarDatosProductos() {
        System.out.println(" ****** DATOS DEL PRODUCTO *****");
        System.out.println("NOMBRE:  " + getNombre());
        System.out.println("PRECIO:  " + getPrecio());
    }

    /**
     * Incrementar la cantidad de los productos
     */
    public void incrementar(){
      this.cantidad++;
      precioTotalProducto=this.cantidad*this.precio;
    }

	/**
	 * @return
	 */
	public int getNombre1() {
		return 0;
	}


}



