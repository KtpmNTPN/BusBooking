/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

/**
 *
 * @author Hau Exoty
 */
public class TableCheck {
    private int id;
    private String busno;
    private int seat;
    private String customer;
    private String mobile;
    private String date;
    private String time;
    private String price;
    

    public TableCheck(int id, String busno, int seat, String customer,String mobile,String date, String time,String price) {
        this.id = id;
        this.busno = busno;
        this.seat = seat;
        this.customer = customer;
        this.mobile = mobile;
        this.date = date;
        this.time = time;
        this.price = price;
        
        
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
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seats to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
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
