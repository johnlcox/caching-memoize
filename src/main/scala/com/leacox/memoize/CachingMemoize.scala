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

  def apply[T, R](cache: Cache[T, R])
                 (f: T => R): (T => R) = new CachingMemoize1(cache)(f)

  def apply[T1, T2, R](cache: Cache[(T1, T2), R])
                      (f: (T1, T2) => R): ((T1, T2) => R) = Function.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, R](cache: Cache[(T1, T2, T3), R])
                          (f: (T1, T2, T3) => R): ((T1, T2, T3) => R) = Function.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, R](cache: Cache[(T1, T2, T3, T4), R])
                              (f: (T1, T2, T3, T4) => R): ((T1, T2, T3, T4) => R) = Function.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, R](cache: Cache[(T1, T2, T3, T4, T5), R])
                                  (f: (T1, T2, T3, T4, T5) => R): ((T1, T2, T3, T4, T5) => R) = Function.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, R](cache: Cache[(T1, T2, T3, T4, T5, T6), R])
                                      (f: (T1, T2, T3, T4, T5, T6) => R): ((T1, T2, T3, T4, T5, T6) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7), R])
                                          (f: (T1, T2, T3, T4, T5, T6, T7) => R): ((T1, T2, T3, T4, T5, T6, T7) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8), R])
                                              (f: (T1, T2, T3, T4, T5, T6, T7, T8) => R): ((T1, T2, T3, T4, T5, T6, T7, T8) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9), R])
                                                  (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10), R])
                                                       (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11), R])
                                                            (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12), R])
                                                                 (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13), R])
                                                                      (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14), R])
                                                                           (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15), R])
                                                                                (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16), R])
                                                                                     (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17), R])
                                                                                          (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18), R])
                                                                                               (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19), R])
                                                                                                    (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20), R])
                                                                                                         (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21), R])
                                                                                                              (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))

  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R](cache: Cache[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22), R])
                                                                                                                   (f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R): ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R) = Tupler.untupled(new CachingMemoize1(cache)(f.tupled))
}

