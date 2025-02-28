import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.util.Objects;

public class Main {
    static int indexOfStringInList = 0;
    static ArrayList<StructFunc> structFuncList = new ArrayList<>();

    static class StructFunc {
        StructFunc() {
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            name = "";
        }
        double a,b,c,d;
        String name;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            StructFunc other = (StructFunc) obj;


            return Objects.equals(name, other.name) &&
                    Double.compare(a, other.a) == 0 &&
                    Double.compare(b, other.b) == 0 &&
                    Double.compare(c, other.c) == 0 &&
                    Double.compare(d, other.d) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, a, b, c, d);
        }

        @Override
        public String toString() {
            String text = "";
            text = name + " " + Double.toString(a) + " " + Double.toString(b);
            if(name.equals("quadratic")) {
                text += " " + Double.toString(c);
            }
            if(name.equals("cubic")) {
                text += " " + Double.toString(c) + " " + Double.toString(d);
            }

            return text;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Окно Мияги");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        placeShit(frame);

        frame.setVisible(true);
    }

    public static void placeShit(JFrame frame) {
        JPanel panelTop = new JPanel();
        JButton buttonTop = new JButton("Функции");
        buttonTop.setPreferredSize(new Dimension(300, 200));
        buttonTop.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Функции — это математические соотношения, которые связывают каждое значение из одной множества (области определения) с единственным значением из другого множества (области значений)."));
        panelTop.add(buttonTop);

        /// //////////////////////////////////////////////////////////////////

        String[] functions = {
                "Линейные", "Квадратичные", "Кубические", "Синус", "Косинус",
                "Тангенс", "Котангенс", "Гиперб. синус", "Гиперб. косинус"
        };

        int x = 1700;
        int y = 100;
        int width = 200;
        int height = 30;

        // Создание списка
        JComboBox<String> functionDropdown = new JComboBox<>(functions);
        functionDropdown.setPreferredSize(new Dimension(width, height));

        /// //////////////////////////////////////////////////////////////////

        // Установка координат и размеров для выпадающего списка
        functionDropdown.setBounds(x, y, width, height);

        frame.getContentPane().add(functionDropdown);

        /// //////////////////////////////////////////////////////////////////

        JPanel panelMiddle = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 300, 30);
        panelMiddle.setLayout(layout);

        JButton buttonMid1 = new JButton("Алгебраические");
        buttonMid1.setPreferredSize(new Dimension(250, 200));
        buttonMid1.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Алгебраические функции — это функции, которые могут быть выражены с помощью алгебраических операций (сложение, вычитание, умножение, деление и извлечение корня) над переменными и константами."));
        panelMiddle.add(buttonMid1);

        JButton buttonMid2 = new JButton("Тригонометрические");
        buttonMid2.setPreferredSize(new Dimension(250, 200));
        buttonMid2.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Тригонометрические функции — это функции, которые связывают углы треугольников с отношениями между их сторонами и используются для описания периодических явлений, таких как колебания и волны."));
        panelMiddle.add(buttonMid2);

        JButton buttonMid3 = new JButton("Гиперболические");
        buttonMid3.setPreferredSize(new Dimension(250, 200));
        buttonMid3.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Гиперболические функции — это математические функции, подобные тригонометрическим, которые описывают соотношения между сторонами гиперболы и определяются через экспоненциальные функции."));
        panelMiddle.add(buttonMid3);

        JPanel panelBot = new JPanel();
        FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER, 70, 100);
        panelBot.setLayout(layout2);

        /// //////////////////////////////////////////////////////////////////

        for (String function : functions) {
            JButton button = new JButton(function);
            button.setPreferredSize(new Dimension(130, 100));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedFunction = button.getText();

                    switch(selectedFunction) {
                        case "Линейные":
                            LinearFunction linFunc = new LinearFunction(1, 0);
                            linFunc.showGraph();
                            break;
                        case "Квадратичные":
                            QuadraticFunction quadFunc = new QuadraticFunction(1, 0, 0);
                            quadFunc.showGraph();
                            break;
                        case "Кубические":
                            CubicFunction cubFunc = new CubicFunction(1, 0, 0, 0);
                            cubFunc.showGraph();
                            break;
                        case "Синус":
                            SinFunction sinFunc = new SinFunction(1, 0);
                            sinFunc.showGraph();
                            break;
                        case "Косинус":
                            CosFunction cosFunc = new CosFunction(1, 0);
                            cosFunc.showGraph();
                            break;
                        case "Тангенс":
                            TgFunction tgFunc = new TgFunction(1,0);
                            tgFunc.showGraph();
                            break;
                        case "Котангенс":
                            CtgFunction ctgFunc = new CtgFunction(1,0);
                            ctgFunc.showGraph();
                            break;
                        case "Гиперб. синус":
                            SinhFunction sinhFunc = new SinhFunction(1, 0);
                            sinhFunc.showGraph();
                            break;

                        case "Гиперб. косинус":
                            CoshFunction coshFunc = new CoshFunction(1, 0);
                            coshFunc.showGraph();
                            break;
                    }
                }
            });
            panelBot.add(button);
        }
        frame.getContentPane().add(panelTop, BorderLayout.NORTH);
        frame.getContentPane().add(panelMiddle, BorderLayout.CENTER);
        frame.getContentPane().add(panelBot, BorderLayout.SOUTH);


        /// //////////////////////////////////////////////////////////////////

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(4, 1, 10, 10));
        sidePanel.setPreferredSize(new Dimension(150, 300)); // Размер боковой панели

        JButton addButton = new JButton("Добавить");
        JButton deleteButton = new JButton("Удалить");
        JButton editButton = new JButton("Редактировать");
        JButton showButton = new JButton("Показать");

        sidePanel.add(addButton);
        sidePanel.add(deleteButton);
        sidePanel.add(editButton);
        sidePanel.add(showButton);

        frame.getContentPane().add(sidePanel, BorderLayout.EAST); // Размещаем панель справа

        /// ////////////////////////////////////////////////////////////////////

        addButton.addActionListener(e -> {
            // Открытие нового окна
            JDialog addDialog = new JDialog(frame, "Добавить данные", true);
            addDialog.setSize(400, 300);
            addDialog.setLayout(new GridLayout(5, 2, 10, 10));

            // Поля для ввода
            JLabel label1 = new JLabel("Коэффицент A:");
            JTextField textField1 = new JTextField();

            JLabel label2 = new JLabel("Коэффицент B:");
            JTextField textField2 = new JTextField();

            JLabel label3 = new JLabel("Коэффицент C:");
            JTextField textField3 = new JTextField();

            JLabel label4 = new JLabel("Коэффицент D:");
            JTextField textField4 = new JTextField();

            /// //////////////////////////////////////////////////////////////////

            // Кнопка "Сохранить"
            JButton saveButton = new JButton("Сохранить");
            saveButton.addActionListener(event -> {
                StructFunc newFunc = new StructFunc();

                newFunc.a = Double.parseDouble(textField1.getText());
                newFunc.b = Double.parseDouble(textField2.getText());
                try {
                    newFunc.c = Double.parseDouble(textField3.getText());
                } catch (NumberFormatException e1) {

                }

                try {
                    newFunc.d = Double.parseDouble(textField4.getText());
                } catch (NumberFormatException e1) {

                }
                String nameOfFunc = "";
                String selectedFunction = (String) functionDropdown.getSelectedItem();
                switch(selectedFunction) {
                    case "Линейные":
                        nameOfFunc = "linear";
                        break;
                    case "Квадратичные":
                        nameOfFunc = "quadratic";
                        break;
                    case "Кубические":
                        nameOfFunc = "cubic";
                        break;
                    case "Синус":
                        nameOfFunc = "sin";
                        break;
                    case "Косинус":
                        nameOfFunc = "cos";
                        break;
                    case "Тангенс":
                        nameOfFunc = "tg";
                        break;
                    case "Котангенс":
                        nameOfFunc = "ctg";
                        break;
                    case "Гиперб. синус":
                        nameOfFunc = "sinh";
                        break;

                    case "Гиперб. косинус":
                        nameOfFunc = "cosh";
                        break;
                }

                newFunc.name = nameOfFunc;

                structFuncList.add(newFunc);

                JOptionPane.showMessageDialog(addDialog, "Данные сохранены!");
                addDialog.dispose();
            });

            /// //////////////////////////////////////////////////////////////////
            String selectedFunction = (String) functionDropdown.getSelectedItem();


            switch(selectedFunction) {
                case "Квадратичные":
                    addDialog.add(label3);
                    addDialog.add(textField3);
                    break;
                case "Кубические":
                    addDialog.add(label3);
                    addDialog.add(textField3);
                    addDialog.add(label4);
                    addDialog.add(textField4);
                    break;
                default:
                    ;
            }


            addDialog.add(label1);
            addDialog.add(textField1);

            addDialog.add(label2);
            addDialog.add(textField2);


            addDialog.add(new JLabel());
            addDialog.add(saveButton);

            // Показываем диалог
            addDialog.setLocationRelativeTo(frame);
            addDialog.setVisible(true);


            /// ////////////////////////////////////////

            showButton.addActionListener(event2 -> {
                JDialog showDialog = new JDialog(frame, "Показать функцию", true);
                showDialog.setSize(400, 300);
                showDialog.setLayout(new GridLayout(2, 2, 10, 10));
                showDialog.setLocationRelativeTo(frame);

                showDialog.add(new JLabel("Выберите функцию:"));



                String[] addedFuncs = new String[structFuncList.size()];
                for(int i = 0; i < structFuncList.size(); i++) {
                    addedFuncs[i] = structFuncList.get(i).toString();
                }

                JComboBox<String> functionDropdownShow = new JComboBox<>(addedFuncs);
                showDialog.add(functionDropdownShow);

                JButton okButton = new JButton("OK");
                showDialog.add(okButton);

                okButton.addActionListener(eventClose -> {
                    String funcForShow = (String) functionDropdownShow.getSelectedItem();
                    String[] parts = funcForShow.split(" ");

                    String className = capitalize(parts[0]) + "Function";
                    try {
                        //  класс по имени
                        Class<?> clazz = Class.forName(className);
                        //  конструктор с параметрами double, double
                        Constructor<?> constructor;

                        if(className.equals("QuadraticFunction")) {
                            constructor = clazz.getDeclaredConstructor(double.class, double.class, double.class);
                        } else if(className.equals("CubicFunction")) {
                            constructor = clazz.getDeclaredConstructor(double.class, double.class, double.class, double.class);
                        } else {
                            constructor = clazz.getDeclaredConstructor(double.class, double.class);
                        }

                        //  экземпляр класса
                        Object instance;
                        if(className.equals("QuadraticFunction")) {
                            instance = constructor.newInstance(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()), Double.parseDouble(textField3.getText()));
                        } else if (className.equals("CubicFunction")) {
                            instance = constructor.newInstance(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()), Double.parseDouble(textField3.getText()), Double.parseDouble(textField4.getText()));
                        } else {
                            instance = constructor.newInstance(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()));
                        }

                        showDialog.dispose();
                        // выZOV метода
                        Method showGraph = clazz.getMethod("showGraph");
                        showGraph.invoke(instance);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }


                });

                showDialog.setVisible(true);
            });


            editButton.addActionListener(event3 -> {

                JDialog editDialog = new JDialog(frame, "Изменить функцию", true);
                editDialog.setSize(400, 300);
                editDialog.setLayout(new GridLayout(2, 2, 10, 10));
                editDialog.setLocationRelativeTo(frame); // Центрируем относительно основного окна


                editDialog.add(new JLabel("Выберите функцию:"));


                String[] addedFuncs = new String[structFuncList.size()];
                for (int i = 0; i < structFuncList.size(); i++) {
                    addedFuncs[i] = structFuncList.get(i).toString();
                }

                JComboBox<String> functionDropdownShow = new JComboBox<>(addedFuncs);
                editDialog.add(functionDropdownShow);

                JButton editButton2 = new JButton("OK");
                editDialog.add(editButton2);

                editButton2.addActionListener(eventEdit -> {
                    String funcForShow = (String) functionDropdownShow.getSelectedItem();
                    String[] parts = funcForShow.split(" ");

                    StructFunc tempFunc = new StructFunc();
                    tempFunc.a = Double.parseDouble(parts[1]);
                    tempFunc.b = Double.parseDouble(parts[2]);
                    tempFunc.c = 0;
                    tempFunc.d = 0;
                    if(parts[0].equals("quadratic")) {
                        tempFunc.c = Double.parseDouble(parts[3]);
                    }
                    if(parts[0].equals("cubic")) {
                        tempFunc.c = Double.parseDouble(parts[3]);
                        tempFunc.d = Double.parseDouble(parts[4]);
                    }
                    tempFunc.name = parts[0];

                    indexOfStringInList = structFuncList.indexOf(tempFunc);


                    JFrame inputFrame = new JFrame("Изменение данных");
                    inputFrame.setSize(400, 300);
                    inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    inputFrame.setLayout(new GridLayout(5, 2, 10, 10)); // Изменяем сетку на 5 строк для кнопки "Сохранить"


                    JLabel labelA = new JLabel("Коэффициент A:");
                    JTextField textFieldA = new JTextField(parts[1]);
                    inputFrame.add(labelA);
                    inputFrame.add(textFieldA);


                    JLabel labelB = new JLabel("Коэффициент B:");
                    JTextField textFieldB = new JTextField(parts[2]);
                    inputFrame.add(labelB);
                    inputFrame.add(textFieldB);


                    JTextField textFieldC = null;
                    JTextField textFieldD = null;

                    if (parts[0].equals("quadratic")) {
                        JLabel labelC = new JLabel("Коэффициент C:");
                        textFieldC = new JTextField(parts[3]);
                        inputFrame.add(labelC);
                        inputFrame.add(textFieldC);
                    }

                    if (parts[0].equals("cubic")) {
                        JLabel labelC = new JLabel("Коэффициент C:");
                        textFieldC = new JTextField(parts[3]);
                        inputFrame.add(labelC);
                        inputFrame.add(textFieldC);

                        JLabel labelD = new JLabel("Коэффициент D:");
                        textFieldD = new JTextField(parts[4]);
                        inputFrame.add(labelD);
                        inputFrame.add(textFieldD);
                    }


                    JButton saveButton1 = new JButton("Сохранить");
                    inputFrame.add(saveButton1);


                    JTextField finalTextFieldC = textFieldC;
                    JTextField finalTextFieldD = textFieldD;
                    saveButton1.addActionListener(saveEvent -> {

                        StringBuilder result = new StringBuilder(parts[0] + " " + textFieldA.getText() + " " + textFieldB.getText());
                        if (finalTextFieldC != null) {
                            result.append(" ").append(finalTextFieldC.getText());
                        }
                        if (finalTextFieldD != null) {
                            result.append(" ").append(finalTextFieldD.getText());
                        }


                        structFuncList.remove(indexOfStringInList);

                        StructFunc newFunc = new StructFunc();
                        newFunc.name = parts[0];
                        newFunc.a = Double.parseDouble(textFieldA.getText());
                        newFunc.b = Double.parseDouble(textFieldB.getText());
                        if(parts[0].equals("quadratic")) {
                            newFunc.c = Double.parseDouble(finalTextFieldC.getText());
                        }
                        if(parts[0].equals("cubic")) {
                            newFunc.c = Double.parseDouble(finalTextFieldC.getText());
                            newFunc.d = Double.parseDouble(finalTextFieldD.getText());
                        }

                        structFuncList.add(newFunc);



                        JOptionPane.showMessageDialog(editDialog, "Функция удалена!");
                        editDialog.dispose();
                        inputFrame.dispose();
                    });
                    editDialog.dispose();

                    inputFrame.setVisible(true);
                });


                JButton closeButton = new JButton("Закрыть");
                closeButton.addActionListener(ee -> editDialog.dispose());
                editDialog.add(closeButton);


                editDialog.setVisible(true);
            });

            /// //////////////////////////////////////////////////////////////////
            deleteButton.addActionListener(event4 -> {

                JDialog deleteDialog = new JDialog(frame, "Удалить функцию", true);
                deleteDialog.setSize(400, 300);
                deleteDialog.setLayout(new GridLayout(2, 2, 10, 10));
                deleteDialog.setLocationRelativeTo(frame); // Центрируем относительно основного окна


                deleteDialog.add(new JLabel("Выберите функцию:"));


                String[] addedFuncs = new String[structFuncList.size()];
                for (int i = 0; i < structFuncList.size(); i++) {
                    addedFuncs[i] = structFuncList.get(i).toString();
                }

                JComboBox<String> functionDropdownShow = new JComboBox<>(addedFuncs);
                deleteDialog.add(functionDropdownShow);

                JButton deleteButton2 = new JButton("OK");
                deleteDialog.add(deleteButton2);

                JButton closeButton = new JButton("Закрыть");
                closeButton.addActionListener(ee -> deleteDialog.dispose());
                deleteDialog.add(closeButton);

                deleteButton2.addActionListener(eventEdit -> {
                    String funcForShow = (String) functionDropdownShow.getSelectedItem();
                    String[] parts = funcForShow.split(" ");

                    StructFunc tempFunc = new StructFunc();
                    tempFunc.a = Double.parseDouble(parts[1]);
                    tempFunc.b = Double.parseDouble(parts[2]);
                    tempFunc.c = 0;
                    tempFunc.d = 0;
                    if(parts[0].equals("quadratic")) {
                        tempFunc.c = Double.parseDouble(parts[3]);
                    }
                    if(parts[0].equals("cubic")) {
                        tempFunc.c = Double.parseDouble(parts[3]);
                        tempFunc.d = Double.parseDouble(parts[4]);
                    }
                    tempFunc.name = parts[0];

                    indexOfStringInList = structFuncList.indexOf(tempFunc);
                    structFuncList.remove(indexOfStringInList);

                    JOptionPane.showMessageDialog(deleteDialog, "Функция удалена!");
                    deleteDialog.dispose();


                });

                deleteDialog.setVisible(true);
            });




        });
    }
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}