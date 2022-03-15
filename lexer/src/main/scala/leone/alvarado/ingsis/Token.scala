package leone.alvarado.ingsis
import org.austral.ingsis.printscript.common.TokenType

case class Token(val tokenType: TokenType, val from: Int, val to: Int)

sealed trait TokenType  { def toString (): String }
case class DECLARATION() extends TokenType { override def toString() : String = "DECLARATION" }
case class IDENTIFIER(val name: String) extends TokenType { override def toString() : String = "IDENTIFIER" }
case class COLON() extends TokenType { override def toString() : String = "COLON" }
case class SEMICOLON() extends TokenType { override def toString() : String = "SEMICOLON" }