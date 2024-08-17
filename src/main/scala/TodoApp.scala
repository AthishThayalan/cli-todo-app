
object TodoApp {
  def addTask(tasks:List[Task],description:String) : List[Task] = {
    val newId:Int = if (tasks.isEmpty) 1 else tasks.maxBy(_.id).id +1 // if empty then 1 , else , do max missing num from id's
    val newTask = Task(newId , description)

    tasks :+ newTask
  }
}
