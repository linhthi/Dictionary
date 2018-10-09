/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.*;
/**
 *
 * @author HIEPATK
 */
public class DictionaryManagement {
    private Word insertWord(){
        Word new_word = new Word();
        System.out.print("Nhap tu: ");
        Scanner scan = new Scanner(System.in);
        new_word.setTarget(scan.nextLine());
        System.out.print("\nNhap nghia: ");
        new_word.setExplain(scan.nextLine());
         return new_word;
    }
    public Dictionary insertFromCommandline(){
        Dictionary list = new Dictionary();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nSo luong tu muon nhap: ");
        int count = scan.nextInt();
        int i = 0;
         while(i<count)
         {  
            System.out.println(i + 1);
            list.word.add(insertWord());
            i++;
         }
         return list;
     }
    }
