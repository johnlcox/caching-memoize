package com.leacox.memoize.cache

/**
 * @author John Leacox
 */
trait Cache[K, V] {
  def get(key: K): Option[V]

  def getOrElseUpdate(key: K, op: => V): V = get(key).getOrElse {
    val value = op
    put(key, value)
    value
  }

  def put(key: K, value: V): Unit
}
