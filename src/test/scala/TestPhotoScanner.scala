import test.scala.PhotoScanner

object TestPhotoScanner extends App {

  val test1: PhotoScanner = new PhotoScanner

  val startTime = System.nanoTime()
  test1.test()
  val duration = (System.nanoTime() - startTime) / 1e9d
  println("Duration time: " + duration + " s.")

//  println(test1.convert(256))

}
