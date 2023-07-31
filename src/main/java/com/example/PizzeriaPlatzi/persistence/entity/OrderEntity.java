package com.example.PizzeriaPlatzi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="pizza_order")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order",nullable = false)
    private Integer idOrder;

    @Column(name="id_costumer",nullable = false,length = 15)
    private String idConsumer;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(nullable = false,columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false,columnDefinition = "CHAR(1)")
    private String method;


    @Column(name="additional_notes",length = 200)
    private String additionalNotes;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_costumer",referencedColumnName="id_consumer",insertable=false,updatable=false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToOne(mappedBy = "order",fetch=fetchType.EAGER)
    @OrderBy("price DESC")

    private List<OrderItemEntity> items;


}
