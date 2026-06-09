package com.dto;


public class DashboardResponse {

    private Long vendorCount;
    private Long bookingCount;
    private Double budgetLeft;

    public Long getVendorCount() {
        return vendorCount;
    }

    public void setVendorCount(Long vendorCount) {
        this.vendorCount = vendorCount;
    }

    public Long getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(Long bookingCount) {
        this.bookingCount = bookingCount;
    }

    public Double getBudgetLeft() {
        return budgetLeft;
    }

    public void setBudgetLeft(Double budgetLeft) {
        this.budgetLeft = budgetLeft;
    }
}