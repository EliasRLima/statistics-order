package model

import java.time.LocalDateTime

class Order {

  private var itemList: List[Item] = Nil
  private var customerName: String = ""
  private var contact: String = ""
  private var shippingAddres: String = ""
  private var grandTotal = .0
  private var createDate: LocalDateTime = LocalDateTime.now()

  def constructor(newItemList: List[Item], newCustomerName: String, newContact: String, newShippingAddres: String, newGrandTotal: Double, newCreateDate: LocalDateTime): Unit = {
    itemList = newItemList
    customerName = newCustomerName
    contact = newContact
    shippingAddres = newShippingAddres
    grandTotal = newGrandTotal
    createDate = newCreateDate
  }

  def addItem(newItem: Item): Unit = {
    itemList = itemList :+ newItem
  }
  def setItemList(newItemList: List[Item]): Unit = {
     itemList = newItemList
  }
  def getItemList: List[Item] = itemList

  def setCustomerName(newCustomerName: String): Unit = {
    customerName = newCustomerName
  }
  def getCustumerName: String = customerName

  def setContact(newContact: String): Unit = {
    contact = newContact
  }
  def getContact: String = contact

  def setShippingAddres(newShippingAddres: String): Unit = {
    shippingAddres = newShippingAddres
  }
  def getShippingAddres: String = shippingAddres

  def setGrandTotal(newTotal: Double): Unit = {
    grandTotal = newTotal
  }
  def getGrandTotal: Double = grandTotal

  def setCreateDate(newCreateDate: LocalDateTime): Unit = {
    createDate = newCreateDate
  }
  def getCreateDate: LocalDateTime = createDate
}
