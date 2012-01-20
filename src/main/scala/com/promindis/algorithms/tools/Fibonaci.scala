package com.promindis.algorithms.tools

import Stream._

object Fibonaci {
  def suite: Stream[Int] = {
    def f(a: Int, b:Int): Stream[Int] = cons(a , f(b, a + b))
    f(0, 1)
  }
}

