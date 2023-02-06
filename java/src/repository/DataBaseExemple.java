package repository;

import model.Item;
import model.Order;
import model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseExemple {

     private static DataBaseExemple dataBaseExemple;
     private List<Order> orders;
     private DateTimeFormatter formatter;

     public static DataBaseExemple getDataBaseExemple(){
         if(Objects.isNull(dataBaseExemple)){
             dataBaseExemple = new DataBaseExemple();
         }
         return dataBaseExemple;
     }

    private DataBaseExemple() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.orders = setExemples();
    }

    public List<Order> getOrdesForTest(){
        return this.orders;
     }

     private List<Order> setExemples(){
        List<Order> list = new ArrayList<>();

        for( Item item : getItemExemples()){
            for(int aux = 200, ano = 2017; ano < 2022;ano++, aux-=50){
                List<Item> listaExemplo = new ArrayList<Item>();
                listaExemplo.add(item);
                list.add(new Order(listaExemplo, "name exemple", "email@exemple.com", "street exemple, 01", item.getCost(),LocalDateTime.parse(ano+"-01-01 08:00", this.formatter)));
            }
        }
        return list;
     }

     private List<Item> getItemExemples(){
         List<Item> itemList = new ArrayList<Item>();

         for(Product produto : getProductExemples()){
             itemList.add(new Item(produto, produto.getPrice()*1.10 , 0, 15));
         }

         return itemList;

     }

     private List<Product> getProductExemples(){

         List<Product> productList = new ArrayList<Product>();

         productList.add(new Product("Television", "eletronico", 2.41, 200, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("Chrome Cast", "eletronico", 0.22, 34, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("JBL Audio Pro", "eletronico", 0.73, 70, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("Leather sofa", "movel", 4.01, 150, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("Quartz Table", "movel", 3.30, 80, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("Oak armchair", "movel", 2.78, 40, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));
         productList.add(new Product("Oak bed", "movel", 4.11, 120, LocalDateTime.parse("2017-08-10 08:21", this.formatter)));

         return productList;
     }

}
