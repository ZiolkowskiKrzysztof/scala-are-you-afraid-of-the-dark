package scala

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/** A class responsible for the operations on the picture. */
class PhotoScanner {

  /** This method is responsible for creating a copy of the scanned image.
    *
    * @param img An image to be copied.
    * @return A copy of the original image.
    */
  private def copy(img: BufferedImage): BufferedImage = {
    val width = img.getWidth
    val height = img.getHeight

    // create new image of the same size
    val out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

    // copy pixels
    for (x <- 0 until width)
      for (y <- 0 until height)
        out.setRGB(x, y, img.getRGB(x, y) & 0xffffff)

    out
  }

  /** This method gets data from the pixel about intensity of colors (red, green, blue).
    *
    * @param rgb An integer value of the product of the RGB values.
    * @return The average color value in the range 0-256.
    */
  private def getColor(rgb: Int): Int = {
    val color = rgb
    val red = (color & 0xff0000) / 65536
    val green = (color & 0xff00) / 256
    val blue = (color & 0xff)

    val avg = ((red * 1.2 + green * 0.8 + blue * 1.1) / 3).toInt

    avg
  }

  /** This method converts RGB(0-256) value to the another (0-100) scale.
    *
    * @param n A value in RGB scale.
    * @return A value in 0-100 scale.
    */
  private def convert(n: Int): Int = {
    val func = ((-15) * (n * n) / 11264) + ((515 * n) / 704)

    // Parabola above returns 0-black, 100-white, so result needs to be calculated one more time.
    -func + 100
  }

  /** This method scans an image and calculate average RGB value of the picture.
    *
    * @param img An image to be scanned.
    * @return The average color value in the range 0-256 of the whole picture.
    */
  private def scan(img: BufferedImage): Int = {

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

  /** This method creates a name for the new image depending on brightness of the picture and given cut-off.
    *
    * @param name An original name of the image.
    * @param n A brightness of the photo in 0-100 scale.
    * @param cutOff A value of given cut-off.
    * @return
    */
  private def setName(name: String, n: Int, cutOff: Int): String =
    if (n >= cutOff) name + "_dark_" + n
    else name + "_bright_" + n

  /** This method removes the extension from the name.
    *
    * @param fileName A fullname of given file.
    * @return A name of file without extension.
    */
  private def withoutExtension(fileName: String): String = {
      fileName.substring(0, fileName.lastIndexOf("."))
  }

  /** This method removes the name and leave only extension of the file.
    *
    * @param fileName A fullname of given file.
    * @return An extension of the file.
    */
  private def getExtension(fileName: String): String = {
    fileName.substring(fileName.indexOf(".") + 1, fileName.length)
  }

  /** This method is responsible for saving image with information about brightness of the picture.
    *
    * @param imgName An image to be save.
    * @param cutOff A value of given cut-off.
    */
  def write(imgName: Picture, cutOff: Int): Unit = {
    val photo1 = ImageIO.read(new File(imgName.path))
    val color = scan(photo1)
    val baseName = withoutExtension(imgName.fileName)
    val extension = getExtension(imgName.fileName)
    val name = setName(baseName, color, cutOff)
    val photo2 = copy(photo1)

    ImageIO.write(photo2, extension, new File(name + "." + extension))
  }

}
