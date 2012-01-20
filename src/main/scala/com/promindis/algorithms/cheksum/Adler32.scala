package com.promindis.algorithms.cheksum

trait Adler32 {
  val base = 65521

  def rebased(value: Int) = value % base

  def cumulated(acc: (Int, Int), item : Byte): (Int, Int) = {
    val a = rebased(acc._1 + (item & 0xff ))
    (a, (a + acc._2) % base)
  }

  def checksum(data: Traversable[Byte]): Int

  def checksumText(data: Traversable[Char]): Int
}


final class DefaultAdler32 extends Adler32 {

  override def checksum(data: Traversable[Byte]): Int = {
    val result = data.foldLeft((1, 0)) {cumulated(_, _)}
    (result._2 << 16) | result._1
  }

  def checksumText(data: Traversable[Char]) = {
    checksum(data.toSeq.map(_.toByte))
  }
}


