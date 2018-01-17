package serpis.ad;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private String nombre;
	private BigDecimal precio;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public Articulo(long id, String nombre,  BigDecimal precio, Categoria categoria) {
		
	}
	
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setId(long id) {
		this.id=id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String toString() {
		return String.format("[%s] %s %s (%s)", id, nombre,precio,categoria);
		
	}
	
	

}
