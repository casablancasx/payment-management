package com.danilo.project.paymentmanagementservice.entities.enums;

public enum WorkerStatus {
    PAID(1),
    INCOMPLETE(2),
    PENDING(3);

    private int code;

    private WorkerStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }

    public static WorkerStatus valueOf(int code){
        for(WorkerStatus x : WorkerStatus.values()){
            if (x.getCode() == code){
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid WorkerStatus code");
    }
}
