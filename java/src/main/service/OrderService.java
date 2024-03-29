package main.service;

import main.model.Order;
import main.repository.DataBaseExemple;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private DataBaseExemple repository;

    public OrderService() {
        this.repository = DataBaseExemple.getDataBaseExemple();
    }

    public List<Order> getOrdersByDataAndProduct(LocalDateTime datainicio, LocalDateTime dataFim, String productName){
        List<Order> lista = repository.getOrdesForTest();
        List<Order> listaFiltradaPorProduto = lista.stream().filter(order -> order.getItemList().stream().allMatch(item -> item.getProduto().getName().equals(productName))).toList();
        return listaFiltradaPorProduto.stream().filter(order -> order.getCreateDate().isAfter(datainicio) && order.getCreateDate().isBefore(dataFim)).collect(Collectors.toList());
    }
}
