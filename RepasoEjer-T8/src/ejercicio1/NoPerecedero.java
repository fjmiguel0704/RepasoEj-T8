package ejercicio1;

public class NoPerecedero extends Producto {
	/**
	 * Tipo de producto que no caduca
	 */
	private String tipo = "";

	/**
	 * Constructor que asigna valores al tipo de producto no perecedero
	 * 
	 * @param tipo
	 * @param nombre
	 * @param precio
	 */
	public NoPerecedero(String tipo, String nombre, double precio) {
		super(nombre, precio);
		if (tipo != null && !tipo.isEmpty()) {
			this.tipo = tipo;
		}
	}

	/**
	 * Devuelve el tipo de producto no perecedero
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo de producto no perecedero
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el nombre, precio y tipo de producto no perecedero
	 */
	public String toString() {
		String result;
		result = super.toString() + 
				"\n" + "Dias a caducar: " + tipo;
		return result;
	}

	/**
	 * Devuelve el precio total de una cantidad de productos
	 */
	@Override
	public double calcular(int cantidad) {
		return super.calcular(cantidad);
	}
}
