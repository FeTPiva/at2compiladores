/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Fezitcha
 */
public class HashTableTest {
       Hashtable <String, Double > tabela = new Hashtable<>();
         
       {
        tabela.put("temp", 3.14);
       tabela.put("temp", -333.3);
       
       System.out.println(tabela.get("temp"));
       if(!tabela.containsKey("x")){
           System.out.println("contem");
                  }
       
       if(!tabela.containsKey("zz")){
           System.out.println("n contem");
       }
       //Alterar um simbolo
       tabela.put("x", 12.56);
       System.out.println("x");
       }
       
       
       //isso aki é pro item do cos e sin exp
        Vector <String > reserved = new Vector<>();
        
        {
        reserved.add("sin");
        reserved.add("cos");
        reserved.add("exp");
        
        
                }
       
}


class Parserr{
    
 public enum sym{SIN, COS, EXP};
 
   
   Hashtable <String, sym > reserved = new Hashtable<>();
        
        { reserved.put("sin",sym.SIN);
        reserved.put("cos", sym.COS);
        reserved.put("exp", sym.EXP);
        
        
        
                        }
            
}