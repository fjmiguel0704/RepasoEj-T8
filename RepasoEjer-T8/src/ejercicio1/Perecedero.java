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
	public Perecedero(String nombre, double precio, int diasCaducar) {
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
			if (diasCaducar>0) {
				this.diasCaducar = diasCaducar;
			}
		
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
		double result = super.calcular(cantidad);
		if (diasCaducar == 1) {
			result /= 4;
		} else if (diasCaducar == 2) {
			result /= 3;
		}

		else if (diasCaducar == 3) {
			result /= 2;
		}

		return result;
	}
}
