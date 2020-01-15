package Implementation;

import Control.Command;
import Control.CommandFactory;
import Model.Cashier;
import View.CashierDisplay;

import javax.swing.*;
import java.util.Map;

public class SwingCashierDisplay extends JPanel implements CashierDisplay {

    Cashier cashier;
    JButton openClose;
    JButton freeBusy;
    Map<String, Command> commands;

    public SwingCashierDisplay(Cashier cashier,Map<String, Command> commands) {
        this.cashier= cashier;
        this.commands = commands;
        createCashierUI();
    }

    private void createCashierUI() {
        JLabel id = new JLabel("Cashier " + Integer.toString(cashier.getId()));
        openClose = button("OPEN");
        freeBusy = button("FREE");
        add(id);
        add(openClose);
        add(freeBusy);
        refreshCashier();
    }

    private JButton button(final String buttonName){
        JButton button = new JButton(buttonName);
        button.addActionListener(e-> commands.get(button.getText()).execute());
        return button;
    }

    public void show(Cashier cashier) {
        this.cashier=cashier;
    }

    public void update() {
        refreshCashier();
    }

    private void refreshCashier() {
        if (cashier.getStatus().name().equals("CLOSED")){
            openClose.setText("OPEN");
            freeBusy.setEnabled(false);
        }
        if (cashier.getStatus().name().equals("FREE")){
            openClose.setText("CLOSE");
            freeBusy.setText("BUSY");
            freeBusy.setEnabled(true);
        }

        if (cashier.getStatus().name().equals("BUSY")){
            openClose.setText("CLOSE");
            freeBusy.setText("FREE");
            freeBusy.setEnabled(true);
        }

    }
}
