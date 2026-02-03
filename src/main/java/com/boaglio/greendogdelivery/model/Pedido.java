package com.boaglio.greendogdelivery.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> itens = new ArrayList<>();

    private Date data;
    private Double valorTotal;

    public Pedido() {
        this.data = new Date();
    }

    public Pedido(Cliente cliente, List<Item> itens, Double valorTotal) {
        this();
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public List<Item> getItens() { return itens; }
    public void setItens(List<Item> itens) { this.itens = itens; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
}