package com.shopping

object Checkout {
  
  def costOf(shoppingCart: ShoppingCart, offers: Offer*): BigDecimal = {
    val cart = applyOffers(shoppingCart, offers.toSeq: _*);

    cart.map(_.price).sum
  }

  private def applyOffers(cart: ShoppingCart, offers: Offer*): Seq[Fruit] = {
    var fruitsList = cart.fruits

    if (offers.length > 0) {
      offers foreach (offer => { fruitsList = offer(fruitsList) })
    }
    fruitsList
  }
  
}