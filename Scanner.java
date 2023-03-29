package mx.ipn.escom.compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private static final Map<String, TipoToken> palabrasReservadas;
    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        /*palabrasReservadas.put("ademas", );
        palabrasReservadas.put("falso", );
        palabrasReservadas.put("para", );
        palabrasReservadas.put("fun", ); //definir funciones
        palabrasReservadas.put("si", );
        palabrasReservadas.put("nulo", );
        palabrasReservadas.put("o", );
        palabrasReservadas.put("imprimir", );
        palabrasReservadas.put("retornar", );
        palabrasReservadas.put("super", );
        palabrasReservadas.put("este", );
        palabrasReservadas.put("verdadero", );
        palabrasReservadas.put("var", ); //definir variables
        palabrasReservadas.put("mientras", );*/
        
    }

    Scanner(String source){
        this.source = source;
    }

    List<Token> scanTokens(){
        //Aquí va el corazón del scanner.
        
        int estado = 0, i = 0;
        char caracter = ", >=, ; () / + - 'Hola esto es una cadena'";
        while (cadena == '\0')
        {
            //------- reconocer >=
            if(estado == 0 && caracter == '>')
            {
                estado = 1;
            }
            if (estado == 1 && caracter == '=')
            {
                estado = 0;
                System.out.println("Se ha encontrado >=");
            }
            else if(estado == 1 && caracter != '=')
            {
                estado = 0;
                System.out.println("Se ha encontrado > ");
            }
            // ----------

            // ------- reconocer <= 
            if (estado == 0 && caracter == '<')
            {
                estado = 2;
            }
            if (estado == 2 && caracter == '=')
            {
                estado = 0;
                System.out.println("Se ha encontrado <=");
            }
            else if( estado == 2 && caracter != '=')
            {
                System.out.println("Se ha encontrado =");
                estado = 0;
            }
            //-------

            // reconocer ==
            if (estado == 0 && caracter == '=')
            {
                estado = 3;
            }
            if (estado == 3 && caracter == '=')
            {
                estado = 0;
                System.out.println("Se ha encontrado ==");
            }
            else if(estado == 3 && caracter != '=')
            {
                estado = 0;
                System.out.println("Se ha encontrado =");
            }
            // --------

            //reconocer ;
            if(estado == 0 && caracter ==';')
            {
                System.out.println("Se ha encontrado ;");
            }
            //----
            //reconocer ,
            if(estado == 0 && caracter ==',')
            {
                System.out.println("Se ha encontrado ,");
            }
            //-------
            //reconocer comillas (se utilizaron comillas simples en vez de dobles para 
            //reconocer una cadena)
            if(estado == 0 && caracter == "'")
            {
                estado = 4;

            }
            if(estado == 4 && caracter == "'")
            {
                estado = 4;
                System.out.println("Se han encontrado se ha encontrado una cadena");
            }
            else if( estado == 4 && caracter != "'")
            {
                estado = 0;
                System.out.println("Se ha encontrado '");
            }
            //------
            //reconocer (
            if(estado == 0 && caracter == '(')
            {
                System.out.println("Se ha encontrado (");
            }
            //----
            //reconocer )
            if (estado == 0 && caracter == ')')
            {
                System.out.println("Se ha encontrado ) ");
            }
            //-------
            //reconocer |
            if(estado == 0 && caracter == '|')
            {
                System.out.println("Se ha encontrado |");
            }
            //-----
            //reconocer *
            if(estado == 0 && caracter == '*')
            {
                System.out.println("Se ha encontrado *");
            }
            // ------
            //reconocer +
            if(estado == 0 && caracter =='+')
            {
                System.out.println("Se ha encontrado +");
            }
            // -----
            //reconocer -
            if(estado == 0 && caracter == '-')
            {
                System.out.println("Se ha encontrado -");
            }
            //-----
            // reconocer /
            if(estado == 0 && caracter == '/')
            {
                System.out.println("Se ha encontrado /");
            }
            i++;
        }
        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF, "", null, linea));
        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */