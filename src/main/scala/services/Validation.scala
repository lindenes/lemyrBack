package services

import io.circe.Json
import io.circe.literal.json
import services.ServiceList.User

class Validation {

  case class validationInfo(passEqual:Boolean)

  def checkValidation(user: User): validationInfo = {
      val validation = validationInfo(
        passwordEquality(user)
      )
      validation
  }
    def passwordEquality(user:User): Boolean =
      user.password == user.passwordRepeat

}