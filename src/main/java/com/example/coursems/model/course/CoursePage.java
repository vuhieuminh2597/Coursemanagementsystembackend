package com.example.coursems.model.course;

public class CoursePage {
    private Integer page;
    private Integer totalPages;
    private Integer size;
    private Long totalElement;
    private String next;
    private String previous;
    private Object data;

    public CoursePage() {
    }

    public CoursePage(Integer page, Integer size, Object data) {
        this.page = page;
        this.size = size;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(Long totalElement) {
        this.totalElement = totalElement;
    }

    public String getNext() {
        return next;
    }

    public void setNext(Integer page, Integer size, Long totalElement,Integer totalPages) {
        if (page != null && size != null && totalElement > size && page + 2 <= totalPages) {
            StringBuilder builder = new StringBuilder("http://localhost:8080/api/v1/course");
            builder.append("?page=" + (page + 2));
            builder.append("&size=" + size);
            this.next = builder.toString();
        }
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(Integer page, Integer size, Long totalElement) {
        if (page != null && size != null && totalElement > size && page > 1) {
            StringBuilder builder = new StringBuilder("http://localhost:8080/api/v1/course");
            builder.append("?page=" + (page - 1));
            builder.append("&size=" + size);
            this.previous = builder.toString();
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
