package com.shopping

object Checkout {
  def costOf(shoppingCart: ShoppingCart): BigDecimal = {
     shoppingCart.fruits.map(_.price).sum
  }
}