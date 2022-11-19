package ru.croc.task11.lot;

import java.time.LocalTime;

public class Lot {
    private volatile float currentValue;
    private volatile String username;
    private final LocalTime endTimeTrading;

    private static final Object lock = new Object();

    /**
     * Создаёт новый {@code Lot}
     *
     * @param startValue     - начальная стоимость
     * @param endTimeTrading - время окончнания торгов
     */
    public Lot(float startValue, LocalTime endTimeTrading) {
        this.currentValue = startValue;
        this.endTimeTrading = endTimeTrading;
    }

    public void placeBet(int newValue, String newUsername) {

        LocalTime time = LocalTime.now();
        synchronized (lock) {
            if ((newValue > currentValue) && (time.isBefore(endTimeTrading))) {
                //синхронизация позволяет добиться потокобезопасности метода
                currentValue = newValue;// чтобы пользователи могли одновременно делать ставка
                username = newUsername;
            }

        }

    }

    public String getUsername() {
        LocalTime time = LocalTime.now();
        if (time.isBefore(endTimeTrading)) {
            return username;
        } else {
            System.out.println("Торги ещё ведутся, победитель не установлен");
        }

        return null;
    }

}
