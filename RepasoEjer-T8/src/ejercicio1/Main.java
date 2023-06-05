package ejercicio1;

import java.awt.Component.BaselineResizeBehavior;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	/**
	 * Nombre del producto
	 */
	static String nombre;
	/**
	 * Precio del producto
	 */
	static double precio;
	/**
	 * Respuesta del usuario a producto perecedero
	 */
	static String respPere;
	/**
	 * Dias restantes a caducar de un producto
	 */
	static int diasCaducaProducto;
	/**
	 * Tipo de producto no perecedero
	 */
	static String tipoProductoNoPere;
	/**
	 * Coleccion para guardar todos los productos
	 */
	static TreeSet<Producto> collection = new TreeSet<Producto>();
	/**
	 * Scanner para leer por teclado
	 */
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		// Opción elegida del menú de opciones
		int opc;

		do {
			// Mostramos el menú
			menu();
			// Leemos la opción
			opc = read.nextInt();
			read.nextLine();

			switch (opc) {
			// En caso de ser 1, agregaremos un nuevo producto
			case 1:
				// Pedimos el nombre y lo leemos
				System.out.println("Nombre del producto a agregar: ");
				nombre = read.next();
				read.nextLine();
				// Creamos un objeto con el nombre del producto
				Producto p = new Producto(nombre);
				// Comprobamos que en la coleccion no se encuentre el producto y pedimos su
				// precio
				if (!collection.contains(p)) {
					System.out.println("Precio del producto: ");
					precio = read.nextDouble();
					read.nextLine();
					do {
						// Preguntamos si es o no un producto perecedero y leemos la respuesta
						System.out.println("Es un producto perecedero (Si|No):  ");
						respPere = read.next();
					} while (!respPere.equals("Si") && !respPere.equals("No"));
					// Llamamos al método que solicita datos según si es perecedero o no
					tipoProducto(nombre, precio, respPere, read);
					// Si el producto existe, mostramos un mensaje
				} else {
					System.out.println("Ya existe");
				}
				break;
			// En el caso 2, mostramos los productos que contiene la coleccion
			case 2:
				for (Producto valores : collection) {
					System.out.println(valores);
					System.out.println();
				}
				break;
			// En el caso 3, llamammos al método que elimina un producto
			case 3:
				eliminarProducto(read);
				break;
			// En el caso 4, modificaremos un producto
			case 4:
				System.out.println("Nombre del producto a modificar: ");
				nombre = read.next();
				read.nextLine();
				Producto prod = new Producto(nombre);
				if (collection.contains(prod)) {
					System.out.println("Nuevo precio del producto: ");
					precio = read.nextDouble();
					read.nextLine();
				}
				// En el caso 0, nos salimos del programa
			case 0:
				System.out.println("Saliendo...");
				break;
			// Si la opción no es correcta, mostramos un mensaje
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opc != 0);

	}

	/**
	 * Este método se encarga de eliminar un producto, recibiendo su nombre y
	 * comprobando si existe o no en la coleccion. Si existe lo eliminará y mostrará
	 * un mensaje, y si no existe, lo mostrará con un mensaje
	 * 
	 * @param read
	 */
	private static void eliminarProducto(Scanner read) {
		System.out.println("Nombre del producto a eliminar: ");
		nombre = read.next();
		read.nextLine();
		Producto p = new Producto(nombre);
		if (collection.remove(p)) {
			System.out.println("Producto eliminado correctamente");
		} else {
			System.out.println("No existe el producto");
		}
	}

	/**
	 * Este métpdo pide al usuario unos datos u otro según si el producto es
	 * perecedero o no. Después de recibirlos añadirá el nuevo producto resgitrado a
	 * la coleccion
	 * 
	 * @param nombre
	 * @param precio
	 * @param respPere
	 * @param read
	 */
	private static void tipoProducto(String nombre, double precio, String respPere, Scanner read) {
		boolean estado = false;
		Producto product = null;
		switch (respPere) {
		case "Si":
			System.out.println("Dias a caducar del producto: ");
			diasCaducaProducto = read.nextInt();
			read.nextLine();
			product = new Perecedero(nombre, precio, diasCaducaProducto);
			break;
		case "No":
			System.out.println("Tipo de producto: ");
			tipoProductoNoPere = read.next();
			product = new NoPerecedero(nombre, precio, tipoProductoNoPere);
			break;
		default:
			System.out.println("Opción incorrecta");
		}
		if (collection.add(product)) {
			System.out.println("Agregado correctamente");
		}
	}

	/**
	 * Este método muestra el menú de opciones para el usuario
	 */
	private static void menu() {
		System.out.println();
		System.out.println("MENÚ");
		System.out.println("================");
		System.out.println("1. Añadir producto");
		System.out.println("2. Listar productos");
		System.out.println("3. Eliminar producto");
		System.out.println("4. Modificar");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Selecciona una opción: ");
	}

}
