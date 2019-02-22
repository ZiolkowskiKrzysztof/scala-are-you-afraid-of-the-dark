import test.scala.PhotoScanner

object TestPhotoScanner extends App {

  val test1: PhotoScanner = new PhotoScanner

  val startTime = System.nanoTime()
  test1.test()
  val duration = (System.nanoTime() - startTime) / 1e9d
  println("Duration time: " + duration + " s.")

//  println(test1.convert(256))

  val testSetName = test1.setName("oneTwo", 35, 45)
  val testSetName2 = test1.setName("oneTwoThree", 55, 45)
  println(testSetName)
  println(testSetName2)

  val writeTest = test1.write("a.jpg", 45)
//  val writeTest2 = test1.write("Piter.png", 45)
//  val writeTest3 = test1.write("a2.jpg", 45)

//  val improveNameTest = test1.withoutExtension("a.jpg")
//  println(improveNameTest)

//  println(test1.getExtension("a.jpg"))

}
