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
public class TableCheck {
    private int id;
    private String busno;
    private int seats;
    private String customer;
    private String mobile;
    private String date;
    private String time;
    private String price;
    

    public TableCheck(int id, String busno, int seats, String customer,String mobile,String date, String time,String price) {
        this.setId(id);
        this.setBusno(busno);
        this.setSeats(seats);
        this.setCustomer(customer);
        this.setMobile(mobile);
        this.setDate(date);
        this.setTime(time);
        this.setPrice(price);
        
        
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
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
