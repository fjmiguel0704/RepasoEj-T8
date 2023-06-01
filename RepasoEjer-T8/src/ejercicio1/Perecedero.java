package ejercicio1;

public class Perecedero extends Producto {
	/**
	 * Dias a caducar del producto
	 */
	private int diasCaducar;

	/**
	 * Constructor que asigna valores a los dias a caducar del producto
	 * 
	 * @param diasCaducar
	 * @param nombre
	 * @param precio
	 */
	public Perecedero(int diasCaducar, String nombre, double precio) {
		super(nombre, precio);
		if (diasCaducar > 0) {
			this.diasCaducar = diasCaducar;
		}

	}

	/**
	 * Devuelve los dias a caducar
	 * 
	 * @return dias a caducar del producto
	 */
	public int getDiasCaducar() {
		return diasCaducar;
	}

	/**
	 * Modifica los dias a caducar del producto
	 * 
	 * @param diasCaducar
	 */
	public void setDiasCaducar(int diasCaducar) {
		this.diasCaducar = diasCaducar;
	}

	/**
	 * Devuelve el nombre, precio y dias a caducar del producto
	 */
	public String toString() {
		String result;
		result = super.toString() + 
				"\n" + "Dias a caducar: " + diasCaducar;
		return result;
	}

	/**
	 * Calcula el precio total de cada producto teniendo en cuenta los dias a
	 * caducar restantes
	 */
	@Override
	public double calcular(int cantidad) {
		double result = 0;
		if (cantidad == 1) {
			result = super.calcular(cantidad) / 4;
		} else if (cantidad == 2) {
			result = super.calcular(cantidad) / 3;
		}

		else if (cantidad == 3) {
			result = super.calcular(cantidad) / 2;
		}

		return result;
	}
}
