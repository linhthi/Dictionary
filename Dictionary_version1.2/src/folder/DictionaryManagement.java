package folder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class DictionaryManagement {
 
    Dictionary myDictionary = new Dictionary();
     /**
     * The method use show all the word in dictionary
     */
    public void showAllWord() {
        int count = 1;
        System.out.println("No   | English \t | Vietnamese ");
        for (Word i : Dictionary.listWord) {
            System.out.println(count+ "   |"  + i.getWord_target() +"\t | " + i.getWord_explain());
            count++;
        }
    }
    /**
     * This method use insert list word from command line
     * No parameter and return void
     */
    
    public void insertFromCommandLine() {
        
        Scanner scan = new Scanner(System.in);
        int numberOfWord;
        System.out.println("Nhap so tu:");
        numberOfWord = Integer.parseInt(scan.nextLine());
        
        for (int i=0; i<numberOfWord; i++) {
            Word _word = new Word();
            System.out.print(i+1 + "\nNhap tu tieng anh: ");
            _word.setWord_target(scan.nextLine());
            System.out.print("Nghia cua no la: ");
            _word.setWord_explain(scan.nextLine());
            Dictionary.listWord.add(_word);
        }
    }
    /**
     * This method use insert list Word from my file text
     * No parameter and return void
     * @throws FileNotFoundException 
     */
    public void insertFromFile() throws FileNotFoundException {
        
        Scanner scan = new Scanner(new File("dictionary_eng_vie.txt"));
        while (scan.hasNext()){
            String stringWord = scan.nextLine();
                //trong file co dinh dang: phan cach giua tu va giai nghia la dau tab
                // Su dung phương thuc useDelimiter() de dinh dang nhap vao
                Scanner s = new Scanner(stringWord).useDelimiter("\t");
            Word _word = new Word();
            _word.setWord_target(s.next());
            _word.setWord_explain(s.next());
            Dictionary.listWord.add(_word);
        }
    }
    /**
     * find the word in the dictionary and show it's mean
     * return void
     */
    public void dictionaryLookup(){
        String a ;
        System.out.println("Ban hay nhap tu muon tra:");
        Scanner scan = new Scanner(System.in);
        a = scan.nextLine();
        Dictionary.listWord.stream().filter((i) -> (i.getWord_target().equals(a))).forEachOrdered((i) -> {
            System.out.println(a + " means :" + i.getWord_explain());
        });
        
    }
    /**
     * The method puts all the word 
     * of current dictionary in File "DictionaryNow.txt"
     * @throws java.io.FileNotFoundException
     */
    public void dictionaryExportToFile() throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream("DictionaryNow.txt");
        try (BufferedOutputStream bout = new BufferedOutputStream(fout)) {
            for (Word i: Dictionary.listWord) {
                String line = i.getWord_target()+"\t" + i.getWord_explain();
                bout.write(line.getBytes());
                bout.write(System.lineSeparator().getBytes()) ;
            
            }
        }
    }
     //Ham them mot tu tu command line
    public void insertWord() throws FileNotFoundException, IOException {
        System.out.println("Nhap tu can them vao:");
        Scanner scan = new Scanner(System.in);
        String stringWord = scan.nextLine();
        boolean check = false;
        for (Word i: Dictionary.listWord) {
            if (i.getWord_target().equalsIgnoreCase(stringWord)) {
                System.out.println("Tu nay co trong tu dien roi ma:");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Nhap nghia cua tu nay:");
            String explain = scan.nextLine();
            Dictionary.listWord.add(new Word(stringWord, explain));
            System.out.println("Them tu thanh cong!");
        }
        
    }
    //Ham xoa mot tu tu command line
    public void removeWord() {
        String word_target;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap tu ban muon xoa");
        word_target = scan.nextLine();
        boolean check = false;
        for(Word i: Dictionary.listWord) {
            if (i.getWord_target().equalsIgnoreCase(word_target)) {
                Dictionary.listWord.remove(i);
                check = false;
            }
        }
        if (check) {
            System.out.println("Xoa thanh cong");
        }
        else {
            System.out.println("Khong co tu nay trong tu dien");
        }
    }
    //Ham sua du lieu tu command line
    public void editWord() {
        System.out.println("Nhap tu can sua:");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        boolean check = false;
        for (Word i: Dictionary.listWord) {
            if ( i.getWord_target().equalsIgnoreCase(word)) {
                System.out.println("Ban muon sua tu thanh: ");
                String target = scan.nextLine();
                i.setWord_target(target);
                System.out.println("Nhap nghia ma ban muon sua:");
                String explain = scan.nextLine();
                i.setWord_explain(explain);
                check = true;
                break;
        }
        }
        if (!check) {
            System.out.println("Khong co tu nay trong tu dien");
        }
        
    }
    public void dictionarySeacher() {
        System.out.println("Nhap tu ban can tra: ");
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        System.out.println("Cac tu bat dau tu " + s + " la: ");
        Dictionary.listWord.forEach((i) -> {
            int index = i.getWord_target().indexOf(s);
            if (index == 0) {
                System.out.println(i.getWord_target() + "\t|" + i.getWord_explain());
            }
        });
    }
}
