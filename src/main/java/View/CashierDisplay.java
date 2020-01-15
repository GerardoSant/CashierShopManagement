package View;

import Model.Cashier;

public interface CashierDisplay extends Observer {
    void show(Cashier cashier);
}
