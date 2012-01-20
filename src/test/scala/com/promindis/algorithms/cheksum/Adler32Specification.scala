package com.promindis.algorithms.cheksum

import org.specs2.Specification


class Adler32Specification extends Specification { def is =
  "Adler32Specification"   ^
                          p^
    "checksum for input"   ^
    "Should restore the expected checksum value" !e1


  def e1 =
    new DefaultAdler32()
      .checksumText("Thumper is a cute rabbit".toCharArray)
      .should(beEqualTo(1839204552))
}