import cats.effect.IOApp
import cats.effect.*
import com.comcast.ip4s.*
import org.http4s.HttpRoutes
import org.http4s.dsl.io.*
import org.http4s.implicits.*
import org.http4s.ember.server.*
import org.http4s.server.middleware.{CORS, CORSPolicy}
import services.ServiceList
import routes.RoutesList
object Main extends IOApp {

  val cors: CORSPolicy = CORS.policy.withAllowOriginAll
    .withAllowCredentials(false)
  def run(args: List[String]): IO[ExitCode] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"5000")
      .withHttpApp( cors (RoutesList[IO].routes.orNotFound) )
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)

}