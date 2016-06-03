package com.shopping

import scala.reflect.ClassTag

object Checkout extends App {

  def costOf(shoppingCart: ShoppingCart, offers: Offer*): BigDecimal = {
    val cart = applyOffers(shoppingCart.fruits, offers.toSeq);

    cart.map(_.price).sum
  }

  private def applyOffers(cart: Seq[Fruit], offers: Seq[Offer]): Seq[Fruit] = {

    offers match {
      case Nil => cart
      case offerList =>
        applyOffers(      //recursive call
          offerList(0) match {
            case offer: BuyOneGetOneFree => offer(cart, 2)
            case offer: BuyThreeForThePriceOfTwo => offer(cart, 3)
          }, offerList.splitAt(1)._2)
    }
  }
}