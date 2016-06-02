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
  
  
   "Buy 1 Apple, get 1 free" should {
    "cost 0.60 for 2 apples on offer" in {
      costOf(ShoppingCart(Apple, Apple), BuyOneGetOneFree("Apple")) mustEqual 0.60
    }

    "cost 1.20 for 3 apples on offer" in {
      costOf(ShoppingCart(Apple, Apple, Apple),BuyOneGetOneFree("Apple")) mustEqual 1.20
    }

  }

  "Buy 3 oranges, for the price of 2" should {
    "cost 0.50 for 3 oranges on offer" in {
      costOf(ShoppingCart(Orange, Orange, Orange),BuyThreeForThePriceOfTwo("Orange")) mustEqual 0.50
    }

    "cost 1.25 for 7 oranges on offer" in {
      costOf(ShoppingCart(Orange, Orange, Orange, Orange, Orange, Orange, Orange),BuyThreeForThePriceOfTwo("Orange")) mustEqual 1.25
    }
  }

  "Buy apples and oranges on offer" should {
    "cost 3.05 for 5 apples and 7 oranges" in {
      costOf(ShoppingCart(Apple, Apple, Apple, Apple, Apple, Orange, Orange, Orange, Orange, Orange, Orange, Orange),BuyOneGetOneFree("Apple"),BuyThreeForThePriceOfTwo("Orange")) mustEqual 3.05
    }
  }  
  
}
