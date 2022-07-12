import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner harf = new Scanner(System.in);
        System.out.println("Harf sayisini giriniz");
        int harfSayisi = harf.nextInt();

        Scanner scanner = new Scanner(new File("C:\\Java\\AdamAsmaca\\Kelimeler.txt"));
        List<String> words = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        System.out.println("Secilen Kelime  : "+word);

        List<Character> oyuncuTahmini = new ArrayList<>();

        kelimeYazdırma(word,oyuncuTahmini);

        System.out.println("Harf tahmin edin : ");
        String kelimeTahmini = keyboard.nextLine();
        oyuncuTahmini.add(kelimeTahmini.charAt(0));

        kelimeYazdırma(word,oyuncuTahmini);
        while(true){
            System.out.println("Bildiniz!");
            kullanıcıdanKelimeAlma(keyboard,word,oyuncuTahmini);
            if(kelimeYazdırma(word, oyuncuTahmini)){
                break;
            }


            if(keyboard.nextLine().equals(word)){
                System.out.println("Kazandınız");
                break;
            }
            else {
                for(int j=10;j<=0;j--){
                    System.out.println("Bilemediniz.");
                    System.out.print(j+"hakkiniz kaldi");
                }

            }
        }
        System.out.println("Kazandiniz");
    }
private static boolean kelimeYazdırma (String word,List<Character>oyuncuTahmini){
        int dogruHarf=0;
        for (int i=0;i<word.length();i++){
        if(oyuncuTahmini.contains(word.charAt(i))){
            System.out.print(word.charAt(i));
            dogruHarf++;
        }
        else {
            System.out.print("_");
        }
    }
    System.out.println();
    return (word.length()==dogruHarf);
}
private static void kullanıcıdanKelimeAlma(Scanner keyboard, String word, List<Character> oyuncuTahmini) {
    System.out.println("Enter a letter");
    String kelimeTahmini = keyboard.nextLine();
    oyuncuTahmini.add(kelimeTahmini.charAt(0));

    }

}
