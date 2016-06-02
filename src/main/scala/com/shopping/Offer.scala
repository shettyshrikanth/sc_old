package com.shopping

sealed trait Offer {
  val item: String
  def applyOffer(f: Seq[Fruit]): Seq[Fruit]
}

case class BuyOneGetOneFree(item: String) extends Offer {
  def applyOffer(fruits: Seq[Fruit]): Seq[Fruit] = {
    fruits.filter(_.name == item).zip(Stream from 1).filter(_._2 % 2 != 0).map(_._1) ++ fruits.filter(_.name != item)
  }
}

case class BuyThreeForThePriceOfTwo(item: String) extends Offer {
  def applyOffer(fruits: Seq[Fruit]): Seq[Fruit] = {
    fruits.filter(_.name == item).zip(Stream from 1).filter(_._2 % 3 != 0).map(_._1) ++ fruits.filter(_.name != item)
  }
}
