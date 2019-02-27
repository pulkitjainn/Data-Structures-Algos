Data Structutes and Algos -- CB


//Q Take as input a number N, print "Prime" if it is prime if not Print "Not Prime".

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                System.out.print("Not Prime");
                return ;
            }
        } 
        System.out.print("Prime");
        return ;
    }
}

//Q Take N as input, Calculate it's reverse also Print the reverse.


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        StringBuilder s = new StringBuilder(String.valueOf(n));
        s.reverse();
        System.out.print(s);
        return ;
    }
}


//Q Take N as input. Print all prime numbers from 2 to N.


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int j=2;j<=m;j++){
            if(checkPrime(j)){
                System.out.println(j);
            }
        }
        return;
    }
    
    public static boolean checkPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        } 
        return true;
    }
}


// Q  GCD


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a,b));
        return;
    }
    
    public static int gcd(int a,int b){
        if(a==0 || b==0){
            return 0;
        }
        if(a==b){
            return a;
        }
        if(a>b){
            return gcd(a-b,b);
        }
        else if(a<b){
            return gcd(b-a,a);
        }
        return a;
    }
}


// Q LCM

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int g = gcd(a,b);
        System.out.println(a*b/g);
        return;
    }
    public static int gcd(int a,int b){
        if(a==0 || b==0){
            return 0;
        }
        if(a==b){
            return a;
        }
        if(a>b){
            return gcd(a-b,b);
        }
        else if(a<b){
            return gcd(b-a,a);
        }
        return a;
    }
}

// Q. Take N as input. Print the sum of its odd placed digits and sum of its even placed digits.


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        int e=0;
        int o=0;
        while(n>0){
            if(i%2==0){
                e = e + n%10;
            }else{
                o = o + n%10;
            }
            n = n/10;
            i++;
        }
        System.out.println(o);
        System.out.println(e);
    }
}

// Q. IS ARMSTRONG NUMBER


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nn =n;
        int num=0;
        while(n>0){
            int g = n%10;
            num = num + (g*g*g);
            n = n/10;
        }
        if(num == nn){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        return ;
    }
}

// Q. PRINT ARMSTRONG NUMBERS


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i =a;i<=b;i++){
            if(checkAm(i)){
                System.out.println(i);
            }
        }
        return;
    }
    
    public static boolean checkAm(int n){
        int nn =n;
        int num=0;
        while(n>0){
            int g = n%10;
            num = num + (g*g*g);
            n = n/10;
        }
        if(num == nn){
            return true ;
        }
        return false;
    }
}


// Q SWAP TWO ELEMENTS( DATA, DATA)


public void swapNodes(int num1, int num2) {
    
    Node node1 = head;

    while(node1!=null && node1.data!=num1){
        node1=node1.next;
    }
    int d1 = node1.data;
    
    Node node2 = head;

    while(node1!=null && node2.data!=num2){
        node2=node2.next;
    }
    int d2 = node2.data;
    
    node1.data = d2;
    node2.data = d1;
}


// Q MID-POINT


public int mid() {
    Node slow = head;
    Node fast = head;
    
    while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow.data;
}


// Q ARRAYS-MAX VALUE IN ARRAY


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = -1000000000 ;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,sc.nextInt());
        }
        System.out.println(ans);
        return;
    }
}


// Q ARRAYS-REVERSE AN ARRAY


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =n-1;i>-1;i--){
            System.out.println(arr[i]);
        }
        return;
    }
}