package repository

import model.{Item, Order, Product}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DatabaseExemple {

    private var orders: List[Order] = Nil
    private var itens: List[Item] = Nil
    private var products: List[Product] = Nil
    private var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    def constructor(): Unit = {
      setProductExemples()
      setItemExemples()
      setOrderExemples()
    }

    def getOdersForTest: List[Order] = orders

    private def setOrderExemples(): Unit = {
        for(item <- itens){
          val aux = List(200, 150, 100, 50)
          val anos = List(2017, 2018, 2019, 2020)
          for(contador <- aux; ano <- anos){
            for(elementos <- 0 to contador){
              val itensExemplo = List(item)
              val order = new Order
              order.constructor(itensExemplo, "Nome Exemplo", "email@exemplo.com", "Rua de exemplo, 01, Brazil", item.getCost, LocalDateTime.parse(ano+"-01-01 08:00", formatter))
              orders = orders :+ order
            }
          }
        }
    }

    private def setItemExemples(): Unit = {
       for(product <- products){
         val item = new Item
         item.constructor(product, product.getPrice+0.5, 0.0, 0.0)
         itens = itens :+ item
       }
    }

    private def setProductExemples(): Unit = {
       val television = new Product
       television.constructor("Television", "Eletronico", 2.41, 200.0, LocalDateTime.parse("2017-08-10 08:21", formatter))

       products = products :+ television
    }
}
