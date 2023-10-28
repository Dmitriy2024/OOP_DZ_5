package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TableModel implements Model {

    private List<Table> tables;

    public TableModel() {
        tables = new ArrayList<>();
        tables.add(new Table());
        tables.add(new Table());
        tables.add(new Table());
        tables.add(new Table());
        tables.add(new Table());
    }

    /**
     * Получить все столики
     *
     * @return список столиков
     */
    @Override
    public Collection<Table> loadTables() {
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     * @return номер резерва, если успешно забронировано, или -1 в противном случае
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    /**
     * Изменить бронь столика
     *
     * @param oldReservation   номер старого резерва (для снятия)
     * @param reservationDate  дата резерва столика
     * @param tableNo          номер столика
     * @param name             Имя
     * @return номер резерва, если успешно изменено, или -1 в противном случае
     */
//    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
//        for (Table table : tables) {
//            if (table.getReservations().removeIf(reservation -> reservation.getId() == oldReservation)) {
//                Reservation newReservation = new Reservation(reservationDate, name);
//                table.getReservations().add(newReservation);
//                return newReservation.getId();
//            }
//        }
//        return -1;
//    }
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){

        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                for (Reservation reservation : table.getReservations()) {
                    if (reservation.getId() == oldReservation) {
                        // Удаляем старую бронь
                        table.getReservations().remove(reservation);

                        // Создаем новую бронь с указанными параметрами
                        Reservation newReservation = new Reservation(reservationDate, name);
                        table.getReservations().add(newReservation);

                        return newReservation.getId(); // Возвращаем идентификатор новой брони

                    }
                }
            }
        }
        return  -1;
    }
}