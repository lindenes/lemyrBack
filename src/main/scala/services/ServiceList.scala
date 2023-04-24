package services
import cats.Applicative
import cats.effect.Sync
import io.circe._
import io.circe.literal._
object ServiceList {
  def testMethod(): String =  "Test Working"

  def registration():Json = json"""{"message": "registration successful"}"""
}
