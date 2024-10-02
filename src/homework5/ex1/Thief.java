package homework5.ex1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Thief {
    private static final String FIELD_NAME_BANK_WITH_MONEY = "money";
    private static final String METHOD_NAME_BANK_SET_MONEY = "setMoney";

    private BigDecimal money;

    private Thief() {
        this.money = ZERO;
    }

    private void stealMoney(Bank bank) throws IllegalAccessException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException {
        BigDecimal stolenMoney = checkMoneyInBank(bank);
        addMoney(stolenMoney);
        nullifyBank(bank);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }

    private BigDecimal checkMoneyInBank(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        Field bankMoney = bank.getClass()
                .getDeclaredField(FIELD_NAME_BANK_WITH_MONEY);
        bankMoney.setAccessible(true);
        BigDecimal money = (BigDecimal) bankMoney.get(bank);
        bankMoney.setAccessible(false);
        return money;
    }

    private void addMoney(BigDecimal money) {
        if (isNull(money)) {
            return;
        }
        if (nonNull(this.money)) {
            this.money = this.money.add(money);
            return;
        }
        this.money = money;
    }

    private void nullifyBank(Bank bank) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Method setMoneyToBank = bank.getClass()
                .getDeclaredMethod(METHOD_NAME_BANK_SET_MONEY, BigDecimal.class);
        setMoneyToBank.setAccessible(true);
        setMoneyToBank.invoke(bank, ZERO);
        setMoneyToBank.setAccessible(false);
    }
}