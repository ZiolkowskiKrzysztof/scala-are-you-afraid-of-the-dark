package scala

/** A class responsible for the pictures in this application. */
class Picture(directory: String) {

  def getFileName(dir: String) = dir.substring(dir.lastIndexOf("\\") + 1, dir.length)
  val path: String = directory
  val fileName: String = getFileName(directory)


}
