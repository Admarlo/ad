package serpis.ad;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoLinea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn (name = "Pedido")
	private Pedido pedido;
	
	
	@ManyToOne
	@JoinColumn (name = "Articulo")
	private Articulo articulo;
	
	private BigDecimal precio;
	private BigDecimal unidades;
	private BigDecimal importe;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
		importe=unidades.multiply(precio);
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
		precio=articulo.getPrecio();
		unidades=new BigDecimal(1);
		importe=unidades.multiply(precio);
	}
	
	public BigDecimal getUnidades() {
		return unidades;
	}
	
	public void setUnidades(BigDecimal unidades) {
		this.unidades = unidades;
		importe=unidades.multiply(precio);
	}
	
		//NO SETTER. solución para campo calculado
	@Column(name="importe")
	public BigDecimal getImporte() {
		//return importe;
		return unidades.multiply(precio);
	}
	
		
	@Override
	public String toString() {
		return String.format("[%s] %s %s %s€ %s %s€", id, pedido, articulo, precio, unidades,  importe);
}
	

}
