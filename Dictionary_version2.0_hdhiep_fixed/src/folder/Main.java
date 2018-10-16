
package folder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DictionaryCommandLine newCommandLine = new DictionaryCommandLine();
        newCommandLine.dictionaryBasic();
        newCommandLine.dictionaryAdvanced();
    }

}
