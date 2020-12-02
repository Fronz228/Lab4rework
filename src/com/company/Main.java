package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        QuadrangleArray quadrangleArray = new QuadrangleArray();

        quadrangleArray.add(4, 9, 9, 9, 9, 5, 4, 5);
        quadrangleArray.add(3, 5, 5, 6, 6, 2, 1, 2);
        quadrangleArray.add(3, 5, 5, 6, 6, 2, 1, 2);
        quadrangleArray.add(3, 5, 5, 6, 6, 2, 1, 2);
        quadrangleArray.add(3, 5, 5, 6, 6, 2, 1, 2);
        quadrangleArray.add(3, 5, 5, 6, 6, 2, 1, 2);
        quadrangleArray.add(2, 7, 7, 7, 7, 3, 2, 3);
        quadrangleArray.add(3, 8, 8, 8, 8, 4, 3, 4);
        quadrangleArray.add(3, 8, 8, 8, 8, 4, 3, 4);

        quadrangleArray.quadrangleArrayList.removeIf(quadrangle -> !quadrangle.isExists());
        System.out.println("Четерехугольники:");
        System.out.println(quadrangleArray);
        if(!quadrangleArray.quadrangleArrayList.isEmpty()){
            quadrangleArray.JKSerialize("reserve_save_file.txt");
            System.out.println("Резервный файл был успешно создан!");
        }

        System.out.println("");

        ArrayList<Quadrangle> maxArea = new ArrayList<>();
        Quadrangle quadrangle = Collections.max(quadrangleArray.quadrangleArrayList, Comparator.comparing(s -> s.findArea()));
        maxArea.add(quadrangle);
        quadrangleArray.remove(quadrangle);

        for (int i = 0; i < quadrangleArray.quadrangleArrayList.size(); i++) {
            Quadrangle currentQuadrangle = quadrangleArray.get(i);
            if (currentQuadrangle.findArea() == quadrangle.findArea()){
                maxArea.add(currentQuadrangle);
            }
        }
        System.out.println("");
        System.out.println("Максимальная площадь четырехугольников: " + quadrangle.findArea());
        System.out.println("Кол-во четырехугольников с максимальной площадью: " + maxArea.size());

        IsoscelesTrapezoidArray trapezoidArray = new IsoscelesTrapezoidArray();

        trapezoidArray.add(-2,0,-1, 2, 1, 2, 2,0);
        trapezoidArray.add(-2,0,-1, 3, 1, 3, 2,0);
        trapezoidArray.isoscelesTrapezoidArrayList.removeIf(isoscelesTrapezoid -> !isoscelesTrapezoid.isIsoscelesTrapezoid());
        System.out.println("Равнобочные трапеции:");
        System.out.println(trapezoidArray);
        IsoscelesTrapezoid trapezoid = Collections.max(trapezoidArray.isoscelesTrapezoidArrayList, Comparator.comparing(s -> s.findDiagonalOne()));
        System.out.println("");
        System.out.println(trapezoid);
        if(!trapezoidArray.isoscelesTrapezoidArrayList.isEmpty()){
            trapezoidArray.JKSerialize("reserve_save_file_trapezoid.txt");
            System.out.println("Резервный файл был успешно создан!");
        }
    }
}
