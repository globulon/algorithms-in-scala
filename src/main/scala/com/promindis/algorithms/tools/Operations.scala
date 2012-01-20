package com.promindis.algorithms.tools

import java.math.BigInteger


object Operations {
  def factorialOf(number: Int): BigInt = {
    def factorial(accumulator: BigInt, current: BigInt): BigInt = {
      if (current == 1) accumulator
      else {
        factorial(accumulator * current, current - 1)
      }
    }
    factorial(new BigInt(new BigInteger("1")), new BigInt(new BigInteger(number.toString)))
  }
}