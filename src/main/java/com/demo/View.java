package com.demo;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Controller c = new Controller();
        System.out.println("Select any one option:(Enter the Option number)");
        System.out.println("1. Add a new Phone");
        System.out.println("2. Remove a phone");
        System.out.println("3. Update the price");
        System.out.println("4. View the catalogue");

        int input = scan.nextInt();
        switch (input) {
            case 1:
                c.add();
                break;
            case 2:
                c.remove();
                break;
            case 3:
                c.update();
                break;
            case 4:
                c.view();
                break;
        }
    
}

}


