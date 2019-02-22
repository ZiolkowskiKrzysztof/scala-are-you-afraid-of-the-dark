
object TestFileManager extends App {

  val fileManagerTest: FileManager = new FileManager

  val files = fileManagerTest.getListOfFiles("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright")

  println(files.toString())

}
