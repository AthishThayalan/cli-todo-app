import scala.annotation.tailrec
import scala.io.StdIn.{readInt, readLine}

object CommandLineInterface extends App {

  @tailrec
  def loop(tasks:List[Task] = List.empty[Task]): Unit = {
    println("\nTo-Do List Application")
    println("----------------------")
    println("1. Add a new task")
    println("2. Remove a task")
    println("3. Mark a task as complete")
    println("4. List all tasks")
    println("5. Exit")

    print("\nEnter your choice: ")
    val choice = readLine()

    choice match {
      case "1" =>
        println("Enter a description: ")
        val description = readLine()
        val updatedTasks = TodoApp.addTask(tasks,description)
        updatedTasks match {
          case Right(tasks) => loop(tasks)
          case Left(error) =>
            println(s"Error: $error ")
            loop(tasks)
        }

      case "2" =>
        println("Enter the Id of Task you would like to remove: ")
        val id = readInt()
        val updatedTasks = TodoApp.removeTask(tasks,id)
        updatedTasks match {
          case Right(tasks) => loop(tasks)
          case Left(error) =>
            println(s"Error: $error ")
            loop(tasks)

        }

      case "3" =>
        println("Enter the Id of Task you would like to complete: ")
        val id = readInt()
        val updatedTasks = TodoApp.completeTask(tasks,id)
        updatedTasks match {
          case Right(tasks) => loop(tasks)
          case Left(error) =>
            println(s"Error: $error ")
            loop(tasks)
        }
      case "4" =>
        println("\nYour tasks:")
        println(TodoApp.listTasks(tasks))
        Thread.sleep(1000)
        loop(tasks)

      case "5" =>
        println("Goodbye!")
        System.exit(0)

      case _ =>
        println("Invalid choice, please try again.")
        loop(tasks)

    }


  }

  loop()

}
