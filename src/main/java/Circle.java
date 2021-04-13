import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {

        double radius = 0;
        double sector = 0;
        double circleLength;
        double sectorSquare;
        double circleSquare;
        double inputSquareCircle = 0;
        double radiusCalc;
        boolean rightInput = true;

        //region Handling square input
        while (rightInput) {
            System.out.println("Введите площадь круга (чтобы найти его радиус) в квадратных метрах:");
            try {
                Scanner sc = new Scanner(System.in);
                inputSquareCircle = sc.nextDouble();
                if (inputSquareCircle < 0) throw new IllegalArgumentException();
                rightInput = false;

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Неверный ввод. Для задания площади введите положительное вещественное число.");
            }
        }
        //endregion
        rightInput = true;
        //region Handling radius input
        while (rightInput) {
            System.out.println("Введите радиус окружности в метрах:");
            try {
                Scanner sc = new Scanner(System.in);
                radius = sc.nextDouble();
                if (radius < 0) throw new IllegalArgumentException();
                rightInput = false;

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Неверный ввод. Для задания радиуса введите положительное вещественное число.");
            }
        }
        //endregion
        rightInput = true;
        //region Handling sector input
        while (rightInput) {
            System.out.println("Введите сектор окружности в градусах (от 0 до 360) :");
            try {
                Scanner sc = new Scanner(System.in);
                sector = sc.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Для задания сектора введите положительное вещественное число");
                System.out.println("в диапазоне от 0 до 360");
                continue;

            }
            if (sector < 0 || sector > 360) {
                System.out.println("Неверный ввод. Значение сектора должно быть в пределах от 0 до 360");
                continue;
            }
            rightInput = false;
        }
        //endregion

        circleLength = 2 * Math.PI * radius;
        circleSquare = Math.PI * Math.pow(radius, 2);
        sectorSquare = Math.PI * Math.pow(radius, 2) * sector / 360;
        radiusCalc = Math.sqrt(inputSquareCircle/Math.PI);

        System.out.printf("Длина всей окружности - %s м", circleLength);
        System.out.printf("%n");
        System.out.printf("Площадь всей окружности - %s м2", circleSquare);
        System.out.printf("%n");
        System.out.printf("Площадь сектора  - %s м2", sectorSquare);
        System.out.printf("%n");
        System.out.printf("Радиус круга для введённой площади %s м2 равен %s м", inputSquareCircle, radiusCalc);


    }
}

