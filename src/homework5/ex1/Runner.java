package homework5.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Bank bank = createBank(1500);
        Thief thief = createThief();
        robBank(thief, bank);

        System.out.println(thief);
        System.out.println(bank);
    }

    private static Bank createBank(int money) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Constructor<Bank> constructor = Bank.class.getDeclaredConstructor(BigDecimal.class);
        constructor.setAccessible(true);
        Bank bank = constructor.newInstance(BigDecimal.valueOf(money));
        constructor.setAccessible(false);
        return bank;
    }

    private static Thief createThief() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Constructor<Thief> thiefConstructor = Thief.class.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        Thief thief = thiefConstructor.newInstance();
        thiefConstructor.setAccessible(false);
        return thief;
    }

    private static void robBank(Thief thief, Bank bank) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method stealMoney = Thief.class.getDeclaredMethod("stealMoney", Bank.class);
        stealMoney.setAccessible(true);
        stealMoney.invoke(thief, bank);
        stealMoney.setAccessible(false);
    }
}