package com.mycompany.project08;
import java.util.*;

public class Project08 {
    
    // function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // function to check if a number has digit 3
    public static boolean hasDigit3(int n) {
        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        SinglyLinkedList<Integer> primeList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> digit3List = new SinglyLinkedList<>();
        
        // populate prime numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                primeList.addLast(i);
            }
        }
        
        // move prime numbers that have digit 3 to digit3List
        SinglyLinkedList.Node<Integer> curr = primeList.head();
        while (curr != null) {
            if (hasDigit3(curr.data())) {
                digit3List.addLast(curr.data());
                primeList.remove(curr);
            } else {
                curr = curr.next();
            }
        }
        
        // calculate sum of numbers in digit3List
        int sum = 0;
        curr = digit3List.head();
        while (curr != null) {
            sum += curr.data();
            curr = curr.next();
        }
        
        System.out.println("Sum of prime numbers with digit 3 between 0 and " + n + " is " + sum);
    }
}
