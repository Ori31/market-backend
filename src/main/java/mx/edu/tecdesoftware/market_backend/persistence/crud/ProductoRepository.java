package mx.edu.tecdesoftware.market_backend.persistence.crud;
import mx.edu.tecdesoftware.market_backend.domain.Product;
import mx.edu.tecdesoftware.market_backend.domain.repository.ProductRepository;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend.persistence.entity.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Da acceso a la base de datos
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    //SELECT * FROM productos
    public List<Product> getAll() {
        //Se "castea" Iterable a lista
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByCantidadOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }
    //Obtener productos escasos
    public Optional<List<Product>> getScarseProducts(int quantity)
    {
       Optional<List<Producto>>  productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
       return Optional.of(productMapper.toProducts(productos.get()));
    }

    //Obtener un producto dado el ID
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }
    
    //Guardar producto
    public Product save(Product product){
        
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    //Eliminar un producto por ID
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
