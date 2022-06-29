package application;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        sc.nextLine();
        Date checkin = sdf.parse(sc.nextLine());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.nextLine());

        Reservation reservation = new Reservation(roomNumber, checkin, checkout);

        System.out.println(reservation + "\n");

        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        sc.nextLine();
        checkin = sdf.parse(sc.nextLine());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkout = sdf.parse(sc.nextLine());

        reservation.updateDates(checkin, checkout);

        System.out.println(reservation + "\n");
    }
}