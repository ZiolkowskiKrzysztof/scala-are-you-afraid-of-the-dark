package scala
import java.io.File

import scala.collection.mutable.ListBuffer

/** A class responsible for file operations. */
class FileManager {

  val rightExtensions = List("jpg", "png")

  /** This method gets data from given folder and give list of right extension files.
    *
    * @param dir A directory to be searched.
    * @return A list of right extension files.
    */
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

  /** This method converts List[File] into List[String].
    *
    * @param listOfFiles A list to be converted.
    * @return List[String]
    */
  def convert(listOfFiles: List[File])= {
    var list = new ListBuffer[String]()
    for (i <- 0 to (listOfFiles.length - 1))
      list += listOfFiles(i).getAbsolutePath

    val resultList = list.toList
    resultList
  }

  /** This method creates a new picture. */
  def createPicture(directory: String) = new Picture(directory)

}
