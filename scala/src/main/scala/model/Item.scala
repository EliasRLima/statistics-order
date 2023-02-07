package model

class Item {

  private var product: Product = new Product
  private var cost = .0
  private var tax = .0
  private var shipping = .0

  def constructor(newProduct: Product, newCost: Double, newTax: Double, newShipping: Double): Unit = {
      product = newProduct
      cost = newCost
      tax = newTax
      shipping = newShipping
  }

  def setProduct(newProduct: Product): Unit = {
     product = newProduct
  }
  def getProduct: Product = product

  def setCost(newCost: Double): Unit = {
    cost = newCost
  }
  def getCost: Double = cost

  def setTax(newTax: Double): Unit = {
    tax = newTax
  }
  def getTax: Double = tax

  def setShipping(newShipping: Double): Unit = {
    shipping = newShipping
  }
  def getShipping: Double = shipping

}
