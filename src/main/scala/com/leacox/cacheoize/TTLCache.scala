package com.leacox.cacheoize

import scala.collection.mutable

/**
 * @author John Leacox
 */
class TTLCache[K, V](timeToLive: Long, cache: mutable.Map[K, (Long, V)])(clock: () => Long) extends Cache[K, V] {
  override def get(key: K) = cache.get(key) match {
    case None => None
    case Some(v) => v match {
      case (expiration, value) => {
        if (expiration < clock()) {
          cache.remove(key)
          None
        }
        else Some(value)
      }
    }
  }

  override def put(key: K, value: V) = synchronized {
    val now = clock()
    cache.put(key, (now + timeToLive, value))
  }
}

object TTLCache {
  def apply[K, V](timeToLive: Long, clock: () => Long = () => System.currentTimeMillis,
                  backingMap: mutable.Map[K, (Long, V)] = mutable.Map.empty[K, (Long, V)]) = {
    new TTLCache(timeToLive, backingMap)(clock)
  }
}
