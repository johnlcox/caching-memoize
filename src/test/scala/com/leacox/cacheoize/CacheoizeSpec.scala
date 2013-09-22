package com.leacox.cacheoize

import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.scalatest.matchers.ShouldMatchers
import com.leacox.memoize.cache.TTLCache

/**
 * @author John Leacox
 */
class CacheoizeSpec extends FunSpec with MockitoSugar with ShouldMatchers {
  describe("Cacheoize") {
    it("should do stuff") {
      def doStuff(a: String, b: String): String = {
        a + b
      }

      type Params = (String, String)
      lazy val cachedDoStuff = Cacheoize(TTLCache[Params, String](10000))(doStuff)
      //lazy val cachedDoStuff = Cacheoize(() => TTLCache(10000))(doStuff)

      System.out.println(cachedDoStuff("hello", "world"))
      System.out.println(cachedDoStuff("hello", "world"))
      System.out.println(cachedDoStuff("hello", "world"))

      Thread.sleep(10000)

      System.out.println(cachedDoStuff("hello", "world"))
    }
  }
}
