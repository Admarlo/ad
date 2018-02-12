package serpis.ad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private BigDecimal importe;
	private Calendar fecha=Calendar.getInstance();

	@ManyToOne
	@JoinColumn (name = "Cliente")
	private Cliente cliente;
	//private Date fecha;
	
	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PedidoLinea> pedidoLineas = new ArrayList<>();
	
	public PedidoLinea[] getPedidoLineas() {
		return pedidoLineas.toArray(new PedidoLinea[0]);
	}
	
	public void add(PedidoLinea pedidoLinea) {
		pedidoLineas.add(pedidoLinea);
		pedidoLinea.setPedido(this);
	}
	
	public void remove(PedidoLinea pedidoLinea) {
		pedidoLineas.remove(pedidoLinea);
		pedidoLinea.setPedido(null);
	}
		
	public BigDecimal getImporte() {
		return importe;
}
		
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
//	public Date getFecha() {
//		return fecha;
//	}
//		
//	public void setFecha(Date fecha) {
//		this.fecha = fecha;
//	}
	
	
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	public void setFecha(Calendar fecha) {
		this.fecha=fecha;
	}
	
	@PrePersist
	private void prePersist() {
	}
	
	
	@Override
	public String toString() {
		return String.format("[%s] %s %s %s€", id, cliente, fecha, importe);
	}
	

}
