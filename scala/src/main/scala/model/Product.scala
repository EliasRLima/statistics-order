package model

import java.time.LocalDateTime

class Product {

  private var name = ""
  private var category = ""
  private var weight = .0
  private var price = .0
  private var creationDate = LocalDateTime.now()

  def constructor(newName: String, newCategory: String, newWeight: Double, newPrice: Double, newCreationDate : LocalDateTime): Unit = {
     name = newName
     category = newCategory
     weight = newWeight
     price = newPrice
     creationDate = newCreationDate
  }

  def setName(newName: String): Unit = {
    name = newName
  }
  def getName: String = name

  def setCategory(newCategory: String): Unit = {
    category = newCategory
  }
  def getCategory: String = category

  def setWeight(newWeight: Double): Unit = {
    weight = newWeight
  }
  def getWeight: Double = weight

  def setPrice(newPrice: Double): Unit = {
    price = newPrice
  }
  def getPrice: Double = price

  def setCreationDate(newCreationDate: LocalDateTime): Unit = {
    creationDate = newCreationDate
  }
  def getCreationDate: LocalDateTime = creationDate
}
