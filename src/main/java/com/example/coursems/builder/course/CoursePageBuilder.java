package com.example.coursems.builder.course;

import com.example.coursems.model.course.CoursePage;

public class CoursePageBuilder {
    private CoursePage coursePage = new CoursePage();

    public CoursePageBuilder setPage (int page){
        coursePage.setPage(page);
        return this;
    }
    public CoursePageBuilder setTotalPages (int totalPages){
        coursePage.setTotalPages(totalPages);
        return this;
    }
    public CoursePageBuilder setSize (int size){
        coursePage.setSize(size);
        return this;
    }
    public CoursePageBuilder setTotalElement (Long totalElement){
        coursePage.setTotalElement(totalElement);
        return this;
    }
    public CoursePageBuilder setNext (Integer page,Integer size,Long totalElement,Integer totalPage){
        coursePage.setNext(page,size,totalElement,totalPage);
        return this;
    }
    public CoursePageBuilder setPrevious (Integer page,Integer size,Long totalElement){
        coursePage.setPrevious(page,size,totalElement);
        return this;
    }
    public CoursePageBuilder setData (Object data){
        coursePage.setData(data);
        return this;
    }
    public CoursePage build (){
        return coursePage;
    }
    
}
