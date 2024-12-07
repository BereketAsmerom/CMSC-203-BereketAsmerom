package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TwoDimArrayPractice extends JFrame {
    // GUI components
    private JButton btnFill, btnPrint, btnSet, btnFindMin, btnCountFreq;
    private ButtonHandler buttonHandler;
    private static int[][] dataGrid;
    private static final int ROWS = 4, COLUMNS = 20;
    private int selectedRow = -1, selectedColumn = -1, targetValue;
    private BarChart barChart;
    private boolean firstRender = true;
    private Image offscreen;

    public TwoDimArrayPractice() {
        super("Array Manipulation with Visualization");
        initializeGUI();
        initializeArray();
        barChart = new BarChart(dataGrid);
        offscreen = this.createImage(getSize().width, getSize().height);
    }

    private void initializeGUI() {
        setLayout(new FlowLayout());

        btnFill = createButton("Fill Array");
        btnPrint = createButton("Print Array");
        btnSet = createButton("Set Row Values");
        btnFindMin = createButton("Find Min in Column");
        btnCountFreq = createButton("Count Value Frequency");

        buttonHandler = new ButtonHandler();
        btnFill.addActionListener(buttonHandler);
        btnPrint.addActionListener(buttonHandler);
        btnSet.addActionListener(buttonHandler);
        btnFindMin.addActionListener(buttonHandler);
        btnCountFreq.addActionListener(buttonHandler);

        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        add(button);
        return button;
    }

    private void initializeArray() {
        dataGrid = new int[ROWS][COLUMNS];
        Random rand = new Random();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                dataGrid[row][col] = rand.nextInt(31) + 50;
            }
        }
    }

    public void fillArray() {
        Random rand = new Random();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                dataGrid[row][col] = rand.nextInt(31) + 50;
                animate(row, col);
            }
        }
    }

    public void printArray() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(dataGrid[row][col] + " ");
                animate(row, col);
            }
            System.out.println();
        }
    }

    public void setRowValues(int value, int row) {
        for (int col = 0; col < COLUMNS; col++) {
            dataGrid[row][col] = value;
            animate(row, col);
        }
    }

    public int findMinimum(int column) {
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < ROWS; row++) {
            if (dataGrid[row][column] < min) {
                min = dataGrid[row][column];
            }
            animate(row, column, min);
        }
        return min;
    }

    public int countOccurrences(int value) {
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (dataGrid[row][col] == value) {
                    count++;
                }
                animate(row, col, count);
            }
        }
        return count;
    }

    private void startActivity(int action) {
        barChart.setActivity(action);
        switch (action) {
            case 0 -> {
                fillArray();
                JOptionPane.showMessageDialog(this, "Array filled with random values.");
            }
            case 1 -> {
                printArray();
                JOptionPane.showMessageDialog(this, "Array printed to console.");
            }
            case 2 -> setRowValuesPrompt();
            case 3 -> findMinimumPrompt();
            case 4 -> countFrequencyPrompt();
        }
        enableButtons();
    }

    private void setRowValuesPrompt() {
        targetValue = getInput("Enter a value between 50 and 80:", 50, 80);
        selectedRow = getInput("Enter a row index (0-3):", 0, ROWS - 1);
        if (selectedRow != -1 && targetValue != -1) {
            setRowValues(targetValue, selectedRow);
            JOptionPane.showMessageDialog(this, "Row " + selectedRow + " set to " + targetValue);
        }
    }

    private void findMinimumPrompt() {
        selectedColumn = getInput("Enter a column index (0-19):", 0, COLUMNS - 1);
        if (selectedColumn != -1) {
            int min = findMinimum(selectedColumn);
            JOptionPane.showMessageDialog(this, "Minimum in column " + selectedColumn + " is " + min);
        }
    }

    private void countFrequencyPrompt() {
        targetValue = getInput("Enter a value to count (50-80):", 50, 80);
        if (targetValue != -1) {
            int count = countOccurrences(targetValue);
            JOptionPane.showMessageDialog(this, "Value " + targetValue + " found " + count + " times.");
        }
    }

    private int getInput(String message, int min, int max) {
        while (true) {
            String input = JOptionPane.showInputDialog(this, message);
            if (input == null) return -1;
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) return value;
                JOptionPane.showMessageDialog(this, "Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            }
        }
    }

    private void animate(int row, int col) {
        animate(row, col, 0);
    }

    private void animate(int row, int col, int result) {
        Graphics g = offscreen.getGraphics();
        barChart.setArray(dataGrid);
        barChart.setStudentResult(result);
        paint(g);
        g = getGraphics();
        g.drawImage(offscreen, 0, 0, this);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public void paint(Graphics g) {
        if (firstRender || barChart.getActivity() != -1) {
            super.paint(g);
            barChart.draw(g);
            firstRender = false;
        }
    }

    public void enableButtons() {
        btnFill.setEnabled(true);
        btnPrint.setEnabled(true);
        btnSet.setEnabled(true);
        btnFindMin.setEnabled(true);
        btnCountFreq.setEnabled(true);
    }

    public void disableButtons() {
        btnFill.setEnabled(false);
        btnPrint.setEnabled(false);
        btnSet.setEnabled(false);
        btnFindMin.setEnabled(false);
        btnCountFreq.setEnabled(false);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            disableButtons();
            if (e.getSource() == btnFill) barChart.setActivity(0);
            else if (e.getSource() == btnPrint) barChart.setActivity(1);
            else if (e.getSource() == btnSet) barChart.setActivity(2);
            else if (e.getSource() == btnFindMin) barChart.setActivity(3);
            else if (e.getSource() == btnCountFreq) barChart.setActivity(4);
            startActivity(barChart.getActivity());
        }
    }

    public static void main(String[] args) {
        new TwoDimArrayPractice();
    }
}
