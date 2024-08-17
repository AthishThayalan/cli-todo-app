import scala.collection.IterableOnce.iterableOnceExtensionMethods

object TodoApp {
  def addTask(tasks: List[Task], description: String): List[Task] = {
    val newId: Int = if (tasks.isEmpty) 1 else tasks.maxBy(_.id).id + 1 // if empty then 1 , else , do max missing num from id's
    val newTask = Task(newId, description)

    tasks :+ newTask
  }

  def removeTask(tasks:List[Task],id:Int): List[Task] = {
    tasks.filterNot(_.id == id ) // if ids match then filter it out (remove it)
  }

  def completeTask(tasks:List[Task] , id:Int): List[Task] = {
    tasks.map {
      case task if task.id == id => task.copy(isCompleted = true)
      case task => task
    }
    // if id matches then replace with a copy (function way)
    // else keep as is

  }
}
