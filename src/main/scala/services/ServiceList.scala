package services
import cats.effect.Sync
class ServiceList[F[_]: Sync] {
  def myMethod(): F[String] = {
    Sync[F].delay(
      "Helloy Epta"
    )
  }
}
