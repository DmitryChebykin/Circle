import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {

        double radius = 0;
        double sector = 0;
        double circleLength = 0;
        double circleArea = 0;
        boolean rightInput = true;

        //region Handling radius input
        while (rightInput) {
            System.out.println("Введите радиус окружности в метрах:");
            try {
                Scanner sc = new Scanner(System.in);
                radius = sc.nextDouble();
                rightInput = false;

            } catch (InputMismatchException e) {
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
        circleArea = Math.PI * Math.pow(radius, 2) * sector / 360;
        System.out.printf("Длина всей окружности - %s м", circleLength);
        System.out.printf("%n");
        System.out.printf("Площадь сектора  - %s м2", circleArea);


    }
}

