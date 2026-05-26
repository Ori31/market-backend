package mx.edu.tecdesoftware.market_backend.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table (name = "clientes")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String apellidos;

    private String celular;

    private String direccion;


    @Column(name = "correo_electronico")
    private String correoElectronico;

}
