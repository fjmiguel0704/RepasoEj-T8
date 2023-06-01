package ejercicio1;

import java.awt.Component.BaselineResizeBehavior;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	static String nombre;
	static double precio;
	static String respPere;
	static int diasCaducaProducto;
	static String tipoProductoNoPere;
	static TreeSet<Producto> collection = new TreeSet<Producto>();

	public static void main(String[] args) {
		int opc;
		Scanner read = new Scanner(System.in);

		do {
			menu();
			opc = read.nextInt();
			read.nextLine();

			switch (opc) {
			case 1:
				System.out.println("Nombre del producto a agregar: ");
				nombre = read.next();
				read.nextLine();
				Producto p = new Producto(nombre);
				if (!collection.contains(p)) {
					System.out.println("Precio del producto: ");
					precio = read.nextDouble();
					read.nextLine();
					System.out.println("Es un producto perecedero (Si|No):  ");
					respPere = read.next();
					tipoProducto(nombre, precio, respPere, read);
				} else {
					System.out.println("Ya existe");
				}
				break;
			case 2:
				for (Producto valores : collection) {
					System.out.println(valores);
					System.out.println();
				}
				break;
			case 3:
				eliminarProducto(read);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opc != 4);

	}

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

	private static void tipoProducto(String nombre, double precio, String respPere, Scanner read) {
		switch (respPere) {
		case "Si":
			System.out.println("Dias a caducar del producto: ");
			diasCaducaProducto = read.nextInt();
			read.nextLine();
			Perecedero pere = new Perecedero(nombre, precio, diasCaducaProducto);
			if (collection.add(pere)) {
				System.out.println("Agregado correctamente");
			}
			break;
		case "No":
			System.out.println("Tipo de producto: ");
			tipoProductoNoPere = read.next();
			NoPerecedero noPere = new NoPerecedero(nombre, precio, tipoProductoNoPere);
			if (collection.add(noPere)) {
				System.out.println("Agregado correctamente");
			}
			break;
		default:
			System.out.println("Opción incorrecta");
		}
	}

	private static void menu() {
		System.out.println();
		System.out.println("MENÚ");
		System.out.println("================");
		System.out.println("1. Añadir producto");
		System.out.println("2. Listar productos");
		System.out.println("3. Eliminar producto");
		System.out.println("4. Salir");
		System.out.println();
		System.out.println("Selecciona una opción: ");
	}

}
