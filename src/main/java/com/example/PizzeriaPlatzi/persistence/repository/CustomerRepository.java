package com.example.PizzeriaPlatzi.persistence.repository;

import com.example.PizzeriaPlatzi.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository  extends ListCrudRepository<CustomerEntity,String> {

    @Query(value="SELECT * FROM CustomerEntityc where c.phoneNumer :phone")
    CustomerEntity findByPhone(@Param("phone")String phone) ;
}
