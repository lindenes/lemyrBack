package services
import cats.Applicative
import cats.effect.{IO, Sync}
import io.circe.*
import io.circe.literal.*
import org.http4s.circe.jsonOf
import org.http4s.{Request, UrlForm}
import io.circe.generic.semiauto.deriveDecoder
import org.http4s.circe.CirceEntityCodec.circeEntityDecoder
object ServiceList {
  case class User(login: String, password:String)

  implicit val decoder:Decoder[User] = deriveDecoder[User]
  def testMethod(): String =  "Test Working"
  def registration(req: Request[IO]): IO[Json] =
    req.as[User].flatMap { user =>
      // Handle registration logic with user object
      IO.pure(
        json"""{
              "message": "registration successful",
              "login": ${user.login + "1"},
              "password": ${user.password + "2"}
            }"""
      )
    }

}
