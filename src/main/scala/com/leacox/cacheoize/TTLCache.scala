package com.leacox.cacheoize

import scala.collection.mutable
import java.util.concurrent.TimeUnit

/**
 * @author John Leacox
 */
class TTLCache[K, V](timeToLiveMinutes: Long) extends Cache[K, V] {
  private[this] val timeToLiveMillis = TimeUnit.MINUTES.toMillis(timeToLiveMinutes)
  private[this] val cache = mutable.Map.empty[K, (Long, V)]

  override def get(key: K) = cache.get(key) match {
    case None => None
    case Some(v) => v match {
      case (expiration, value) => {
        if (expiration < System.currentTimeMillis) {
          cache.remove(key)
          None
        }
        else Some(value)
      }
    }
  }

  override def put(key: K, value: V) = synchronized {
    val now = System.currentTimeMillis
    cache.put(key, (now + timeToLiveMillis, value))
  }
}
