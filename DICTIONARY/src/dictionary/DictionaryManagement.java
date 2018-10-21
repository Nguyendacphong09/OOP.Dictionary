/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DictionaryManagement {
    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Thêm từ mới----------");
        System.out.println("Nhập số lượng từ vựng muốn thêm:");
        int numAdd = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numAdd; i++) {
            Word input = new Word();
            System.out.println("Nhập từ tiếng anh:");
            input.setWord_target(scan.nextLine());
            System.out.println("Nhập từ giải nghĩa:");
            input.setWord_explain(scan.nextLine());
            Dictionary.arrWord.add(input);
        }
    }

    public void insertFromFile() {
     
      try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("dictionaries.txt"), "UTF-8"));
       
            String s ;
            while ((s = bufferedReader.readLine())!=null){
                Word word = new Word();
                  
               word.setWord_target(s.substring(0, s.indexOf("\t")));
               
                word.setWord_explain(s.substring(s.indexOf("\t") + 1));
                Dictionary.arrWord.add(word);     
            }
            bufferedReader.close();
        }catch (Exception e){System.out.print(e);}
    }

    public char ASC(char a) {
        char b = a;
        if ((a > 64) && (a < 91)) {
            return (char) (b + 32);
        }
        return b;
    }

    public boolean same(String a, Word b) {
        int min;
        if (a.length() >= b.getWord_target().length()) {
            min = b.getWord_target().length();
        } else {
            min = a.length();
        }
        for (int i = 0; i < min; i++) {
            if ((int) ASC(a.charAt(i)) != (int) ASC(b.getWord_target().charAt(i))) {
                return false;
            }
        }
        return true;
    }

     public String dictionaryLookup(String taget) {
       
       String resufl =" " ;
        for (int i = 0; i < Dictionary.arrWord.size(); i++) {
            if ((same(taget, Dictionary.arrWord.get(i))) && (taget.length()
                    == Dictionary.arrWord.get(i).getWord_target().length())) {
                resufl = Dictionary.arrWord.get(i).getWord_explain();
                break;
            }
        }
       return resufl ;
    }


    public void addWord(String E , String TV) {
            Word input = new Word();
            input.setWord_target(E);
            input.setWord_explain(TV);
            Dictionary.arrWord.add(input);
    }
     public void deleteWord(String delete) {
              for (int j = 0; j < Dictionary.arrWord.size(); j++) {
                if (delete.equalsIgnoreCase(Dictionary.arrWord.get(j).getWord_target())) {
                    Dictionary.arrWord.remove(Dictionary.arrWord.get(j));
                    
                }
            }
     }

     public void repairWord(String Oldword ,String repair , String newexplain) {
          for (int j = 0; j < Dictionary.arrWord.size(); j++) {
                if (Oldword.equalsIgnoreCase(Dictionary.arrWord.get(j).getWord_target())) {
                    Dictionary.arrWord.get(j).setWord_target(repair);
                    Dictionary.arrWord.get(j).setWord_explain(newexplain);  
                }
            }
         
    }

    public void dictionaryExportToFile(File a , ArrayList<Word> b) {
        try{
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("dictionaries.txt"), "UTF-8"));
              for (int i = 0; i < b.size(); i++) {
                writer.write(b.get(i).getWord_target() + "\t" + b.get(i).getWord_explain()+ "\n");
            }
            writer.close();
        }catch (Exception e){}
}
    }
    
