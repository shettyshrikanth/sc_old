package com.shopping

object Checkout extends App {

  def costOf(shoppingCart: ShoppingCart, offers: Offer*): BigDecimal = {
    val cart = applyOffers(shoppingCart.fruits, offers.toSeq);

    cart.map(_.price).sum
  }

  private def applyOffers(cart: Seq[Fruit], offers: Seq[Offer]): Seq[Fruit] = {

    offers match {
      case Nil => cart
      case offerList => applyOffers(offerList(0)(cart), offerList.splitAt(1)._2)
    }
  }
}