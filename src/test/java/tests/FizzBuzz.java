package tests;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        List listaCyfr = new ArrayList<Integer>();
        String fizz = "Fizz";
        String buzz = "Buzz";


        for(int i=0; i<=100; i++){
            listaCyfr.add(i);
        }

        for(int i=0; i< listaCyfr.size(); i++){
            if(i%3==0 && i%5==0){
                System.out.println(fizz + buzz);
            }
            else if(i%3==0){
                System.out.println(fizz);
            }
            else if(i%5==0){
                System.out.println(buzz);
            }
            else{
                System.out.println(i);
            }
        }



    }


}
