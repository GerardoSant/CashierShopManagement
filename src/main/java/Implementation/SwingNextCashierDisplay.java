package Implementation;

import Model.Cashier;
import View.CashierDisplay;

import javax.swing.*;
import java.util.List;

public class SwingNextCashierDisplay extends JPanel implements CashierDisplay {

    private JLabel label;
    List<Cashier> cashierList;

    public SwingNextCashierDisplay(List<Cashier> cashierList) {
        this.cashierList= cashierList;
        createUI();
    }

    private void createUI() {
        label = new JLabel("No available cashiers.");
        add(label);
    }


    @Override
    public void show(Cashier cashier) {
        label.setText("Next available cashier: " + cashier.getId());
    }

    @Override
    public void update() {
        boolean thereIsFree=false;
        for (Cashier cashier : cashierList){
            if (cashier.getStatus().name().equals("FREE")){
                show(cashier);
                thereIsFree=true;
                break;
            }
        }
        if (!thereIsFree){
            label.setText("No available cashiers");
        }

    }
}
