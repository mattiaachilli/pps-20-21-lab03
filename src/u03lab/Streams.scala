package u03lab

import u03.Streams.Stream
import u03.Streams.Stream._

object Streams {

    object Stream {
      def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
        case (Cons(_, tail), n) if n > 0 => drop(tail())(n - 1)
        case (stream, 0) => stream
        case (Empty(), _) => Empty()
      }
    }
}
