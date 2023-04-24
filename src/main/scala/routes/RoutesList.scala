package routes
import cats.effect.*
import org.http4s.*
import org.http4s.dsl.Http4sDsl
import services.ServiceList
class RoutesList[F[_]: Async] extends Http4sDsl[F] {
  object ServiceNameQueryParamMatcher extends QueryParamDecoderMatcher[String]("serviceName")

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "service" :? ServiceNameQueryParamMatcher(serviceName) =>
      serviceName match{
        case "test" => Ok(ServiceList[F].myMethod())
        case _ => Ok(ServiceList[F].testMethod())
      }
  }
}
