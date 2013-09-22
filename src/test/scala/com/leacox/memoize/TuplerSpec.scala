package com.leacox.memoize

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * @author John Leacox
 */
class TuplerSpec extends FunSpec with ShouldMatchers {
  describe("Tupler") {
    describe("#untupled") {
      it("should transform a 2-tuple into a function of 2 arguments") {
        def tupledFunc(tuple: (String, String)): String = tuple._1 + tuple._2

        def untupledFunc: (String, String) => String = Tupler.untupled(tupledFunc)

        untupledFunc("a", "b") should equal("ab")
      }

      it("should transform a 3-tuple into a function of 3 arguments") {
        def tupledFunc(tuple: (String, String, String)): String = tuple._1 + tuple._2 + tuple._3

        def untupledFunc: (String, String, String) => String = Tupler.untupled(tupledFunc)

        untupledFunc("a", "b", "c") should equal("abc")
      }
    }
  }
}
