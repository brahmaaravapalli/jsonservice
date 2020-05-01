package models

import play.api.libs.json.Json

case class User (
                  id: String     = "USR-001",
                  name: String   = "Kirby",
                  age:  Int      = 35
                )

object User {
     implicit val userImplicitReads = Json.reads[User]
     implicit val userImplicitWrites = Json.writes[User]
}