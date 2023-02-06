package service;

import model.Order;
import model.Product;
import repository.DataBaseExemple;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private DataBaseExemple repository;

    public OrderService() {
        this.repository = DataBaseExemple.getDataBaseExemple();
    }

    public List<Order> getOrdersByDataAndProduct(LocalDateTime datainicio, LocalDateTime dataFim, Product product){
        List<Order> lista = repository.getOrdesForTest();
        List<Order> listaFiltradaPorProduto = lista.stream().filter(order -> order.getItemList().stream().anyMatch(item -> item.getProduto().getName().equals(product.getName()))).toList();
        return listaFiltradaPorProduto.stream().filter(order -> order.getCreateDate().isAfter(datainicio) && order.getCreateDate().isBefore(dataFim)).collect(Collectors.toList());
    }
}
