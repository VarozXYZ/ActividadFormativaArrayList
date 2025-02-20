package menuInteractivo;

public class Producto {
	private String nombre;
	private float precio;
	private int contador = 0;
	
	public Producto(String nombre, float precio, int contador) {
		this.nombre = nombre;
		this.precio = precio;
		this.contador = contador;
	}
	public Producto() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void mostrarDatos() {
		System.out.println("El nombre del producto es " + nombre + " y su precio es de " + precio);
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
}
