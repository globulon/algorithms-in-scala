package com.promindis.algorithms.tools

import org.specs2.Specification
import Operations._
/**
 * Created by IntelliJ IDEA.
 * User: mortega
 * Date: 14/10/11
 * Time: 13:06
 */

class OperationSpecification extends Specification{ def is =
  "Operation specifications"              ^
                                          p^
  "Factorial should"                      ^
  "find 1 for 1"                          ! e1 ^
  "find 2 for 2"                          ! e2 ^
  "find 720 for 6"                        ! e3




  def e1 = factorialOf(1).should(beEqualTo(1))

  def e2 = factorialOf(2).should(beEqualTo(2))

  def e3 = factorialOf(6).should(beEqualTo(720))

}