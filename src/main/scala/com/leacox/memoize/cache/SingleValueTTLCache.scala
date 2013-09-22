package com.leacox.memoize.cache

/**
 * @author John Leacox
 */
class SingleValueTTLCache[V](timeToLive: Long, var cache: Option[(Long, V)])(clock: () => Long) extends SingleValueCache[V] {
  override def get() = synchronized {
    cache match {
      case None => None
      case Some(v) => v match {
        case (expiration, value) => {
          if (expiration < clock()) {
            cache = None
            None
          }
          else Some(value)
        }
      }
    }
  }

  override def put(value: V) = synchronized {
    val now = clock()
    cache = Some((now + timeToLive, value))
  }
}

object SingleValueTTLCache {
  def apply[V](timeToLive: Long, clock: () => Long = () => System.currentTimeMillis,
               backingOption: Option[(Long, V)] = None) = {
    new SingleValueTTLCache(timeToLive, backingOption)(clock)
  }
}
