package Implementation;

import Model.Cashier;
import View.CashierLoader;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        CashierLoader cashierLoader = new CashierLoader() {
            @Override
            public List<Cashier> load() {
                List<Cashier> cashierList = new ArrayList<Cashier>();
                cashierList.add(new Cashier(1));
                cashierList.add(new Cashier(2));
                cashierList.add(new Cashier(3));
                cashierList.add(new Cashier(4));
                cashierList.add(new Cashier(5));
                return cashierList;
            }
        };
        Mainframe mainframe = new Mainframe(cashierLoader.load());
        mainframe.execute();
    }
}
