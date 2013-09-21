package com.leacox.cacheoize


/**
 * @author John Leacox
 */
class Cacheoize1[-T, +R](f: T => R) extends (T => R) {
  private[this] val cache = TTLCache[T, R](10000)

  def apply(x: T): R = {
    //cache.getOrElseUpdate(x, (1, f(x)))._2
    getOrElseUpdate(x, f(x))
  }

  private[this] def getOrElseUpdate(x: T, op: => R): R = {
    cache.get(x) match {
      case Some(v) => v
      case None => val d = op; cache.put(x, d); d
    }
  }

}

object Cacheoize {
  // TODO: Special case for zero-arity function
  //def cacheoize[R](f: () => R): (() => R) = ...

  def cacheoize[T, R](f: T => R): (T => R) = new Cacheoize1(f)

  def apply[T1, T2, R](f: (T1, T2) => R): ((T1, T2) => R) = Function.untupled(cacheoize(f.tupled))
}
