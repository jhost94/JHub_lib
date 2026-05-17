package center.jhub.texttoascii.font;

import org.apache.commons.lang3.NotImplementedException;

public final class ASCIIUtils {
    private ASCIIUtils() {}

    public static <T extends ASCIICharacter> String map(Character c, T ac) {
        return switch (c) {
            case 'a' -> ac.a();
            case 'b' -> ac.b();
            case 'c' -> ac.c();
            case 'd' -> ac.d();
            case 'e' -> ac.e();
            case 'f' -> ac.f();
            case 'g' -> ac.g();
            case 'h' -> ac.h();
            case 'i' -> ac.i();
            case 'j' -> ac.j();
            case 'k' -> ac.k();
            case 'l' -> ac.l();
            case 'm' -> ac.m();
            case 'n' -> ac.n();
            case 'o' -> ac.o();
            case 'p' -> ac.p();
            case 'q' -> ac.q();
            case 'r' -> ac.r();
            case 's' -> ac.s();
            case 't' -> ac.t();
            case 'u' -> ac.u();
            case 'v' -> ac.v();
            case 'w' -> ac.w();
            case 'x' -> ac.x();
            case 'y' -> ac.y();
            case 'z' -> ac.z();

            case 'A' -> ac.A();
            case 'B' -> ac.B();
            case 'C' -> ac.C();
            case 'D' -> ac.D();
            case 'E' -> ac.E();
            case 'F' -> ac.F();
            case 'G' -> ac.G();
            case 'H' -> ac.H();
            case 'I' -> ac.I();
            case 'J' -> ac.J();
            case 'K' -> ac.K();
            case 'L' -> ac.L();
            case 'M' -> ac.M();
            case 'N' -> ac.N();
            case 'O' -> ac.O();
            case 'P' -> ac.P();
            case 'Q' -> ac.Q();
            case 'R' -> ac.R();
            case 'S' -> ac.S();
            case 'T' -> ac.T();
            case 'U' -> ac.U();
            case 'V' -> ac.V();
            case 'W' -> ac.W();
            case 'X' -> ac.X();
            case 'Y' -> ac.Y();
            case 'Z' -> ac.Z();

            case '0' -> ac._0();
            case '1' -> ac._1();
            case '2' -> ac._2();
            case '3' -> ac._3();
            case '4' -> ac._4();
            case '5' -> ac._5();
            case '6' -> ac._6();
            case '7' -> ac._7();
            case '8' -> ac._8();
            case '9' -> ac._9();

            case ' ' -> ac.space();
            case '-' -> ac.dash();
            case '_' -> ac.underscore();
            case '/' -> ac.slash();
            case '\\' -> ac.backslash();
            case '.' -> ac.dot();
            case ',' -> ac.comma();
            case ':' -> ac.colon();
            case ';' -> ac.semicolon();
            case '!' -> ac.exclamation();
            case '?' -> ac.question();
            case '@' -> ac.at();
            case '#' -> ac.hash();
            case '$' -> ac.dollar();
            case '%' -> ac.percent();
            case '^' -> ac.caret();
            case '&' -> ac.ampersand();
            case '*' -> ac.star();
            case '+' -> ac.plus();
            case '=' -> ac.equals();
            case '|' -> ac.pipe();
            case '~' -> ac.tilde();
            case '`' -> ac.backtick();
            case '\'' -> ac.singleQuote();
            case '"' -> ac.doubleQuote();
            case '(' -> ac.openParen();
            case ')' -> ac.closeParen();
            case '[' -> ac.openBracket();
            case ']' -> ac.closeBracket();
            case '{' -> ac.openBrace();
            case '}' -> ac.closeBrace();
            case '<' -> ac.lessThan();
            case '>' -> ac.greaterThan();
            default -> throw new NotImplementedException();
        };
    }
}
