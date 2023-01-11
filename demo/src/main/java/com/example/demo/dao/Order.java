package com.example.demo.dao;

import com.example.demo.business.OrderState;
import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="type_presta")
    private String typePresta;
    private String designation;
    @Column(name="nb_pays")
    private Integer nbPays;
    @Column(name="unitprice")
    private Integer unitPrice;
    private OrderState state;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    //Constructeur

    public Order() {
    }

    public Order(String typePresta, String designation, Integer nbPays,
                 Integer unitPrice, OrderState state, Client client) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbPays = nbPays;
        this.unitPrice = unitPrice;
        this.state = state;
        this.client = client;
    }

    //Getters

    public Integer getId() {
        return id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public Integer getNbPays() {
        return nbPays;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public OrderState getState() {
        return state;
    }

    public Client getClient() {
        return client;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setNbPays(Integer nbPays) {
        this.nbPays = nbPays;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    //ToString

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbPays=" + nbPays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                ", client=" + client +
                '}';
    }
}
