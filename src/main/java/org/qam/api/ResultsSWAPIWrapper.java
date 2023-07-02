package org.qam.api;

public class ResultsSWAPIWrapper {
    private Integer count = -1;
    private String next = null;
    private String previous = null;


    public Integer getCount() {
        return count;
    }

    public ResultsSWAPIWrapper setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getNext() {
        return next;
    }

    public ResultsSWAPIWrapper setNext(String next) {
        this.next = next;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public ResultsSWAPIWrapper setPrevious(String previous) {
        this.previous = previous;
        return this;
    }
}
