import java.lang.*;
import java.lang.Math.*;

public class Test implements CharSequence {
    private String string;
    Test(String string){
        this.string = string;
    }

    public char charAt(int index){
        return string.charAt(index);
    }

    public int length(){
        return string.length();
    }

    public String toString(){
        return this.string;
    }

    public int abs(int a){
        return (a >= 0 ? a : -a);
    }    

    public Test subSequence(int start, int end){
        int len = abs(end - start) + 1;
        char[] sequence = new char[len];
        if(start <= end){
            int pos = 0;
            for(int i = start; i<= end; i++){
                sequence[pos++] = string.charAt(i);
            }
            return new Test(new String(sequence));
        }
        else{
            int pos = 0 ;
            for(int i = start; i >= end; i--){
                sequence[pos++] = string.charAt(i);
            }
            return new Test(new String(sequence));
        }
    }

    public void print(){
        System.out.println(string);
    }

    public void printBackward(){
        int start = this.length() - 1;
        int end = 0;
        this.subSequence(start,end).print();
    }

    public static void main(String[] args){
        Test charSequence = new Test("Hello from the other side");
        charSequence.printBackward();
        System.out.println(charSequence.charAt(0));
        System.out.println(charSequence.length());
        System.out.println(charSequence.toString());
        System.out.println(charSequence.subSequence(5,9).toString());
    }
}