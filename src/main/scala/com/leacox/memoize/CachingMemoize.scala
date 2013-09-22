package com.leacox.memoize


import com.leacox.memoize.cache.{SingleValueCache, Cache}

/**
 * @author John Leacox
 */
class CachingMemoize1[-T, +R](cache: Cache[T, R])(f: T => R) extends (T => R) {
  def apply(x: T): R = cache.getOrElseUpdate(x, f(x))
}

class CachingMemoize0[+R](cache: SingleValueCache[R])(f: () => R) extends (() => R) {
  def apply(): R = cache.getOrElseUpdate(f())
}

object CachingMemoize {
  // TODO: Special case for zero-arity function
  def apply[R](cache: SingleValueCache[R])(f: () => R): (() => R) = new CachingMemoize0(cache)(f)

  def apply[T, R](cache: Cache[T, R])(f: T => R): (T => R) = new CachingMemoize1(cache)(f)

  def apply[T1, T2, R](cache: Cache[(T1, T2), R])(f: (T1, T2) => R): ((T1, T2) => R) = Function.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, R](cache: Cache[(T1, T2, T3), R])(f: (T1, T2, T3) => R): ((T1, T2, T3) => R) =
    Function.untupled(new CachingMemoize1(cache)(f.tupled))
}

