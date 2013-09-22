package com.leacox.memoize

/**
 * @author John Leacox
 */
object Tupler {
  /** Un-tupling for functions of arity 2. This transforms a function taking
    * a pair of arguments into a binary function which takes each argument separately.
    */
  def untupled[T1, T2, R](f: ((T1, T2)) => R): (T1, T2) => R = {
    (x1, x2) => f(Tuple2(x1, x2))
  }

  def untupled[T1, T2, T3, R](f: ((T1, T2, T3)) => R): (T1, T2, T3) => R = {
    (x1, x2, x3) => f(Tuple3(x1, x2, x3))
  }

  def untupled[T1, T2, T3, T4, R](f: ((T1, T2, T3, T4)) => R): (T1, T2, T3, T4) => R = {
    (x1, x2, x3, x4) => f(Tuple4(x1, x2, x3, x4))
  }

  def untupled[T1, T2, T3, T4, T5, R](f: ((T1, T2, T3, T4, T5)) => R): (T1, T2, T3, T4, T5) => R = {
    (x1, x2, x3, x4, x5) => f(Tuple5(x1, x2, x3, x4, x5))
  }

  def untupled[T1, T2, T3, T4, T5, T6, R](f: ((T1, T2, T3, T4, T5, T6)) => R): (T1, T2, T3, T4, T5, T6) => R = {
    (x1, x2, x3, x4, x5, x6) => f(Tuple6(x1, x2, x3, x4, x5, x6))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, R](f: ((T1, T2, T3, T4, T5, T6, T7)) => R): (T1, T2, T3, T4, T5, T6, T7) => R = {
    (x1, x2, x3, x4, x5, x6, x7) => f(Tuple7(x1, x2, x3, x4, x5, x6, x7))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8)) => R): (T1, T2, T3, T4, T5, T6, T7, T8) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8) => f(Tuple8(x1, x2, x3, x4, x5, x6, x7, x8))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9) => f(Tuple9(x1, x2, x3, x4, x5, x6, x7, x8, x9))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10) => f(Tuple10(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11) => f(Tuple11(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12) => f(Tuple12(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13) => f(Tuple13(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14) => f(Tuple14(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15) => f(Tuple15(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16) => f(Tuple16(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17) => f(Tuple17(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18) => f(Tuple18(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19) => f(Tuple19(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20) => f(Tuple20(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21) => f(Tuple21(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21))
  }

  def untupled[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R](f: ((T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)) => R): (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R = {
    (x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22) => f(Tuple22(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22))
  }
}
