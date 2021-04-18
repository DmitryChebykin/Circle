import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {

        String inputCircleAreaMessage = "Введите площадь круга (чтобы найти его радиус) в квадратных метрах:";
        String inputCircleAreaErrorMessage = "Неверный ввод. Для задания площади введите положительное вещественное число.";
        double inputCircleArea = consoleInputHandle(inputCircleAreaMessage, inputCircleAreaErrorMessage);

        double calculatedRadius = Math.sqrt(inputCircleArea / Math.PI);
        System.out.printf("Радиус круга для введённой площади %s м2 равен %f м%n", inputCircleArea, calculatedRadius);

        String inputRadiusMessage = "Введите радиус окружности в метрах:";
        String inputRadiusErrorMessage = "Неверный ввод. Для задания радиуса введите положительное вещественное число.";
        double radius = consoleInputHandle(inputRadiusMessage, inputRadiusErrorMessage);

        String inputSectorAngleMessage = "Введите угол сектора окружности в градусах (от 0 до 360) :";
        String inputSectorAngleErrorMessage = "Неверный ввод. Для задания угла сектора введите положительное вещественное число " + "\n" + "в диапазоне от 0 до 360.";
        double sectorAngle = consoleInputHandle(inputSectorAngleMessage, inputSectorAngleErrorMessage, 0, 360);

        double circleLength = 2 * Math.PI * radius;
        System.out.printf("Длина всей окружности - %f м%n", circleLength);

        double circleArea = Math.PI * Math.pow(radius, 2);
        System.out.printf("Площадь круга - %f м2%n", circleArea);

        double sectorArea = Math.PI * Math.pow(radius, 2) * sectorAngle / 360;
        System.out.printf("Площадь сектора - %f м2", sectorArea);
    }

    public static double consoleInputHandle(String inputMessage, String errorMessage) {
        boolean isRightInput = false;

        Scanner scanner = new Scanner(System.in);

        double input = 0;

        while (!isRightInput) {
            System.out.println(inputMessage);

            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                
                if (input <= 0.) {
                    System.out.println(errorMessage);
                    continue;
                }
                
                isRightInput = true;
            } else {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
        return input;
    }

    public static double consoleInputHandle(String inputMessage, String errorMessage, double minValue, double maxValue) {
        boolean isRightInput = false;

        Scanner scanner = new Scanner(System.in);

        double input = 0;
        while (!isRightInput) {
            System.out.println(inputMessage);

            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();

                if (input < minValue || input > maxValue) {
                    System.out.println(errorMessage);
                    continue;
                }
                
                isRightInput = true;
            } else {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
        return input;
    }
}