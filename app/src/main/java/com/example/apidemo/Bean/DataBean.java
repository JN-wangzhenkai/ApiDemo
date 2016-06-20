package com.example.apidemo.Bean;

/**
 * Created by wangzhenkai on 2016/6/19.
 */
public class DataBean <T>{

    private String error;

   private T results;

    public DataBean() {
    }

    public void setResults(T results) {
        this.results = results;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public T getResults() {
        return results;
    }
}
