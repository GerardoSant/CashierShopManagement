package Implementation;

import Control.Command;
import Control.CommandFactory;
import Model.Cashier;
import View.CashierDisplay;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Mainframe extends JFrame {


    private List<Cashier> cashierList;
    private CashierDisplay nextCashierDisplay;

    public Mainframe(List<Cashier> cashierList) {
        this.cashierList = cashierList;
        createUI();
        setFrameSettings();
    }

    private void setFrameSettings() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(this.getWidth()+50, this.getHeight());
        setTitle("Shop with cashiers");
    }

    public void execute(){
        setVisible(true);
    }

    private void createUI() {
        nextCashierDisplay= new SwingNextCashierDisplay(cashierList);
        add(cashiersPanel(), BorderLayout.NORTH);
        add((Component) nextCashierDisplay, BorderLayout.SOUTH);

    }

    private JPanel cashiersPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        for (Cashier cashier: cashierList){
            SwingCashierDisplay cashierDisplay = new SwingCashierDisplay(cashier);
            cashier.addObserver(cashierDisplay);
            cashier.addObserver(nextCashierDisplay);
            panel.add(cashierDisplay);
        }
        return panel;

    }
}
