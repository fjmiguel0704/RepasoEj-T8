package ejercicio1;

public class Producto implements Comparable<Producto> {

	/**
	 * Nombre del producto
	 */
	protected String nombre = "";
	/**
	 * Precio del producto
	 */
	protected double precio;

	/**
	 * Constructor por defecto
	 */
	public Producto() {

	}

	/**
	 * Constructor que asigna valores a nombre y precio tras su comprobación
	 * 
	 * @param nombre nombre del producto
	 * @param precio precio del producto
	 */
	public Producto(String nombre, double precio) {
		super();
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (precio > 0) {
			this.precio = precio;
		}

	}

	public Producto(String nombre) {
		super();
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}

	}

	/**
	 * Devuelve el nombre del producto
	 * 
	 * @return el nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del producto
	 * 
	 * @param nombre nombre del producto
	 */
	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	/**
	 * Devuelve el precio del producto
	 * 
	 * @return el precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio del producto
	 * 
	 * @param precio precio del producto
	 */
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * Devuelve el nombre y precio del producto en lineas distintas
	 */
	@Override
	public String toString() {
		String result;
		result = "Nombre producto: " + nombre + "\n" + "Precio: " + precio;
		return result;
	}

	/**
	 * Este método calcula el precio total de una cantidad de productos
	 * 
	 * @param cantidad
	 * @return el precio
	 */
	protected double calcular(int cantidad) {
		return precio * cantidad;
	}

	/**
	 * Comprueba si dos nombres de productos son iguales y devuelve true en caso de
	 * que lo sean y false en caso contrario
	 */
	@Override
	public boolean equals(Object o) {
		boolean estado = false;
		Producto p = (Producto) o;
		if (this.nombre.equals(p.nombre)) {
			estado = true;
		}
		return estado;
	}

	/**
	 * Este método compara los nombres de los prductos y los ordena alfabéticamente
	 * de menor a mayor
	 */
	@Override
	public int compareTo(Producto p) {
		int result = 0;
		result = this.nombre.compareTo(p.nombre);
		return result;
	}

}
