/*Arquivo para o scanner */
package parser;
// importar classes do cup - classe symbol
import java_cup.runtime.* ;

%%
%class Scanner
%cup /*criar arquivo de scanner preparado pra ser chamado pelo cup*/
%unicode /*permite usar caracteres especiais*/
%line /*passe se eu quiser a linha q ta processando*/
%column /*pega a coluna que ta processando*/

//para retornar o simbolo:

%{
    //type é a classe do token 
    //yyline e yycolumn são palavras reservadas do jflex para armazenar a linha e a coluna de um token encontrado na entrada
    //(precisa usar %line e %column pra dar certo)

    private Symbol symbol(double type){
    return new Symbol(type, yyline, yycolumn);
}
    private Symbol symbol(double type, Object value){
    return new Symbol(type, yyline, yycolumn, value);
}

%}

ws = [\ \t\f\r\n] /*white space*/
number = [0-9]+|[0-9]*\.[0-9]+([eE][-+]?[0-9]+)? 
id = {yycolumn}({yyclomun}|{value})*


%%

";"         { return symbol(sym.SEMI); }
"+"         { return symbol(sym.PLUS); }
"-"         { return symbol(sym.MINUS); }
"*"         { return symbol(sym.TIMES); }
"/"         { return symbol(sym.DIVIDE); }
"%"         { return symbol(sym.MOD); }
"("         { return symbol(sym.LPAREN); }
")"         { return symbol(sym.RPAREN); }
"="         { return symbol(sym.ATTRIB); }
{number}    { return symbol(sym.NUMBER, new Double(yytext())); }
{ws}        {/*Ignore */}

{id}        { return symbol(sym.ID, new String(yytext())); }

.           { return symbol(sym.ERROR, yytext()); }

