package com.leacox.memoize.cache

import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable
import org.mockito.Mockito._
import scala.Some

/**
 * @author John Leacox
 */
class SingleValueTTLCacheSpec extends FunSpec with MockitoSugar with ShouldMatchers {
  describe("SingleValueTTLCache") {
    it("should return None for no value") {
      val cache = SingleValueTTLCache[String](1)

      cache.get() should be(None)
    }

    it("should return an un-expired cache value") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }
      val cache = SingleValueTTLCache[String](2, clock)

      cache.put("value")
      cache.get() should equal(Some("value"))
    }

    it("should not return an expired cache value") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }
      val cache = SingleValueTTLCache[String](1, clock)

      cache.put("value")
      cache.get()
      cache.get() should be(None)
    }

    it("should remove expired value and return None") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }

      val option = Some((0L, "value"))
      val cache = SingleValueTTLCache[String](1, clock, option)

      cache.get() should be(None)
    }
  }

}
