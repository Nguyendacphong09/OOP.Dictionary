import java.util.Scanner;

public class mainTest {
    public static void main(String[] args) {
        DictionaryManagement dictionary = new DictionaryManagement();
        DictionaryCommandline test = new DictionaryCommandline();
        dictionary.insertFromFile();

        System.out.println("--------TỪ ĐIỂN ANH-VIỆT------");
        System.out.println("Nhập lựa chọn");
        System.out.println("1.Tra cứu từ");
        System.out.println("2.Thêm từ mới vào từ điển");
        System.out.println("3.Xóa từ khỏi từ điển");
        System.out.println("4.Sửa từ vựng trong từ điển");
        System.out.println("5.kiểm tra hàm search");
        System.out.println("6.In từ điển ra file");
        System.out.println("7.In ra danh sách từ vựng");
        Scanner scan = new Scanner(System.in);
        int chose = scan.nextInt();
        switch (chose){
            case 1: {
                dictionary.dictionaryLookup();
                break;
            }
            case 2: {
                dictionary.addWord();
                break;
            }
            case 3:{
                dictionary.deleteWord();
                break;
            }
            case 4:{
                dictionary.repairWord();
                break;
            }
            case 5:{
                test.dictionarySearcher();
                break;
            }
            case 6:{
                dictionary.dictionaryExportToFile();
                break;
            }
            case 7:{
                test.showAllWord();
                break;
            }
        }
    }
}
