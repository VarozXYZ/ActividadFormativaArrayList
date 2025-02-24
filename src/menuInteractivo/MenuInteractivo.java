package menuInteractivo;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuInteractivo {
	public static void main(String[] args) {
	    ArrayList<Producto> lsProd = new ArrayList<Producto>();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Bienvenido al administrador de productos. ¿Qué te gustaría hacer?");
	    int seleccion = -1;
	    do {
	        seleccion = obtenerEntero();
	        switch (seleccion) {
	            case 1: 
	                aggProd(lsProd);
	                break;    
	            case 2: 
	            	buscarProd(lsProd);
	            	break;
	            case 3:
	            	modPrecio(lsProd);
	            	break;
	            case 4:
	            	eliminarProd(lsProd);
	            	break;
	            case 5:
	            	mostrarProd(lsProd);
	            	break;
	            case 0:
	            	seleccion = 0;
	        }
	    } while (seleccion != 0);
	}
	public static Producto crearProducto() {
	    Scanner sc = new Scanner(System.in);
	    try {
	    	System.out.println("Introduce el nombre del producto:");
		    String nombre = sc.nextLine();
		    System.out.println("Introduce el precio del producto:");
		    float precio = sc.nextFloat();
		    Producto nuevoProducto = new Producto(nombre, precio);
		    return nuevoProducto;
	    } catch (Exception e) {
	    	System.out.println("Debes introducir un número. (Recuerda utilizar coma (\",\") para los decimales");
	    	return crearProducto();
	    }
	    
	}
	public static ArrayList<Producto> aggProd(ArrayList<Producto> arrayLs) {
	    Producto nuevoProducto = crearProducto(); 
	    arrayLs.add(nuevoProducto);
	    System.out.println("¡Producto añadido!");
	    return arrayLs;
	}
	public static void buscarProd(ArrayList<Producto> arrayLs) {
		System.out.println("Introduce el nombre del producto del cual quieres ver los datos");
		try {
			Producto prodBuscar = encontrarProd(arrayLs);
			prodBuscar.mostrarDatos();
		} catch (IllegalArgumentException e) {
			System.out.println("Prueba con otro nombre");
		} 
	}
	public static void modPrecio(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del producto del cual quieres modificar el precio: ");
		try {
			Producto prodMod = encontrarProd(arrayLs);
			System.out.println("Introduce el nuevo precio del producto: ");
			float precio = sc.nextFloat();
			checkRegex(precio);
			prodMod.setPrecio(precio);
			System.out.println("Precio modificado correctamente.");
		} catch (InputMismatchException e) {
			System.out.println("Debes introducir un número con un máximo de 2 decimales. (Recuerda utilizar coma (\",\") para los decimales");
		} catch (IllegalArgumentException e) {
			System.out.println("Reintenta con otro nombre");
		}
	}
	public static void eliminarProd(ArrayList<Producto> arrayLs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del producto que quieres eliminar: ");
		try {
			Producto prodEli = encontrarProd(arrayLs);
			arrayLs.remove(arrayLs.indexOf(prodEli));
			System.out.println("Producto eliminado");
		} catch (IllegalArgumentException e) {
			System.out.println("Reintenta con otro nombre");
		} 
	}
	public static void mostrarProd(ArrayList<Producto> arrayLs) {
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
					System.out.println("Coincidencia encontrada");
					return i;
				}
			}
			System.out.println("Producto no encontrado");
			throw new IllegalArgumentException("Producto no encontrado con ese nombre");
	}
	public static int obtenerEntero() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---------------MENU-------------\n1. Agregar un producto\n2. Buscar un producto\n3. Modificar el precio de un producto\n4. Eliminar un producto\n5. Mostrar todos los productos\n0. Salir del programa");
		int seleccion = -1;
		try {
			seleccion = sc.nextInt();
		} catch (NumberFormatException e) {
			System.out.println("Debes introducir un número entero del 0 al 5");
		} catch (InputMismatchException e) {
			System.out.println("Debes introducir un número entero del 0 al 5");
		}
		return seleccion;
	}
	public static float checkRegex(float precio) {
		Pattern patern = Pattern.compile("^\\d+(\\.\\d{1,2})?$");
		String precioRegex = String.valueOf(precio);
		Matcher matcher = patern.matcher(precioRegex);
		if (matcher.matches()) {
			return precio;
		}
		throw new InputMismatchException("Debes introducir un número con máximo 2 decimales. (Recuerda utilizar coma (\",\") para los decimales");
	}
}
