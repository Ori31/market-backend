package mx.edu.tecdesoftware.market_backend.persistence.crud;

import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;


    //SELECT * FROM productos
    public List<Producto> getAll() {
        //Se "castea" Iterable a lista
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByCantidadOrderByNombreAsc(idCategoria);
    }

    //Obtener productos escasos
    public Optional<List<Producto>> getEscasos(int cantidad)
    {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //Obtener un producto dado el ID
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //Guardar producto
    public Producto addProducto(Producto producto){
        return productoCrudRepository.save(producto);
    }

    //Eliminar un producto por ID
    public void deleteProductoById(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
