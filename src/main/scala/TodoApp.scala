import scala.collection.IterableOnce.iterableOnceExtensionMethods

object TodoApp {
  def addTask(tasks: List[Task], description: String): Either[String, List[Task]] = {
    if (description.trim.isEmpty) Left("Task description cannot be empty.")
    else {
      val newId: Int = if (tasks.isEmpty) 1 else tasks.maxBy(_.id).id + 1
      val newTask = Task(newId, description)
      Right(tasks :+ newTask)
    }


  }

  def removeTask(tasks: List[Task], id: Int): Either[String, List[Task]] = {
    val taskExists = tasks.exists(_.id == id)

    if (taskExists) {
      val updatedTasks = tasks.filterNot(_.id == id)
      val reassignedTasks = updatedTasks.zipWithIndex.map {
        case (task, index) => task.copy(id = index + 1)
      }
      Right(reassignedTasks)
    } else {
      Left(s"Task with ID $id does not exist.")
    }
  }

  def completeTask(tasks: List[Task], id: Int): Either[String, List[Task]] = {
    if (tasks.exists(_.id == id)) {
      Right(tasks.map {
        case task if task.id == id => task.copy(isCompleted = true)
        case task => task
      })
    }
    else Left(s"Task with ID: $id does not exist.")


  }

  def listTasks(tasks: List[Task]): String = {
    if (tasks.isEmpty) {
      return "You have no current tasks ..."
    } else {
      tasks.map { task =>
        val status = if (task.isCompleted) "[x]" else "[ ]"
        s"${task.id}. $status ${task.description}"
      }.mkString("\n")
    }

  }
}
