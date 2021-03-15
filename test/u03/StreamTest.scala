package u03

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Streams.Stream
import u03.Streams.Stream._
import u03lab.Streams.Stream._
import u03.Lists.List._

class StreamTest {

  val testStream: Stream[Int] = take(iterate(1)(_ + 1))(5) //1, 2, 3, 4, 5

  @Test def testDrop(): Unit = {
    assertEquals(append(of(2, 3, 4), of(5)), toList(drop(testStream)(1)))
    assertEquals(of(3, 4, 5), toList(drop(testStream)(2)))
    assertEquals(of(4, 5), toList(drop(testStream)(3)))
    assertEquals(Nil(), toList(drop(testStream)(6)))
    assertEquals(Nil(), toList(drop(Empty())(2)))
  }

  @Test def testConstant(): Unit = {
    assertEquals(of("Hello World", "Hello World", "Hello World"), toList(take(constant("Hello World"))(3)))
    assertEquals(of(true, true, true), toList(take(constant(true))(3)))
    assertEquals(of(1, 1, 1), toList(take(constant(1))(3)))
  }
}
