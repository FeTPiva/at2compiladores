
package parser;

import java.io.InputStreamReader;

/**
 *
 * @author Fezitcha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //o construtor do parser nescessita de  um objeto do tipo scanner
        Parser parser = new Parser(new Scanner(new InputStreamReader(System.in)));
        
                
        try{
            //executa o parser
            parser.parse();
        }catch(Exception e){
            System.out.println("erro: "+ e.getMessage());
        }
        
        
        
    }
    
}
