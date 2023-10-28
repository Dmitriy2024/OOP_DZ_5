package ru.geekbrains.lesson5.views;
import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Отобразить столики на экране приложения
     *
     * @param tables коллекция столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Не удалось забронировать столик, повторите попытку позже.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);

    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {

    }

    @Override
    public void changeReservationTable(int reservationNo) {
        if (reservationNo > 0){
            Object changeReservationTable = null;
            System.out.printf(" Номер вашей брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Не удалось забронировать столик.");
        }
    }

    @Override
    public void changeReservationTable(Date date, int i, String name) {

    }

}











