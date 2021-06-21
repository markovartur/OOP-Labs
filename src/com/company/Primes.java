package com.company;

public class Primes {
    public static void main(String[] args) {  //точка входа
        for(int i=2; i<100; i++) {  //циклично задаёт числа для проверки
            //System.out.println(isPrime(5));
            isPrime(i);
        }
    }
    public static boolean isPrime(int n)  //метод проверяет, являются ли числа из диапазона простыми
    {
        for (int i = 2; i<n; i++){
            if (n%i == 0){
                return false;
            }
            //else{System.out.println(n + " ");}
        }
        System.out.print(n + " ");
        return true;
    }
}




