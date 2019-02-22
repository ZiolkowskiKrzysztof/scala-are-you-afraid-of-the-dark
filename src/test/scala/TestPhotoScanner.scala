object TestPhotoScanner extends App {

  val test1: PhotoScanner = new PhotoScanner

  val startTime = System.nanoTime()
//  test1.test()


//  println(test1.convert(256))

  val testSetName = test1.setName("oneTwo", 35, 45)
  val testSetName2 = test1.setName("oneTwoThree", 55, 45)
  println(testSetName)
  println(testSetName2)

//  val pic1: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\random.png")
//  val pic2: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\b.jpg")
//  val pic3: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\c.jpg")
//  val pic4: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\d.jpg")
//  val pic5: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\e.jpg")
//  val pic6: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\f.jpg")
//  val pic7: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\g.jpg")
//  val pic8: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\h.jpg")
//  val pic9: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\i.jpg")
//  val pic10: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\j.jpg")
//  val pic11: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\k.jpg")
//  val pic12: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\l.jpg")
//  val pic13: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\m.jpg")
//  val pic14: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\n.jpg")
//  val pic15: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright\\n.jpg")
//  val pic16: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\too_dark\\d.jpg")
//  val pic17: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\too_dark\\i.jpg")
//  val pic18: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\too_dark\\j.jpg")
//  val pic19: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\too_dark\\k.jpg")
//  val pic20: Picture = new Picture("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\too_dark\\g.png")
//
//  test1.write(pic1, 35)
//  test1.write(pic2, 35)
//  test1.write(pic3, 35)
//  test1.write(pic4, 35)
//  test1.write(pic5, 35)
//  test1.write(pic6, 35)
//  test1.write(pic7, 35)
//  test1.write(pic8, 35)
//  test1.write(pic9, 35)
//  test1.write(pic10, 35)
//  test1.write(pic11, 35)
//  test1.write(pic12, 35)
//  test1.write(pic13, 35)
//  test1.write(pic14, 35)
//  test1.write(pic15, 35)
//  test1.write(pic16, 35)
//  test1.write(pic17, 35)
//  test1.write(pic18, 35)
//  test1.write(pic19, 35)
//  test1.write(pic20, 35)
//  val writeTest2 = test1.write("Piter.png", 45)
//  val writeTest3 = test1.write("a2.jpg", 45)



  val improveNameTest = test1.withoutExtension("a.jpg")
  println(improveNameTest)

  println(test1.getExtension("a.jpg"))

}
