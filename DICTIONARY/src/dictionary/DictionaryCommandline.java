/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DictionaryCommandline {
     public void showAllWord() {
        int sizeArrWord = Dictionary.arrWord.size();
        if (Dictionary.arrWord.isEmpty()) {
            System.out.println("Từ điển trống!!!");
        } else {
            System.out.printf("%-10s%-2s%-20s%-2s%-20s\n", "No", "|", "English", "|", "Vietnamese");
            for (int i = 0; i < sizeArrWord; i++) {
                System.out.printf("%-10s%-2s%-20s%-2s%-20s\n", i + 1, "|", Dictionary.arrWord.get(i).getWord_target(), "|", Dictionary.arrWord.get(i).getWord_explain());
            }
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement repeat = new DictionaryManagement();
        repeat.insertFromCommandline();
        this.showAllWord();
    }

    public void dictionaryAdvanced() {
        DictionaryManagement repeat = new DictionaryManagement();
        repeat.insertFromFile();
        this.showAllWord();
      //  repeat.dictionaryLookup();
    }

    public char ASC(char a) {
        char b = a;
        if ((a > 64) && (a < 91)) {
            return (char) (b + 32);
        }
        return b;
    }

    public void dictionarySearcher() {
        Scanner scan = new Scanner(System.in);
        System.out.println("--------Search---------");
        System.out.println("Nhập từ cần tìm: ");
        ArrayList<Word> arrWordcpy = Dictionary.arrWord;
        while (arrWordcpy.size() != 0 && arrWordcpy.size() != 1) {
            String input = scan.nextLine();
            for (int i = 0; i < Dictionary.arrWord.size(); i++) {
                int lw = Dictionary.arrWord.get(i).getWord_target().length();
                int linput = input.length();
                int min;
                if (linput > lw) {
                    min = lw;
                } else {
                    min = linput;
                }
                for (int j = 0; j < min; j++) {
                    if ((ASC(input.charAt(j)) != ASC(Dictionary.arrWord.get(i).getWord_target().charAt(j))) || (linput > lw)) {
                        arrWordcpy.remove(arrWordcpy.get(i));
                        i--;
                        break;
                    }
                }
            }
            for (int k = 0; k < arrWordcpy.size(); k++) {
                System.out.println(arrWordcpy.get(k).getWord_target());
            }
        }

    }
}
