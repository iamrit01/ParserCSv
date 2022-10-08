package com.example.orders_parser;

public class Orders {
    private int OrderId;
    private int amount;
    private String currency;
    private String comment;
    private String filename;
    private int line;
    private String result;

    public Orders(int OrderId, int amount, String currency, String comment) {
        this.OrderId = OrderId;
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + "\"orderId\"" + ":" + this.getOrderId()+",");
        sb.append("\"amount\"" + ":" + this.getAmount()+",");
        sb.append("\"currency\"" + ":" + "\"" +  this.getCurrency()+ "\"" + ",");
        sb.append("\"comment\"" + ":" + "\"" +  this.getComment()+ "\"" + ",");
        sb.append("\"filename\"" + ":" + "\"" +  this.getFilename()+ "\"" + ",");
        sb.append("\"line\"" + ":" + this.getLine()+",");
        sb.append("\"result\"" + ":" + "\"" + this.getResult()+ "\"" + "}");
        return sb.toString();
    }
};
