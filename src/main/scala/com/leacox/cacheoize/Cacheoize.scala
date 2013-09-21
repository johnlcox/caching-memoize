package com.leacox.cacheoize

import scala.collection.mutable

/**
 * @author John Leacox
 */
class Cacheoize1[-T, +R](f: T => R) extends (T => R) {
  private[this] val cache = mutable.Map.empty[T, (Long, R)]

  def apply(x: T): R = {
    cache.getOrElseUpdate(x, (1, f(x)))._2
  }

}

object Cacheoize {
  // TODO: Special case for zero-arity function
  //def cacheoize[R](f: () => R): (() => R) = ...

  def cacheoize[T, R](f: T => R): (T => R) = new Cacheoize1(f)

  def cacheoize[T1, T2, R](f: (T1, T2) => R): ((T1, T2) => R) = Function.untupled(cacheoize(f.tupled))
}
