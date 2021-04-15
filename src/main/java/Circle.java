import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        String promptInputCircleArea = "Введите площадь круга (чтобы найти его радиус) в квадратных метрах:";
        String promptErrorInputCircleArea = "Неверный ввод. Для задания площади введите положительное вещественное число.";
        double inputCircleArea = consoleInputHandle(promptInputCircleArea, promptErrorInputCircleArea);

        double calculatedRadius = Math.sqrt(inputCircleArea / Math.PI);
        System.out.printf("Радиус круга для введённой площади %s м2 равен %f м%n", inputCircleArea, calculatedRadius);

        String promptInputRadius = "Введите радиус окружности в метрах:";
        String promptErrorInputRadius = "Неверный ввод. Для задания радиуса введите положительное вещественное число.";
        double radius = consoleInputHandle(promptInputRadius, promptErrorInputRadius);

        String promptInputSectorAngle = "Введите угол сектора окружности в градусах (от 0 до 360) :";
        String promptErrorInputSectorAngle = "Неверный ввод. Для задания угла сектора введите положительное вещественное число" + "\n" + "в диапазоне от 0 до 360.";
        double sectorAngle = consoleInputHandle(promptInputSectorAngle, promptErrorInputSectorAngle, 0., 360.);

        double circleLength = 2 * Math.PI * radius;
        System.out.printf("Длина всей окружности - %f м%n", circleLength);

        double circleArea = Math.PI * Math.pow(radius, 2);
        System.out.printf("Площадь всей окружности - %f м2%n", circleArea);

        double sectorArea = Math.PI * Math.pow(radius, 2) * sectorAngle / 360;
        System.out.printf("Площадь сектора  - %f м2", sectorArea);
    }

    public static double consoleInputHandle(String inputPrompt, String errorPrompt) {
        boolean isRightInput = false;

        Scanner scanner = new Scanner(System.in);

        double input = 0;
        while (!isRightInput) {
            System.out.println(inputPrompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                if (input <= 0.) {
                    System.out.println(errorPrompt);
                    continue;
                }
                isRightInput = true;
            } else {
                System.out.println(errorPrompt);
                scanner.nextLine();
            }
        }
        return input;
    }

    public static double consoleInputHandle(String inputPrompt, String errorPrompt, double minValue, double maxValue) {
        boolean isRightInput = false;

        Scanner scanner = new Scanner(System.in);

        double input = 0;
        while (!isRightInput) {
            System.out.println(inputPrompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                if (input < minValue || input > maxValue) {
                    System.out.println(errorPrompt);
                    continue;
                }
                isRightInput = true;
            } else {
                System.out.println(errorPrompt);
                scanner.nextLine();
            }
        }
        return input;
    }
}

