package menuInteractivo;

public class Producto {
	private String nombre;
	private float precio;
	
	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
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
	
	
}
