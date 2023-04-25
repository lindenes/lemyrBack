package services

import io.circe.Json
import io.circe.literal.json
import services.ServiceList.User

class Validation {

  case class validationInfo(passwordError:String)

  def checkValidation(user: User): validationInfo = {
    val passwordCheck = passwordChecker(user)
    val validation = validationInfo(
      passwordCheck._1
    )
    if (passwordCheck._2)
      doRegistration(user)

    validation
  }

    def passwordChecker(user:User): (String, Boolean) =
      var errorList = List.empty[String]
      if(user.password != user.passwordRepeat)
        ("Пароли не совпадают", false)
      else if (user.password == "" || user.password.isEmpty )
        ("Пустое значение", false)
      else if(user.password.length < 7)
        ("Пароль должен быть длиннее 7 символов", false)
      else
        ("", true)

    def doRegistration(user:User): Unit = {
      println("Зарегистрирован")
    }
}