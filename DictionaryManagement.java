import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        File file = new File("dictionaries.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = reader.readLine()) != null) {
                Word word = new Word();
                word.setWord_target(str.substring(0, str.indexOf("\t")));
                word.setWord_explain(str.substring(str.indexOf("\t") + 1));
                Dictionary.arrWord.add(word);
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file!!!" + e);
        }
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

    public void dictionaryLookup() {
        System.out.println("-----------Look Up-----------");
        System.out.println("Nhập từ cần tra cứu: ");
        Scanner scan = new Scanner(System.in);
        String wordLookUp = scan.nextLine();
        int temp = 0;
        for (int i = 0; i < Dictionary.arrWord.size(); i++) {
            if ((same(wordLookUp, Dictionary.arrWord.get(i))) && (wordLookUp.length() == Dictionary.arrWord.get(i).getWord_target().length())) {
                temp++;
                System.out.println("Nghĩa của từ vừa nhập là: " + Dictionary.arrWord.get(i).getWord_explain());
            }
        }
        if (temp == 0) {
            System.out.println("Không tìm thấy từ này!!!");
        }
    }

    public void addWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Thêm từ mới----------");
        System.out.println("Nhập số lượng từ vựng muốn thêm:");
        int numAdd = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numAdd; i++) {
            Word input = new Word();
            System.out.println("Nhập từ tiếng anh muốn thêm:");
            input.setWord_target(scan.nextLine());
            System.out.println("Nhập từ giải nghĩa:");
            input.setWord_explain(scan.nextLine());
            Dictionary.arrWord.add(input);
            System.out.println("Đã thêm từ: " + input.getWord_target() + " vào từ điển." );
        }
    }

    public void deleteWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Xoá----------");
        System.out.println("Nhập số lượng từ vựng muốn xoá:");
        int numDelete = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numDelete; i++) {
            System.out.println("Nhập từ cần xóa: ");
            String delete = scan.next();
            int temp = 0;
            for (int j = 0; j < Dictionary.arrWord.size(); j++) {
                if ((same(delete, Dictionary.arrWord.get(j))) && (delete.length() == Dictionary.arrWord.get(j).getWord_target().length())) {
                    temp++;
                    //System.out.println(Dictionary.arrWord.get(j).getWord_target() + " " + delete.length());
                    System.out.println("Đã xóa từ: " + Dictionary.arrWord.get(j).getWord_target());
                    Dictionary.arrWord.remove(Dictionary.arrWord.get(j));
                }
            }
            if (temp == 0) {
                System.out.println("Không tìm thấy từ này!!!");
            }
        }
    }

    public void repairWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------Sửa từ vựng----------");
        System.out.println("Nhập số lượng từ vựng muốn sửa:");
        int numRepair = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numRepair; i++) {
            System.out.println("Nhập từ cần sửa: ");
            String repair = scan.next();
            int temp = 0;
            for (int j = 0; j < Dictionary.arrWord.size(); j++) {
                if (repair.equalsIgnoreCase(Dictionary.arrWord.get(j).getWord_target())) {
                    temp++;
                    System.out.println("Nhập nghĩa mới của từ: ");
                    scan.nextLine();
                    Dictionary.arrWord.get(j).setWord_explain(scan.nextLine());
                    System.out.println("Đã sửa từ: " + Dictionary.arrWord.get(j).getWord_target());
                }
            }
            if (temp == 0) {
                System.out.println("Không tìm thấy từ này!!!");
            }
        }
    }

    public void dictionaryExportToFile() {
        File file = new File("outdictionary.txt");
        try (PrintWriter print = new PrintWriter(file)) {
            for (int i = 0; i < Dictionary.arrWord.size(); i++) {
                print.println(Dictionary.arrWord.get(i).getWord_target() + "\t" + Dictionary.arrWord.get(i).getWord_explain());
            }
            System.out.println("In ra file thành công");
        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình ghi ra file");
        }
    }
}
