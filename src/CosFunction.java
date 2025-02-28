import javax.swing.*;
import java.awt.*;

class CosFunction extends TrigonometricFunction {
    private double a, b;
    private int count = 0;

    public CosFunction(double a, double b) {
        this.a = a;
        this.b = b;
        this.count++;
    }

    @Override
    public String toString() {
        return this.getFunctionName() + " " + a + " " + b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getFunctionName() {
        return "cos";
    }

    @Override
    double calculate(double x) {
        return a * Math.cos(x) + b;
    }
    public void showGraph() {
        JFrame graphFrame = new JFrame("График");
        graphFrame.setSize(800, 600);
        graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(2));
                g2d.setColor(Color.BLUE);

                int width = getWidth();
                int height = getHeight();
                int originX = width / 2;
                int originY = height / 2;

                // Оси
                g2d.setColor(Color.BLACK);
                g2d.drawLine(0, originY, width, originY); // X-axis
                g2d.drawLine(originX, 0, originX, height); // Y-axis

                g2d.setColor(Color.RED);

                // Переменные для последней точки (для рисования линий)
                Double prevPixelX = null;
                Double prevPixelY = null;

                for (int x = -originX; x < originX; x++) {
                    double scaledX = x / 50.0; // Масштаб
                    double y = 0;
                    y = a * Math.cos(scaledX) + b;

                    // Преобразование в пиксели
                    int pixelX = originX + x;
                    int pixelY = originY - (int) (y * 50); // Масштаб Y

                    // Проверяем, что точка внутри видимого диапазона
                    if (pixelY >= 0 && pixelY < height) {
                        // Если есть предыдущая точка, соединяем её с текущей
                        if (prevPixelX != null && prevPixelY != null) {
                            g2d.drawLine(prevPixelX.intValue(), prevPixelY.intValue(), pixelX, pixelY);
                        }

                        // Обновляем предыдущую точку
                        prevPixelX = (double) pixelX;
                        prevPixelY = (double) pixelY;
                    } else {
                        // Если точка выходит за границы, сбрасываем предыдущую точку
                        prevPixelX = null;
                        prevPixelY = null;
                    }
                }
            }
        };

        graphFrame.add(graphPanel);
        graphFrame.setVisible(true);
    }
}