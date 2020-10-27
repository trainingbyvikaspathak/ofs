/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

/**
 *
 * @author Dell
 */
public class Review {
    private int id,product_id,shopkeeper_id;
    String name, email,subject,message,status;

    public Review() {
    }

    public Review(int id, int product_id, int shopkeeper_id, String name, String email, String subject, String message) {
        this.id = id;
        this.product_id = product_id;
        this.shopkeeper_id = shopkeeper_id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getShopkeeper_id() {
        return shopkeeper_id;
    }

    public void setShopkeeper_id(int shopkeeper_id) {
        this.shopkeeper_id = shopkeeper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
