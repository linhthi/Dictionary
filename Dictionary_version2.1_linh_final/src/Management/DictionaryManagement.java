package Management;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DictionaryManagement {
    // Them model vao de luu cac key de show ra list cac tu tren ma hinh
    //public static DefaultListModel<String> model = new DefaultListModel<>();
    
    
    // Them tu tu trong file
    public void insertFromFile(String pathFile) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(pathFile));
        while (scan.hasNext()){
            String target = scan.nextLine();
            String explain = scan.nextLine();
            Dictionary.hashMap.put(target, explain);
            //model.addElement(target);
        }
    }
    
    // Them tu vao trong tu dien
    public void addWord(String target, String explain) {
        Dictionary.hashMap.put(target, explain);
        //model.addElement(target);
    }
    
    // Xoa tu ra khoi tu dien
    public void removeWord(String target) {
        Dictionary.hashMap.remove(target);
        //model.removeElement(target);
    }
    
    // Sua tu trong tu dien
    public void modifyWord(String target, String explain) {
        Dictionary.hashMap.replace(target, explain);
        
    }
    
    //Tim mot tu trong tu dien
    public boolean dictionaryLookUp(String target) {
        return (Dictionary.hashMap.get(target) != null);

    }
    
    
    // In cac tu trong tu dien vao file
    public void dictionaryExportToFile() throws FileNotFoundException, IOException {
        
        FileOutputStream fout = new FileOutputStream("data_Now.txt");
        try (BufferedOutputStream bout = new BufferedOutputStream(fout)) {
            Set set = Dictionary.hashMap.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry)iterator.next();
                String line = mentry.getKey() + "\n" + mentry.getValue();
                bout.write(line.getBytes());
                bout.write(System.lineSeparator().getBytes());
            }
        }
}
}
