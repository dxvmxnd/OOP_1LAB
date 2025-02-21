import javax.swing.*;
import java.awt.*;


public class Main {

    // Метод для создания и отображения графика
    public static void showGraph(String functionName) {
        JFrame graphFrame = new JFrame("График: " + functionName);
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

                // Рисуем оси
                g2d.setColor(Color.BLACK);
                g2d.drawLine(0, originY, width, originY); // X-axis
                g2d.drawLine(originX, 0, originX, height); // Y-axis

                g2d.setColor(Color.RED);
                for (int x = -originX; x < originX; x++) {
                    double scaledX = x / 50.0; // Масштаб для увеличения диапазона
                    double y = 0;

                    switch (functionName) {
                        case "Линейные":
                            y = scaledX;
                            break;
                        case "Квадратичные":
                            y = Math.pow(scaledX, 2);
                            break;
                        case "Кубические":
                            y = Math.pow(scaledX, 3);
                            break;
                        case "Синус":
                            y = Math.sin(scaledX);
                            break;
                        case "Косинус":
                            y = Math.cos(scaledX);
                            break;
                        case "Тангенс":
                            y = Math.tan(scaledX);
                            break;
                        case "Котангенс":
                            y = 1.0 / Math.tan(scaledX);
                            break;
                        case "Гиперб. синус":
                            y = Math.sinh(scaledX);
                            break;
                        case "Гиперб. косинус":
                            y = Math.cosh(scaledX);
                            break;
                    }

                    // Преобразование координат в пиксели
                    int pixelX = originX + x;
                    int pixelY = originY - (int) (y * 50); // Масштабирование по Y

                    if (pixelY >= 0 && pixelY < height) {
                        g2d.drawLine(pixelX, pixelY, pixelX, pixelY);
                    }
                }
            }
        };

        graphFrame.add(graphPanel);
        graphFrame.setVisible(true);
    }

    public static void placeShit(JFrame frame) {
        JPanel panelTop = new JPanel();
        JButton buttonTop = new JButton("Функции");
        buttonTop.setPreferredSize(new Dimension(300, 200));
        buttonTop.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Кнопка нажата!"));
        panelTop.add(buttonTop);

        JPanel panelMiddle = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 300, 30);
        panelMiddle.setLayout(layout);

        JButton buttonMid1 = new JButton("Алгебраические");
        buttonMid1.setPreferredSize(new Dimension(300, 200));
        panelMiddle.add(buttonMid1);

        JButton buttonMid2 = new JButton("Тригонометрические");
        buttonMid2.setPreferredSize(new Dimension(300, 200));
        panelMiddle.add(buttonMid2);

        JButton buttonMid3 = new JButton("Гиперболические");
        buttonMid3.setPreferredSize(new Dimension(300, 200));
        panelMiddle.add(buttonMid3);

        JPanel panelBot = new JPanel();
        FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 70, 100);
        panelBot.setLayout(layout2);

        String[] functions = {
                "Линейные", "Квадратичные", "Кубические", "Синус", "Косинус",
                "Тангенс", "Котангенс", "Гиперб. синус", "Гиперб. косинус"
        };

        for (String function : functions) {
            JButton button = new JButton(function);
            button.setPreferredSize(new Dimension(130, 100));
            button.addActionListener(e -> showGraph(function));
            panelBot.add(button);
        }

        frame.getContentPane().add(panelTop, BorderLayout.NORTH);
        frame.getContentPane().add(panelMiddle, BorderLayout.CENTER);
        frame.getContentPane().add(panelBot, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Окно Мияги");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        placeShit(frame);

        frame.setVisible(true);
    }
}