package com.danilo.project.paymentmanagementservice.entities.enums;

public enum PaymentMethod {
    PIX(1),
    MONEY(2);
    private int code;
    private PaymentMethod(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    public static PaymentMethod valueOf(int code){
        for (PaymentMethod method : PaymentMethod.values()){
            if (method.getCode() == code){
                return method;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentStatus code");
    }
}
