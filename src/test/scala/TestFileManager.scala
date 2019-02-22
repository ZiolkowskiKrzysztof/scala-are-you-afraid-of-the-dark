import java.io.File

object TestFileManager extends App {

  val fileManagerTest: FileManager = new FileManager

  val files: List[File] = fileManagerTest.getListOfFiles("C:\\Users\\ziooo\\Desktop\\1.1\\photos\\bright")

  println(files.toString())

  println(files.length)

  val testConv = fileManagerTest.convert(files)
  println(testConv)


}
