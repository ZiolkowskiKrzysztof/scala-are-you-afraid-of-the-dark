package test.scala

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

class PhotoScanner {

  def copy(img: BufferedImage): BufferedImage = {
    // obtain width and height of image
    val w = img.getWidth
    val h = img.getHeight

    // create new image of the same size
    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    // copy pixels
    for (x <- 0 until w)
      for (y <- 0 until h)
        out.setRGB(x, y, img.getRGB(x, y) & 0xffffff)

    // TODO: scanning brightness of the pixels

    out
  }

  def getColor(rgb: Int): Int = {
    val color = rgb
    val red = (color & 0xff0000) / 65536
    val green = (color & 0xff00) / 256
    val blue = (color & 0xff)

    val avg = ((red * 1.2 + green * 0.8 + blue * 1.1) / 3).toInt

    avg
  }

  def convert(n: Int): Int = {
    ((-15) * (n * n) / 11264) + ((515 * n) / 704)
  }

  def scan(img: BufferedImage): Int = {

    val width = img.getWidth
    val height = img.getHeight

    val res = for {
      w <- 0 until width by 15
      h <- 0 until height by 15
    } yield getColor(img.getRGB(w, h))

    val avg = res.sum / res.size
    val result = convert(avg)

    result
  }

  def test() {

    val p1 = ImageIO.read(new File("a.jpg"))
    val p2 = ImageIO.read(new File("b.jpg"))
    val p3 = ImageIO.read(new File("c.jpg"))
    val p4 = ImageIO.read(new File("d.jpg"))
    val p5 = ImageIO.read(new File("e.jpg"))
    val p6 = ImageIO.read(new File("f.jpg"))
    val p7 = ImageIO.read(new File("g.jpg"))
    val p8 = ImageIO.read(new File("h.jpg"))
    val p9 = ImageIO.read(new File("i.jpg"))
    val p10 = ImageIO.read(new File("j.jpg"))

    // save image to file "test.jpg"
//    ImageIO.write(photo2, "jpg", new File("test.jpg"))
    println("Photo1: ")
    println(scan(p1))
    println("Photo2: ")
    println(scan(p2))
    println("Photo3: ")
    println(scan(p3))
    println("Photo4: ")
    println(scan(p4))
    println("Photo5: ")
    println(scan(p5))
    println("Photo6: ")
    println(scan(p6))
    println("Photo7: ")
    println(scan(p7))
    println("Photo8: ")
    println(scan(p8))
    println("Photo9: ")
    println(scan(p9))
    println("Photo10: ")
    println(scan(p10))
//    ImageIO.write(photo2, "png", new File("test.png"))
  }


}
