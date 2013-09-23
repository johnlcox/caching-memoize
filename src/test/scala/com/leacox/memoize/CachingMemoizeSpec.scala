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
    describe("for 0-arity") {
      it("should return cached value instead of executing the memoize function when the cache has not expired") {
        var executionCount: Int = 0
        def aFunc(): String = {
          executionCount += 1
          "hello" + "world"
        }

        lazy val cachedAFunc = CachingMemoize(SingleValueTTLCache[String](10000))(aFunc)

        cachedAFunc() should equal("helloworld")
        cachedAFunc() should equal("helloworld")

        executionCount should be(1)
      }

      it("should re-execute the memoized function when the cached value has expired") {
        var executionCount: Int = 0
        def aFunc(): String = {
          executionCount += 1
          "hello" + "world"
        }

        val expiringCache = SingleValueTTLCache[String](1, tickerClock)

        lazy val cachedAFunc = CachingMemoize(expiringCache)(aFunc)

        cachedAFunc() should equal("helloworld")
        cachedAFunc() should equal("helloworld")
        cachedAFunc() should equal("helloworld")

        executionCount should be(2)
      }
    }

    describe("for 1-arity") {
      it("should return cached value instead of executing the memoize function when the cache has not expired") {
        var executionCount: Int = 0
        def aFunc(a: String): String = {
          executionCount += 1
          a
        }

        lazy val cachedAFunc = CachingMemoize(TTLCache[String, String](10000))(aFunc)

        cachedAFunc("a") should equal("a")
        cachedAFunc("a") should equal("a")

        executionCount should be(1)
      }

      it("should re-execute the memoized function when the cached value has expired") {
        var executionCount: Int = 0
        def aFunc(a: String): String = {
          executionCount += 1
          a
        }

        val expiringCache = TTLCache[String, String](1, tickerClock)

        lazy val cachedAFunc = CachingMemoize(expiringCache)(aFunc)

        cachedAFunc("a") should equal("a")
        cachedAFunc("a") should equal("a")
        cachedAFunc("a") should equal("a")

        executionCount should be(2)
      }
    }

    describe("for 2-arity") {
      type Params = (String, String)

      it("should return cached value instead of executing the memoize function when the cache has not expired") {
        var executionCount: Int = 0
        def aFunc(a: String, b: String): String = {
          executionCount += 1
          a + b
        }

        lazy val cachedAFunc = CachingMemoize(TTLCache[Params, String](10000))(aFunc)

        cachedAFunc("a", "b") should equal("ab")
        cachedAFunc("a", "b") should equal("ab")

        executionCount should be(1)
      }

      it("should re-execute the memoized function when the cached value has expired") {
        var executionCount: Int = 0
        def aFunc(a: String, b: String): String = {
          executionCount += 1
          a + b
        }

        val expiringCache = TTLCache[Params, String](1, tickerClock)

        lazy val cachedAFunc = CachingMemoize(expiringCache)(aFunc)

        cachedAFunc("a", "b") should equal("ab")
        cachedAFunc("a", "b") should equal("ab")
        cachedAFunc("a", "b") should equal("ab")

        executionCount should be(2)
      }
    }


    //    it("should do stuff") {
    //      def doStuff(a: String, b: String): String = {
    //        a + b
    //      }
    //
    //      type Params = (String, String)
    //      lazy val cachedDoStuff = CachingMemoize(TTLCache[Params, String](10000))(doStuff)
    //      //lazy val cachedDoStuff = CachingMemoize(() => TTLCache(10000))(doStuff)
    //
    //      System.out.println(cachedDoStuff("hello", "world"))
    //      System.out.println(cachedDoStuff("hello", "world"))
    //      System.out.println(cachedDoStuff("hello", "world"))
    //
    //      Thread.sleep(10000)
    //
    //      System.out.println(cachedDoStuff("hello", "world"))
    //    }
    //
    //    it("should do stuff 0-arity") {
    //      def doStuff(): String = "hello" + "world"
    //
    //      lazy val cachedDoStuff = CachingMemoize(SingleValueTTLCache[String](10000))(doStuff)
    //
    //      System.out.println(cachedDoStuff())
    //    }
  }

  private[this] def tickerClock: () => Long = {
    var i: Long = 0
    def clock = () => {
      i += 1
      i
    }
    clock
  }
}
