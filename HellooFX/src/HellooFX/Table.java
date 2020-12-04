/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

/**
 *
 * @author Hau Exoty
 */
public class Table {
    private int id;
    private String busno;
    private int seats;
    private String date;
    private String status;

    public Table(int id, String busno, int seats, String date, String status) {
        this.id = id;
        this.busno = busno;
        this.seats = seats;
        this.date = date;
        this.status = status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the busno
     */
    public String getBusno() {
        return busno;
    }

    /**
     * @param busno the busno to set
     */
    public void setBusno(String busno) {
        this.busno = busno;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
   
}
