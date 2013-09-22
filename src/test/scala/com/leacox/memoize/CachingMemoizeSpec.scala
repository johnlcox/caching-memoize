package com.leacox.memoize

import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.scalatest.matchers.ShouldMatchers
import com.leacox.memoize.cache.{SingleValueTTLCache, TTLCache}

/**
 * @author John Leacox
 */
class CachingMemoizeSpec extends FunSpec with MockitoSugar with ShouldMatchers {
  describe("CachingMemoize") {
    it("should do stuff") {
      def doStuff(a: String, b: String): String = {
        a + b
      }

      type Params = (String, String)
      lazy val cachedDoStuff = CachingMemoize(TTLCache[Params, String](10000))(doStuff)
      //lazy val cachedDoStuff = CachingMemoize(() => TTLCache(10000))(doStuff)

      System.out.println(cachedDoStuff("hello", "world"))
      System.out.println(cachedDoStuff("hello", "world"))
      System.out.println(cachedDoStuff("hello", "world"))

      Thread.sleep(10000)

      System.out.println(cachedDoStuff("hello", "world"))
    }

    it("should do stuff 0-arity") {
      def doStuff(): String = "hello" + "world"

      lazy val cachedDoStuff = CachingMemoize(SingleValueTTLCache[String](10000))(doStuff)

      System.out.println(cachedDoStuff())
    }
  }
}
