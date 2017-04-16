package com.salon;


import com.salon.entity.ParkingCeo;

import java.util.Scanner;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    private ParkingCeo parkingCeo = null;

    public App() {
        init();
    }

    public void init(){
        parkingCeo = new ParkingCeo("");
    }


    /*
    1.  init query allocateParkCar takeCar toXML
    2.  login root password
    3.  query / packManager / allocateParkCar / takeCar / toXML
    4.          packBoy
    5.          packLot
    6.
    */


    /*
    1.  init
    2.  login root password
    3.  query / packManager / allocateParkCar / takeCar / toXML
    4.          packBoy
    5.          packLot
    6.
    */

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("int")) {
                System.out.println(">>>" + line);

            }
            /**************************************************/
            else if (line.equals("login ceo")) {
                System.out.println(">>>" + line);

            }
            else if (line.equals("login manager name")) {
                System.out.println(">>>" + line);

            }
            else if (line.equals("login boy name")) {
                System.out.println(">>>" + line);

            }
            /**************************************************/
            else if (line.equals("query")) {
                System.out.println(">>>" + line);

            }
            /**************************************************/
            else if (line.equals("pack")) {
                System.out.println(">>>" + line);

            }

            /**************************************************/
            else if (line.equals("allocatePark")) {
                System.out.println(">>>" + line);

            }
            /**************************************************/
            else if (line.equals("takeCar")) {
                System.out.println(">>>" + line);

            }
            else if (line.equals("exit")) {
                System.out.println(">>>" + line);

                System.out.println(">>>byte!");
                break;
            }
            System.out.println(">>>" + line);
        }
    }
}
