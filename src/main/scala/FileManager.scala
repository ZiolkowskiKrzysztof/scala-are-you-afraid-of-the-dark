import java.io.File

class FileManager {

  def getListOfFiles(directory: String): List[File] = {
    val d = new File(directory)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

}
