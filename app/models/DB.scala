package models

import sorm._

object DB extends Instance(
  entities = Set(Entity[Transaction](), Entity[Product](), Entity[Person]()),
  url = "jdbc:h2:mem:test"
)


// object DB extends Instance(
//   entities = Set(Entity[Transaction](), Entity[Product](), Entity[Person]()),
//   url = "jdbc:mysql://localhost/play_test",
//   user = "root",
//   password = "vgh25gpq"
// )
