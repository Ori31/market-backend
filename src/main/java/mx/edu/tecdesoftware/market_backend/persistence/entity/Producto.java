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



}
