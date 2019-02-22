import java.io.File

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

}
