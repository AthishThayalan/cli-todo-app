object CommandLineInterface {

  def main(args: Array[String]): Unit = {
    loop()
  }

  def loop(tasks:List[Task] = List.empty[Task]): Unit = {
    println("\nTo-Do List Application")
    println("----------------------")
    println("1. Add a new task")
    println("2. Remove a task")
    println("3. Mark a task as complete")
    println("4. List all tasks")
    println("5. Exit")

    print("\nEnter your choice: ")
    val choice = scala.io.StdIn.readLine()

    choice match {
      case "1" =>
        println("Enter a descr")
    }


  }

}
