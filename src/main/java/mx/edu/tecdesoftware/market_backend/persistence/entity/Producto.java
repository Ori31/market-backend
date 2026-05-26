package mx.edu.tecdesoftware.market_backend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "productos")
public class Producto {

    //Llave primaria
    @Id

    //Autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_categoria")
    private String idCategoria;

    private String nombre;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "cantidad_stock")
    private Integer cantidadesStock;


    private Boolean estado;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getCantidadesStock() {
        return cantidadesStock;
    }

    public void setCantidadesStock(Integer cantidadesStock) {
        this.cantidadesStock = cantidadesStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
