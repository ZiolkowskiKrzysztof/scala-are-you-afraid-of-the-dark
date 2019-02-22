package scala

class Picture(directory: String) {

  def getFileName(dir: String) = dir.substring(dir.lastIndexOf("\\") + 1, dir.length)
  val path: String = directory
  val fileName: String = getFileName(directory)


}
