package com.promindis.algorithms.sorting

import collection.SeqLike
import collection.generic.CanBuildFrom


object QuickSort {
  def baseSort[A <% Ordered[A]] (seq: Iterable[A]): Iterable[A] = {
    if (seq.size < 2) seq
    else {
      val pivot =  seq.head
      baseSort(seq.filter(_ < pivot)) ++ seq.filter(_ == pivot) ++ baseSort(seq.filter(_ > pivot))
    }
  }

  def sort[A, Coll] (seq: Coll)(implicit ev0 : Coll <:< SeqLike[A, Coll], cbf: CanBuildFrom[Coll, A, Coll], f: A => Ordered[A]): Coll = {
    if (seq.size < 2) seq
    else {
      val pivot =  seq.head
      val (lower: Coll, tmp : Coll) = seq.partition(_ < pivot)
      val (upper: Coll , same: Coll) = seq.partition(_ > pivot)

      val b = cbf()
      b.sizeHint(seq.size)
      b ++= sort(lower)
      b ++= same
      b ++= sort(upper)
      b.result()

    }
  }


  def main(arguments: Array[String]) {
    println(baseSort(Range(1, 10).reverse))
    println(baseSort(Range(1, 10).reverse))
  }
}