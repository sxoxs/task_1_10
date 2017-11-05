package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws  IOException {
        String secStr;

        System.out.println("Введите последовательность символов для поиска слов: ");
        secStr = inConsole().trim();
        writeInFile(containsArrayWord(splitArrayWord(readOutFile()), secStr));
        System.out.println("Работа завершена");
    }

    static String inConsole () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    static ArrayList<String> readOutFile () {
        ArrayList<String> strList = new ArrayList<>();
        String str;

        try (BufferedReader br = new BufferedReader(new FileReader("text_1_10_re.txt")) ) {
            while ( (str = br.readLine()) != null ){
                strList.add(str);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Ошибка открытия файла");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        return strList;
    }

    static void writeInFile (ArrayList<String> arrayStr) throws  IOException{
        try (PrintWriter pw = new PrintWriter("text_1_10_wr.txt")) {
            for (String i : arrayStr){
                pw.println(i);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Ошибка открытия файла");
        }
    }

    static ArrayList<String> splitArrayWord (ArrayList<String> arrayLine) {
        ArrayList<String> arrayWord = new ArrayList<>();

        for (String i : arrayLine) {
            for (String j : i.split(" ")){
                arrayWord.add(j);
            }
        }
        return arrayWord;
    }

    static ArrayList<String> containsArrayWord (ArrayList<String> arrayWord, CharSequence s ) {
        ArrayList<String> arrayContWord = new ArrayList<>();

        for (String i : arrayWord) {
            if (i.contains(s)) {
                arrayContWord.add(i);
            }
        }
        return arrayContWord;
    }

}
