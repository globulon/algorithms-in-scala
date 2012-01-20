package com.promindis.algorithms.euler

import scala.io.Source._
import com.promindis.algorithms.tools.{Operations, CollatzNumber, Primes, Fibonaci}


object Problems {
  def problemOne = {
    Range(1, 1000).filter(number =>   {
      ((number % 3) == 0) || ((number % 5) == 0)
    }).foldLeft(0){_ + _}
  }

  def problemTwo = {
    Fibonaci.suite
      .takeWhile{value => value < 4e6}
        .filter{value => (value & 1) == 0}
          .foldLeft(0) {_ + _}
  }

  def problemSeven = {
    Primes.suite
      .drop(10000)
        .take(1)
  }

  def problemSevenBis = {
    Primes.suite
      .drop(10000)
        .take(1)
  }

  def problemTen = {
    Primes.suite
      .takeWhile{value => value < 2000000}
          .foldLeft(0L) {_ + _}
  }

  def data = "/dev/projects/scala/algorithms/data"

  def problemThirteen = {
    val suffixes = fromFile(data).getLines()
    val numbers = suffixes.map(str => new BigInt(new java.math.BigInteger(str)))
    numbers.foldLeft(new BigInt(new java.math.BigInteger("0"))) {_+_}
  }

  def problemFourteen = {
     val results = Range(1, 1000000)
       .map(input => (input, CollatzNumber.suiteFor(input).size))
        .sortBy(_._2)
    results(results.length - 1)
  }

  def problemFifthTeen() = {
    //Each movement in the horizontal is a zero.
    //Each movement in the vertical is a one.
    //
    //1st binary# in this series:
    //0000000000000000000011111111111111111111
    //last:
    //1111111111111111111100000000000000000000
    //For the numbers in between, the amount of
    // zeros should be the same as ones
    Operations.factorialOf(40) / (Operations.factorialOf(20) * Operations.factorialOf(20))
  }


  def main(arguments: Array[String]) {
//    println("problem one: " + problemOne)
//    println("problem Two: " + problemTwo)
//    println("problem Seven: " + problemSeven)
//    println("problem SevenBis: " + problemSevenBis)
//    println("problem Ten: " + problemTen)
//    println("problem Thirteen: " + problemThirteen)
    println("problem Fourteen: " + problemFourteen)
    println("problem Fithteen: " + problemFifthTeen)
  }
}