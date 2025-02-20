package menuInteractivo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class MenuInteractivo {
	
	public static void main(String[] args) {
		ArrayList<Producto> lsProd = new ArrayList<Producto>();
		System.out.println("Bienvenido al administrador de productos. ¿Que te gustaría hacer?");
		int seleccion = -1;
		do {
			seleccion = obtenerEntero();
			switch (seleccion) {
			case 1:
			}
		} while (seleccion != 0);
		
		

	}
	
	public static Producto crearProducto(Producto producto) {
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		float precio = sc.nextFloat();
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		sc.close();
		return producto;
	}
	public static ArrayList<Producto> aggProd(ArrayList<Producto> arrayLs, Producto producto) {
		crearProducto(producto);
		arrayLs.add(producto);
		return arrayLs;
	}
	public static void buscarProd(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del producto del cual quieres ver los datos");
		try {
			Producto prodBuscar = encontrarProd(arrayLs);
			prodBuscar.mostrarDatos();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} 
		sc.close();
	}
	public static void modPrecio(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del producto del cual quieres modificar el precio");
		try {
			Producto prodMod = encontrarProd(arrayLs);
			System.out.println("Introduce el nuevo precio del producto");
			float precio = sc.nextFloat();
			prodMod.setPrecio(precio);
		} catch (IllegalArgumentException e) {
			e.getMessage();
			modPrecio(arrayLs);
		} catch (InputMismatchException e) {
			System.out.println("Debes introducir un número con decimales");
			modPrecio(arrayLs);
		} 
		sc.close();
	}
	public static void eliminarProd(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del producto que quieres eliminar");
		try {
			Producto prodEli = encontrarProd(arrayLs);
			arrayLs.remove(arrayLs.indexOf(prodEli));
		} catch (IllegalArgumentException e) {
			e.getMessage();
			eliminarProd(arrayLs);
		} catch (InputMismatchException e) {
			e.getMessage();
			eliminarProd(arrayLs);
		} 
		sc.close();
	}
	public static void mostrarProductos(ArrayList<Producto> arrayLs) {
		try {
			for (Producto i: arrayLs) {
				i.mostrarDatos();
			}
		} catch (Exception e) {
			e.getMessage();
		}	
	}
	public static Producto encontrarProd(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
			String nombre = sc.nextLine();
			for (Producto i: arrayLs) {
				if (i.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
					System.out.println("Coincidencia encontrada en el producto número " + i.getContador());
					sc.close();
					return i;
				} 
			}
		sc.close();
		throw new IllegalArgumentException("Producto no encontrado con ese nombre");
	}
	public static int obtenerEntero() {
		Scanner sc = new Scanner(System.in);
		System.out.println("#MENU#\n1. Agregar un producto\n2. Buscar un producto\n3.Modificar el precio de un producto\n4.Eliminar un producto\n5. Mostrar todos los productos\n0. Salir del programa");
		int seleccion = -1;
		try {
			seleccion = sc.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("Debes introducir un número entero del 0 al 5");
		}
		return seleccion;
	}
}
