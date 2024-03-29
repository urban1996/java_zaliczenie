//AUTORZY:
//WIKTORIA BROL
//BARTOSZ URBAŃSKI
//INFORMATYKA NIESTACJONARNE ROK II

import java.io.*;

public class Main {


    private static final String filepath = "D:\\auta_folder\\auta.txt"; //sciezka do pliku na sztywno

    public static void main(String[] args) {
        try {

            //tworzenie i inicjalizacja obiektow

            Samochod samochod = new Samochod("Toyota", "Rav2", 1995, 7500);
            Samochod samochod1 = new Samochod("Toyota", "Rav3", 1997, 5000);
            SamochodOsobowy samochodOsobowy = new SamochodOsobowy("Toyota", "Rav1", 1992, 10000, 5, 2500, 5);

            System.out.println(samochod.Informacje());
            System.out.println(samochod1.Informacje());
            System.out.println(samochodOsobowy.Informacje());

            //wyswietlanie w konsoli dla pewnosci ze jest okej



            Main objectIO = new Main();

            Thread thread = new Thread(() -> //nowy watek ktory zapisuje do pliku
            {
                System.out.println("Thread start");
                objectIO.WriteObjectToFile(samochod.toString());
                objectIO.WriteObjectToFile(samochod1.toString());
                objectIO.WriteObjectToFile(samochodOsobowy.toString());

            });



            thread.start(); //zaczynamy watek
            thread.interrupt(); // konczymy watek



        } catch (Exception e) {
            System.out.print(e);
        }


    }

    public void WriteObjectToFile(Object serObj) //metoda do zapisywania do pliku naszych obiektow
    {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
