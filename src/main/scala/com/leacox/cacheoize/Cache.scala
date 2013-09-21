package com.leacox.cacheoize

/**
 * @author John Leacox
 */
trait Cache[K, V] {
  def get(key: K): Option[V]

  def put(key: K, value: V): Unit
}
