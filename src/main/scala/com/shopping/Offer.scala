package com.shopping

sealed trait Offer {
  self: Offer =>
  val item: String
  val size: Int
  
  def apply (fruits: Seq[Fruit]) : Seq[Fruit] = {
    fruits.filter(_.name == item).zip(Stream from 1).filter(_._2 % size != 0).map(_._1) ++ fruits.filter(_.name != item)
  }  
}

case class BuyOneGetOneFree(item: String, size:Int = 2) extends Offer

case class BuyThreeForThePriceOfTwo(item: String, size:Int = 3) extends Offer
