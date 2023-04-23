package routes
import cats.effect.*
import org.http4s.*
import org.http4s.dsl.Http4sDsl
import services.ServiceList
class RoutesList[F[_]: Async](ServiceList: ServiceList[F]) extends Http4sDsl[F] {
  private val myService = new ServiceList()

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "hello" =>
      Ok(myService.myMethod())
  }
}
