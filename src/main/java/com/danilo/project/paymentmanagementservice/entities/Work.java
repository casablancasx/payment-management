package com.danilo.project.paymentmanagementservice.entities;

import com.danilo.project.paymentmanagementservice.entities.enums.PaymentMethod;
import com.danilo.project.paymentmanagementservice.entities.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private LocalDate date;
    private Integer status;
    private Integer method;
    private Double total;
    private Double deposit;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Work(){}

    public Work(Long id, String destination, LocalDate date, PaymentMethod method, Double total, Double deposit, User client) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        updateStatus();
        setMethod(method);
        this.total = total;
        this.deposit = deposit;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.valueOf(status);
    }

    public void setStatus(PaymentStatus status) {
        if (status != null){
            this.status = status.getCode();
        }
    }

    public PaymentMethod getMethod(){
        return PaymentMethod.valueOf(method);
    }

    public void setMethod(PaymentMethod method){
        if (method != null){
            this.method = method.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public void updateStatus(){
        if (getTotal() == getDeposit()){
            setStatus(PaymentStatus.PAID);
        } else if (getTotal() > getDeposit() && getDeposit() != null) {
            setStatus(PaymentStatus.INCOMPLETE);
        }else {
            setStatus(PaymentStatus.PENDING);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return Objects.equals(id, work.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
