package com.promindis.algorithms.graphs

import org.specs2.Specification
import Grid._
/**
 * Created by IntelliJ IDEA.
 * User: mortega
 * Date: 13/10/11
 * Time: 13:27
 */

final class GridSpecification extends Specification{ def is =

  "Grid specifications"                               ^
                                                      p^
  "neighbours from vertex within boundaries should"   ^
  "be two"                                            ! e1 ^
  "contain horizontal neighbour"                      ! e2 ^
  "contain vertical neighbour"                        ! e3 ^
                                                      p^
  "neighbours from vertex at limit boundaries should" ^
  "contain vertical boundary only"                    ! e4 ^
  "contain horizontal boundary only"                  ! e5 ^
                                                      p^
  "Paths from vertex"                                 ^
  " should be two"                                    ! e6^
  " should contain horizontal path ext"               ! e7^
  " should contain vertical path ext"                 ! e8^
                                                      p^
  "all Paths should"                                  ^
  "be 2 up to 2"                                      ! e9 ^
  "be 6 up to 5"                                      ! e10
//  "be ?? up to 20"                                    ! e11

  def e1 = neighboursOf((0,0), 2).size.should(beEqualTo(2))

  def e2 = neighboursOf((0,0), 2).should(contain((1 ,0)))

  def e3 = neighboursOf((0,0), 2).should(contain((0 ,1)))

  def e4 = {
    neighboursOf((0,3), 4).size.should(beEqualTo(1))
    neighboursOf((0,3), 4).should(contain((1,3)))
  }

  def e5 = {
    neighboursOf((3,0), 4).size.should(beEqualTo(1))
    neighboursOf((3,0), 4).should(contain((3,1)))
  }

  def e6 = newPathsFrom((0,1), 3).size.should(beEqualTo(2))

  def e7 = newPathsFrom((0,1), 3).should(contain((1,1)))

  def e8 = newPathsFrom((0,1), 3).should(contain((0,2)))

  def e9 = {
    println(allPathsToLayer(2, 2))
    allPathsToLayer(2, 2).size.should(beEqualTo(2))
  }

 def e10 = {
    println(allPathsToLayer(4, 3))
    allPathsToLayer(4, 3).size.should(beEqualTo(6))
  }

}