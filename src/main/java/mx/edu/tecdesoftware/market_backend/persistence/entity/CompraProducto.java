package mx.edu.tecdesoftware.market_backend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
  @EmbeddedId
  private CompraProductoPK id;

  //Saber los productos que hay en una compra

  //Unir la tabla de compras
  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private Compra compra;

@ManyToOne
@JoinColumn(name = "id_producto", insertable = false, updatable = false)
private Producto producto;

  private Integer cantidad;
  private Double total;
  private Boolean estado;

}
