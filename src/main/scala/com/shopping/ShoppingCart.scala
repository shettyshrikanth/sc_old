package com.shopping

case class ShoppingCart(fruits: Fruit*)

sealed trait Fruit {
  val name: String
  val price: BigDecimal
}