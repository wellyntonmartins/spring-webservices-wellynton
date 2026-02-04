package com.wellyntonmartins.wellyntonservices.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wellyntonmartins.wellyntonservices.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity // Define que essa classe e uma entidade do banco de dados (table)
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id // Define que o atributo abaixo e uma coluna de Id da entidade (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que e um valor auto-generativo (auto_increment)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne // Define que essa classe (Order) tem uma associacao de "muitos pra um" com a classe do atributo/objeto
    // User abaixo (foreign key)
    @JoinColumn(name = "client_id") // Define um nome para a coluna de chave estrangeira
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
