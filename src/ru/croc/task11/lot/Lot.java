package ru.croc.task11.lot;

import java.time.LocalTime;

public class Lot {
    float currentValue;
    String username;
    LocalTime endTimeTrading;

    private static final Object lock = new Object();

    /**
     * Создаёт новый {@code Lot}
     *
     * @param currentValue   - начальная стоимость
     * @param endTimeTrading - время окончнания торгов
     */
    public Lot(float currentValue, LocalTime endTimeTrading) {
        this.endTimeTrading = endTimeTrading;
    }

    public void placeBet(int newValue, String newUsername) {

        LocalTime time = LocalTime.now();
        if ((newValue > currentValue) && (time.isBefore(endTimeTrading))) {
            synchronized (lock) { //синхронизация позволяет добиться потокобезопасности метода
                currentValue = newValue;// чтобы пользователи могли одновременно делать ставка
                username = newUsername;
            }
        } else {
            System.out.println("Ставка не может быть совершена");
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
