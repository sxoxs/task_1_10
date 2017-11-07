package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws  IOException {
        String secStr;
        ArrayList<String > lineList;
        ArrayList<String > wordList;

        System.out.println("Введите последовательность символов для поиска слов: ");
        secStr = inConsole().trim();
        lineList = readOutFile();
        wordList = splitArrayWord(lineList);
        writeInFile(containsArrayWord(wordList, secStr));
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
            for (String line : arrayStr){
                pw.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Ошибка открытия файла");
        }
    }

    static ArrayList<String> splitArrayWord (ArrayList<String> arrayLine) {
        ArrayList<String> arrayWord = new ArrayList<>();

        for (String line : arrayLine) {
            for (String word : line.split(" ")){
                arrayWord.add(word);
            }
        }
        return arrayWord;
    }

    static ArrayList<String> containsArrayWord (ArrayList<String> arrayWord, CharSequence sequence ) {
        ArrayList<String> arrayContWord = new ArrayList<>();

        for (String word : arrayWord) {
            if (word.contains(sequence)) {
                arrayContWord.add(word);
            }
        }
        return arrayContWord;
    }

}
