package com.promindis.algorithms.tools

import org.specs2.Specification


class CollatzNumberSpecification extends Specification{ def is =
  "CollatzNumber Specification"^
  p^
  "suite should"^
  "Find match for 13" ! e1


  def e1 = {
    CollatzNumber.suiteFor(13).should(beEqualTo(List(1,2,4,8,16,5,10,20,40,13)))
  }


}