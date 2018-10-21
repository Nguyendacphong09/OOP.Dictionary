/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dictionary.Dictionary;
import dictionary.DictionaryCommandline;
import dictionary.Word;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class Seacher {
    DefaultListModel<String> listModelsearch ;
     public void search(String seachString){
           listModelsearch = new DefaultListModel<>();
           DictionaryCommandline d = new DictionaryCommandline();
          for (Word arrWord : Dictionary.arrWord) {
             String seach = arrWord.getWord_target().toString().toLowerCase();
             if(seach.contains(seachString.toLowerCase() )  ){
                 listModelsearch.addElement(arrWord.getWord_target() );  
             }
        }        
    }
    
}
