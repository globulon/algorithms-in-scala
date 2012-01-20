package com.promindis.algorithms.tools


object CollatzNumber {

  def nextFrom(value: Long): Long = {
    if ((value & 1) == 0) ( value / 2)
    else ((3 * value)  + 1)
  }

  def suiteFor(number: Long):List[Long] = {
    @annotation.tailrec
    def suiteFor(newValue: Long, results: List[Long]): List[Long] = {
      newValue match {
        case value if (value <=  1) => results
        case _ => suiteFor(nextFrom(newValue), nextFrom(newValue)::results)
      }
    }

    suiteFor(number, List[Long](number))
  }


}