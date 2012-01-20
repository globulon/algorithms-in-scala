package com.promindis.algorithms.graphs

/**
 * Created by IntelliJ IDEA.
 * User: mortega
 * Date: 13/10/11
 * Time: 13:17
 */



object Grid {

  def newPathsFrom(path: (Int, Int), withinBoundary: Int): List[(Int, Int)] = {
    neighboursOf(path, withinBoundary)
      .map(vertex => vertex)
  }


  def neighboursOf(vertex: (Int, Int), withinBoundary: Int): List[(Int, Int)] = {
    vertex match {
      case v if (vertex._1 + 1 < withinBoundary) && (vertex._2 + 1 < withinBoundary) =>
        List((vertex._1 + 1, vertex._2), (vertex._1, vertex._2 + 1))
      case v if (vertex._1 + 1 < withinBoundary) =>
        List((vertex._1 + 1, vertex._2))
      case v if (vertex._2 + 1 < withinBoundary) =>
        List((vertex._1 , vertex._2 + 1))
      case _ => Nil
    }
  }


  def allPathsToLayer(depth: Int, withinBoundary: Int): List[(Int, Int)] = {
    @annotation.tailrec
    def pathsFrom(paths: List[(Int, Int)], remaining: Int):List[(Int, Int)] = {
      if (remaining == 0)
        paths
      else
        pathsFrom(paths.map(newPathsFrom(_, withinBoundary)).flatten, remaining - 1)
    }

    pathsFrom(List((0, 0)), depth)
  }

  def main (arguments: Array[String]) = {
    println(allPathsToLayer(4, 4).size)
  }
}