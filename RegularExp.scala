/**
*	Qus2: Write a Regular Expression for Email Parsing.
*/

class EmailParser {
  val Email  = """([a-zA-Z]+)\@([a-zA-Z]+\.com)""".r                    //Regular Expression For Email
  def parseEmail(inputEmail : String) = {
    val someOrNone = Email findFirstIn inputEmail
    someOrNone match{
      case Some(s : String) => s match {
        case Email(user, domain) => println(s"User : $user \nDomain: $domain")
        case _ => println("Not an email address")
      }
      case _ => println("Not an email address")
    }
  }
}
  object RegularExp extends App {
    val objParseEmail = new EmailParser
    val inputEmail = "knol@knoldus.com"
    val inputEmail2 = "knol@knoldus@com"
    objParseEmail.parseEmail(inputEmail)
    objParseEmail.parseEmail(inputEmail2)

  }
