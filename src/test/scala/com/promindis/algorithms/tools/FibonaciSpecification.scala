package com.promindis.algorithms.tools

import org.specs2.Specification


final class FibonaciSpecification extends Specification{ def is =
  "Fibonaci specification" ^
  p^
  "Fibonaci suite " ^
  "should expose the first two numbers" ! e1 ^
  "expose the number less than a hundred" ! e2


  def e1 = {
    Fibonaci.suite.head should(beEqualTo(0))
  }


  def e2 = {
    Fibonaci.suite.takeWhile{value => value < 100}.size should(beEqualTo(12))
  }
}