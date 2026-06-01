package mx.edu.tecdesoftware.market_backend.persistence.crud;

import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;


    //SELECT * FROM productos
    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
