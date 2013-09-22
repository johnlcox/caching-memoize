package com.leacox.memoize.cache

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito.{verify, when}
import scala.collection.mutable
import com.leacox.memoize.cache.TTLCache

/**
 * @author John Leacox
 */
class TTLCacheSpec extends FunSpec with MockitoSugar with ShouldMatchers {
  describe("TTLCache") {
    it("should return None for a missing key") {
      val cache = TTLCache[String, String](1)

      cache.get("key") should be(None)
    }

    it("should return an un-expired cache value") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }
      val cache = TTLCache[String, String](2, clock)

      cache.put("key", "value")
      cache.get("key") should equal(Some("value"))
    }

    it("should not return an expired cache value") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }
      val cache = TTLCache[String, String](1, clock)

      cache.put("key", "value")
      cache.get("key")
      cache.get("key") should be(None)
    }

    it("should remove expired key and return None") {
      var i: Long = 0
      def clock = () => {
        i += 1
        i
      }
      val backingMap = mock[mutable.Map[String, (Long, String)]]
      when(backingMap.get("key")).thenReturn(Some((0L, "value")))
      val cache = TTLCache[String, String](1, clock, backingMap)

      cache.get("key") should be(None)

      verify(backingMap).remove("key")
    }
  }
}
