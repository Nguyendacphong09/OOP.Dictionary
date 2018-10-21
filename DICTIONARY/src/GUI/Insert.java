/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dictionary.DictionaryManagement;
import dictionary.Word;
import dictionary.Dictionary;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class Insert {
    DefaultListModel<String> listModeltaget ;
    public void insertFile(){
        listModeltaget = new DefaultListModel<>();
        DictionaryManagement d = new DictionaryManagement();
        d.insertFromFile(); 
        for (Word aWord : Dictionary.arrWord) {
            listModeltaget.addElement(aWord.getWord_target());
        }
    }
}
