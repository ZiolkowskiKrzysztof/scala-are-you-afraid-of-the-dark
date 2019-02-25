/** A class responsible for solving the given problem of task. */
class Problem(directory: String, n: Int) {

  val path = directory
  val cutOff = n

  val fileManager = new FileManager
  val photoScanner = new PhotoScanner
  val dir = fileManager.getListOfFiles(directory)
  val listOfStrings = fileManager.convert(dir)
  val max = listOfStrings.length - 1

  for (i <- 0 to max)
    photoScanner.write(new Picture(this.listOfStrings(i)), cutOff)

}
