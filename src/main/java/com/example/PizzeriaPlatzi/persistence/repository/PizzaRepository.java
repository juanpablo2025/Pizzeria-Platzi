package com.example.PizzeriaPlatzi.persistence.repository;

import com.example.PizzeriaPlatzi.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    List<PizzaEntity> findByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    List<PizzaEntity>findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description );
    List<PizzaEntity>findTop3AvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    int countByVeganTrue();

    @Query(value=
    "UPDATE Pizza"+
    "SET price = :#{#newPizzaPrice.newPrice}"+
            "WHERE id_pizza=:#{#newPizzaPrice.PizzaId}",nativeQuery=true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);
}
