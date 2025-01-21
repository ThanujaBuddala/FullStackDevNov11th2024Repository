package excel;

public class ReverseEachWord
{
    public static void main(String[] args)
    {
        reverseWord();
    }
    private static void reverseWord()
    {
        String s="Banglore is a Garden City";
        String words[]=s.split(" ");
        String str="  ";
        for(String word:words) {
            str += new StringBuilder(word).reverse().toString()+" ";
        }
        System.out.println(str);
    }
}
