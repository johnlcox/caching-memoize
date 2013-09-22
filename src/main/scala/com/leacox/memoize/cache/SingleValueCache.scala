package com.leacox.memoize.cache

/**
 * @author John Leacox
 */
trait SingleValueCache[V] {
  def get(): Option[V]

  def getOrElseUpdate(op: => V): V = get().getOrElse {
    val value = op
    put(value)
    value
  }

  def put(value: V): Unit
}
