import io.github.mlidal.todomvc.MyServlet
import io.github.mlidal.todomvc.model.Todo
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    val todos = collection.mutable.Map[Integer, Todo]()

    context mount (new MyServlet(todos), "/*")
  }
}
