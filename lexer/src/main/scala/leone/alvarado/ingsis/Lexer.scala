package leone.alvarado.ingsis
import org.austral.ingsis.printscript.common.Token
trait Lexer {
def readToken(input: String): Token
}
