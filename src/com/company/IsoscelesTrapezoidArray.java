package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IsoscelesTrapezoidArray implements IArrayList, Serializable {
    public ArrayList<IsoscelesTrapezoid> isoscelesTrapezoidArrayList = new ArrayList<>();

    public void add(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.isoscelesTrapezoidArrayList.add(new IsoscelesTrapezoid(x1, y1, x2, y2, x3, y3, x4, y4));
    }

    public Quadrangle get(int index) {
        return this.isoscelesTrapezoidArrayList.get(index);
    }

    public Quadrangle remove(int index) {
        return this.isoscelesTrapezoidArrayList.remove(index);
    }

    public void clear() {
        this.isoscelesTrapezoidArrayList.clear();
    }

    @Override
    public String toString() {
        return isoscelesTrapezoidArrayList.toString();
    }

    public void save(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(outStream);
        for (IsoscelesTrapezoid trapezoid : isoscelesTrapezoidArrayList) {
            try {
                bufferedWriter.write(String.valueOf(trapezoid.pointA.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointA.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointB.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointB.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointC.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointC.getY()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointD.getX()));
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(trapezoid.pointD.getY()));
                bufferedWriter.write(System.lineSeparator());
            } catch (IOException IOexception) {
                System.out.println("An I / O error has occurred");
            }
        }
        bufferedWriter.close();
        outStream.close();
    }

    public void load(String filename) throws IOException {
        this.clear();
        Scanner scanner = new Scanner(new FileReader(filename));
        double x1;
        double y1;
        double x2;
        double y2;
        double x3;
        double y3;
        double x4;
        double y4;
        while (scanner.hasNextLine()) {
            x1 = Double.parseDouble(scanner.nextLine());
            y1 = Double.parseDouble(scanner.nextLine());
            x2 = Double.parseDouble(scanner.nextLine());
            y2 = Double.parseDouble(scanner.nextLine());
            x3 = Double.parseDouble(scanner.nextLine());
            y3 = Double.parseDouble(scanner.nextLine());
            x4 = Double.parseDouble(scanner.nextLine());
            y4 = Double.parseDouble(scanner.nextLine());
            this.isoscelesTrapezoidArrayList.add(new IsoscelesTrapezoid(x1, y1, x2, y2, x3, y3, x4, y4));
        }
        scanner.close();
    }

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.isoscelesTrapezoidArrayList);
            out.close();
            fileOut.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void deserialize(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            this.isoscelesTrapezoidArrayList = (ArrayList<IsoscelesTrapezoid>) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Triangle class not found");
        }
    }

    public void JKSerialize(String filename) throws IOException {
        ObjectMapper objectMapperList = new ObjectMapper();
        objectMapperList.writeValue(new File(filename), this);
    }

    public void JKDeserialize(String filename) throws IOException {
        IsoscelesTrapezoidArray isoscelesTrapezoidArray = new ObjectMapper().readValue(new File(filename), IsoscelesTrapezoidArray.class);
        this.isoscelesTrapezoidArrayList = isoscelesTrapezoidArray.isoscelesTrapezoidArrayList;
    }
}
