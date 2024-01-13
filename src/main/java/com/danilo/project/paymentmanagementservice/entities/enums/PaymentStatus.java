package com.danilo.project.paymentmanagementservice.entities.enums;

public enum PaymentStatus {
    PAID(1),
    INCOMPLETE(2),
    PENDING(3);

    private int code;

    private PaymentStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }

    public static PaymentStatus valueOf(int code){
        for(PaymentStatus x : PaymentStatus.values()){
            if (x.getCode() == code){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentStatus code");
    }
}
