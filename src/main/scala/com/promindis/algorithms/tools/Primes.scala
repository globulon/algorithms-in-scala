package com.promindis.algorithms.tools
import scala.math._
import Stream._


object Primes {

  def isPrimeForm(value: Long): Boolean = {
    val square = floor(sqrt(value));
    def findPrime(from: Long = 5): Boolean ={
      from match {
        case current if current > square => true
        case current if ((value % current) == 0) => false
        case current if ((value % (current + 2)) == 0) => false
        case _  => findPrime(from + 6)
      }
    }
    findPrime()
  }

  def isPrime(value: Long): Boolean = {
    value match {
      case 2 => true
      case 3 => true
      case even if ((even & 1) == 0) => false
      case odd if ((odd % 3) == 0) => false
      case _ => isPrimeForm(value)
    }
  }

  sealed trait PrimeSuite {
    @annotation.tailrec
    final def nextPrime(value: Long): Long = {
      if (isPrime(value + 2)) (value + 2)
      else nextPrime(value + 2)
    }
  }

  def suite: Stream[Long] = new PrimeSuite {
    def f(value: Long): Stream[Long] = value#::f(nextPrime(value))
    def create: Stream[Long] = cons(2, cons(3, f(5)))
  }.create


  def suite2: Traversable[Long] = new Traversable[Long] with PrimeSuite{
    def foreach[U](f: Long => U){
      @annotation.tailrec
      def next(first: Long, second: Long) {
        f(first)
        next(second, nextPrime(second))
      }
      next(2, 3)
    }
  }.view

}