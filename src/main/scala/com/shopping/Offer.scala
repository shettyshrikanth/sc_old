package com.shopping

sealed trait Offer {
  self: Offer =>
  val item: String
  
  def apply (fruits: Seq[Fruit], offer:Int) : Seq[Fruit] = {
    fruits.filter(_.name == item).zip(Stream from 1).filter(_._2 % offer != 0).map(_._1) ++ fruits.filter(_.name != item)
  }  
}

case class BuyOneGetOneFree(item: String) extends Offer

case class BuyThreeForThePriceOfTwo(item: String) extends Offer
