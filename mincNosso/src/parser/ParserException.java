/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 * Classe que sinaliza uma exceção do parser
 * 
 * @author Marco AFS
 *
 */
public class ParserException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constrói uma exceção de parser a partir de uma mensagem
     * 
     * @param msg
     *            mensagem referente à exceção
     */
    public ParserException(String msg) {
        super(msg);
    }
}

