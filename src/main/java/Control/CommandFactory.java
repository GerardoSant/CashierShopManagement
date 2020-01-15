package Control;

import Control.Commands.BusyCommand;
import Control.Commands.CloseCommand;
import Control.Commands.FreeCommand;
import Control.Commands.OpenCommand;
import Model.Cashier;
import View.CashierDisplay;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Cashier cashier;
    private CashierDisplay cashierDisplay;

    public CommandFactory(Cashier cashier, CashierDisplay cashierDisplay) {
        this.cashier = cashier;
        this.cashierDisplay = cashierDisplay;
    }

    public Map<String,Command> build(){
        Map commands = new HashMap();
        commands.put("OPEN", new OpenCommand(cashier));
        commands.put("CLOSE", new CloseCommand(cashier));
        commands.put("FREE", new FreeCommand(cashier, cashierDisplay));
        commands.put("BUSY", new BusyCommand(cashier));
        commands.put("CALL", new BusyCommand(cashier));
        return commands;
    }
}
