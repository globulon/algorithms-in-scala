package com.promindis.algorithms.tools

import org.specs2.Specification


final class PrimesSpecification extends Specification{ def is =

  "Primes specification" ^
  p^
  "is Prime should" ^
  "recognize 2 as prime " ! e1 ^
  "recognize 3 as prime " ! e2 ^
  "recognize 5 as prime " ! e3 ^
  "recognize known numbers as prime " ! e4 ^
  "recognize known numbers as not prime " ! e5^
  p^
  " suite should " ^
  "provide the first terms of prime numbers" ! e6


  def e1 = {
    import Primes._
    isPrime(2) should(beTrue)
  }

  def e2 = {
    import Primes._
    isPrime(3) should(beTrue)
  }

  def e3 = {
    import Primes._
    isPrime(5) should(beTrue)
  }

  def e4 = {
    import Primes._
    List(11, 13, 17, 19).filter(isPrime(_)).size.should(beEqualTo(4))
  }

  def e5 = {
    import Primes._
    List(9, 12, 15, 18, 27).filter(isPrime(_)).size.should(beEqualTo(0))
  }

  def e6 = {
    import Primes._
    suite.take(5).should(beEqualTo(List(2, 3, 5, 7, 11)))
  }
}