package scala
import java.io.File

import scala.collection.mutable.ListBuffer

class FileManager {

  val rightExtensions = List("jpg", "png")

  def getListOfFiles(dir: String):List[File] = {
    val extensions = rightExtensions
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList.filter { file =>
        extensions.exists(file.getName.endsWith(_))
      }
    } else {
      List[File]()
    }
  }

  def convert(listOfFiles: List[File])= {
    var list = new ListBuffer[String]()
    for (i <- 0 to (listOfFiles.length - 1))
      list += listOfFiles(i).getAbsolutePath

    val resultList = list.toList
    resultList
  }

  def createPicture(directory: String) = new Picture(directory)

}
