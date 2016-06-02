package com.shopping

import org.specs2.mutable.Specification

class CheckoutSpec extends Specification {
  "Shopping cart" should {
    "cost nothing when there are no items" in {
      costOf(ShoppingCart()) mustEqual 0.00
    }
  }
}