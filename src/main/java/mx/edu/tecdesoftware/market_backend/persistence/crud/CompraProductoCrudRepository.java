package mx.edu.tecdesoftware.market_backend.persistence.crud;

import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProducto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompraProductoCrudRepository extends CrudRepository<CompraProducto, Integer> {

    @Modifying
    @Query("DELETE FROM CompraProducto cp WHERE cp.id.idProducto = :idProducto")
    void deleteByIdIdProducto(@Param("idProducto") int idProducto);
}
