package center.jhub.texttoascii.font;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public interface ASCIICharacter {

    /**
     * Lower case
     */
    default String a() {
        return "";
    }

    default String b() {
        return "";
    }

    default String c() {
        return "";
    }

    default String d() {
        return "";
    }

    default String e() {
        return "";
    }

    default String f() {
        return "";
    }

    default String g() {
        return "";
    }

    default String h() {
        return "";
    }

    default String i() {
        return "";
    }

    default String j() {
        return "";
    }

    default String k() {
        return "";
    }

    default String l() {
        return "";
    }

    default String m() {
        return "";
    }

    default String n() {
        return "";
    }

    default String o() {
        return "";
    }

    default String p() {
        return "";
    }

    default String q() {
        return "";
    }

    default String r() {
        return "";
    }

    default String s() {
        return "";
    }

    default String t() {
        return "";
    }

    default String u() {
        return "";
    }

    default String v() {
        return "";
    }

    default String w() {
        return "";
    }

    default String x() {
        return "";
    }

    default String y() {
        return "";
    }

    default String z() {
        return "";
    }

    /**
     * Upper case
     */
    default String A() {
        return "";
    }

    default String B() {
        return "";
    }

    default String C() {
        return "";
    }

    default String D() {
        return "";
    }

    default String E() {
        return "";
    }

    default String F() {
        return "";
    }

    default String G() {
        return "";
    }

    default String H() {
        return "";
    }

    default String I() {
        return "";
    }

    default String J() {
        return "";
    }

    default String K() {
        return "";
    }

    default String L() {
        return "";
    }

    default String M() {
        return "";
    }

    default String N() {
        return "";
    }

    default String O() {
        return "";
    }

    default String P() {
        return "";
    }

    default String Q() {
        return "";
    }

    default String R() {
        return "";
    }

    default String S() {
        return "";
    }

    default String T() {
        return "";
    }

    default String U() {
        return "";
    }

    default String V() {
        return "";
    }

    default String W() {
        return "";
    }

    default String X() {
        return "";
    }

    default String Y() {
        return "";
    }

    default String Z() {
        return "";
    }

    /**
     * Digits
     */
    default String _0() {
        return "";
    }

    default String _1() {
        return "";
    }

    default String _2() {
        return "";
    }

    default String _3() {
        return "";
    }

    default String _4() {
        return "";
    }

    default String _5() {
        return "";
    }

    default String _6() {
        return "";
    }

    default String _7() {
        return "";
    }

    default String _8() {
        return "";
    }

    default String _9() {
        return "";
    }

    /**
     * Special characters
     */
    default String space() {
        return "";
    }

    // -
    default String dash() {
        return "";
    }

    // _
    default String underscore() {
        return "";
    }

    // /
    default String slash() {
        return "";
    }

    // \
    default String backslash() {
        return "";
    }

    // .
    default String dot() {
        return "";
    }

    // ,
    default String comma() {
        return "";
    }

    // :
    default String colon() {
        return "";
    }

    // ;
    default String semicolon() {
        return "";
    }

    // !
    default String exclamation() {
        return "";
    }

    // ?
    default String question() {
        return "";
    }

    // @
    default String at() {
        return "";
    }

    // #
    default String hash() {
        return "";
    }

    // $
    default String dollar() {
        return "";
    }

    // %
    default String percent() {
        return "";
    }

    // ^
    default String caret() {
        return "";
    }

    // &
    default String ampersand() {
        return "";
    }

    // *
    default String star() {
        return "";
    }

    // +
    default String plus() {
        return "";
    }

    // =
    default String equals() {
        return "";
    }

    // |
    default String pipe() {
        return "";
    }

    // ~
    default String tilde() {
        return "";
    }

    // `
    default String backtick() {
        return "";
    }

    // '
    default String singleQuote() {
        return "";
    }

    // "
    default String doubleQuote() {
        return "";
    }

    // (
    default String openParen() {
        return "";
    }

    // )
    default String closeParen() {
        return "";
    }

    // [
    default String openBracket() {
        return "";
    }

    // ]
    default String closeBracket() {
        return "";
    }

    // {
    default String openBrace() {
        return "";
    }

    // }
    default String closeBrace() {
        return "";
    }

    // <
    default String lessThan() {
        return "";
    }

    // >
    default String greaterThan() {
        return "";
    }

    /**
     * Other data
     */

    default String padding() {
        return " ";
    }

    default boolean isMonospaced() {
        return false;
    }

    default String toMonospace(String parsedCharacter) {
        int maxLength = maxWith();
        int characterMaxLength = parsedCharacter.split("\n")[0]
                                     .length();
        if (characterMaxLength >= maxLength) return parsedCharacter;

        int leftPadding = (maxLength - characterMaxLength) / 2;
        int rightPadding = maxLength - characterMaxLength - leftPadding;

        return Arrays.stream(parsedCharacter.split("\n"))
                   .map(l -> padding().repeat(leftPadding) + l + padding().repeat(rightPadding))
                   .reduce("", (acc, l) -> acc + "\n" + l);
    }

    default int maxWith() {
        List<String> allowed = List.of(
        "a", "a", "b", "c", "d", "e", "f", "g",
        "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
        "r", "s", "t", "u", "v", "w", "x", "y", "z", "A",
        "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
        "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
        "V", "W", "X", "Y", "Z", "_0", "_1", "_2", "_3",
        "_4", "_5", "_6", "_7", "_8", "_9", "space", "dash",
        "underscore", "slash", "backslash", "dot", "comma",
        "colon", "semicolon", "exclamation", "question",
        "at", "hash", "dollar", "percent", "caret",
        "ampersand", "star", "plus", "equals", "pipe",
        "tilde", "backtick", "singleQuote", "doubleQuote",
        "openParen", "closeParen", "openBracket",
        "closeBracket", "openBrace", "closeBrace", "lessThan",
        "greaterThan"
        );

        return Arrays.stream(ASCIICharacter.class.getDeclaredMethods())
            .map(method -> {
                if (allowed.contains(method.getName())) {
                    try {
                        return (String) method.invoke(this);
                    } catch (IllegalAccessException e) {
                        System.out.println(e);
                    } catch (InvocationTargetException e) {
                        System.out.println(e);
                    }
                }
                return "";
            })
            .map(f -> Arrays.stream(f.split("\n"))
                           .map(String::length)
                           .reduce(0, Math::max)
            )
            .reduce(0, Math::max);
    }
}
