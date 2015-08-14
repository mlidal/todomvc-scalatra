package io.github.mlidal.todomvc

import io.github.mlidal.todomvc.model.Todo
import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport

class MyServlet(todos : collection.mutable.Map[Integer, Todo]) extends ScalatraServlet with ScalateSupport {

  get("/") {
    contentType = "text/html"
    jade("/index", "todos" -> todos.values.toList.sortBy(_.completed))
  }

  post("/new") {
    val id = todos.size
    todos.put(id, Todo(id, params.get("todo").get, completed = false))
    redirect("/")
  }

  get("/:id/completed") {
    val todo = todos.get(params("id").toInt).get
    todo.completed = true
    redirect("/")
  }

  get("/:id/delete") {
    todos.remove(params("id").toInt)
    redirect("/")
  }
}