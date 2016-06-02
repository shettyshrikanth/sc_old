package com.shopping

case class ShoppingCart(fruits: Fruit*)

sealed trait Fruit {
  val name: String
  val price: BigDecimal
}

case object Apple extends Fruit {
  val name = "Apple"
  val price = BigDecimal(0.60)
}

case object Orange extends Fruit {
  val name = "Orange"
  val price = BigDecimal(0.25)
}