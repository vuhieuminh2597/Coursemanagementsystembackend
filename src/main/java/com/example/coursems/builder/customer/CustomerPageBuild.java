package com.example.coursems.builder.customer;

import com.example.coursems.model.customer.CustomerPage;

public class CustomerPageBuild {
    private CustomerPage customerPage = new CustomerPage();

    public CustomerPageBuild setPage (int page){
        customerPage.setPage(page);
        return this;
    }
    public CustomerPageBuild setTotalPages (int totalPages){
        customerPage.setTotalPages(totalPages);
        return this;
    }
    public CustomerPageBuild setSize (int size){
        customerPage.setSize(size);
        return this;
    }
    public CustomerPageBuild setTotalElement (Long totalElement){
        customerPage.setTotalElement(totalElement);
        return this;
    }
    public CustomerPageBuild setNext (Integer page,Integer size,Long totalElement,Integer totalPage){
        customerPage.setNext(page,size,totalElement,totalPage);
        return this;
    }
    public CustomerPageBuild setPrevious (Integer page,Integer size,Long totalElement){
        customerPage.setPrevious(page,size,totalElement);
        return this;
    }
    public CustomerPageBuild setData (Object data){
        customerPage.setData(data);
        return this;
    }
    public CustomerPage build (){
        return customerPage;
    }
}
