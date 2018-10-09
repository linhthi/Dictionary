/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.*;
import java.io.*;
/**
 *
 * @author HIEPATK
 */
public class DictionaryCommandline {
    public void showAllWords(Dictionary list){
        int i = 0;
        System.out.println("No\t\t|Eng\t\t|Vie");
        while(i<list.word.size()){
            i++;
            Word tmp = (Word) list.word.get(i-1);
            System.out.println(i + "\t\t| " + tmp.getTarget() + "\t\t|" + tmp.getExplain());
        }
    }
    public void DictionaryBasic(){
        DictionaryManagement new_management = new DictionaryManagement();
        Dictionary book = new_management.insertFromCommandline();
        DictionaryCommandline new_cmd = new DictionaryCommandline();
        new_cmd.showAllWords(book);
    }
}

