package com.example.spyne.models;

public class Response<T> {
    private T data;
    private String error;

    public Response(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public Response() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
