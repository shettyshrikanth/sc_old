package com.shopping

import org.specs2.mutable.Specification
import Checkout._

class CheckoutTest extends Specification {
  "Shopping cart" should {
    "cost nothing when there are no items" in {
      costOf(ShoppingCart()) mustEqual 0.00
    }
    
    "cost 60p for 1 apple" in {
      costOf(ShoppingCart(Apple)) mustEqual 0.60
    }

    "cost 25p for 1 orange" in {
      costOf(ShoppingCart(Orange)) mustEqual 0.25
    }

    "cost 85p for 1 apple and 1 orange" in {
      costOf(ShoppingCart(Apple, Orange)) mustEqual 0.85
    }
    
     "cost 2.20 for 2 apple and 4 orange" in {
      costOf(ShoppingCart(Apple,Apple, Orange,Orange,Orange,Orange)) mustEqual 2.20
    }
  }
}
