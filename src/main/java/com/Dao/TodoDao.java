package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Todo;

@Repository
public class TodoDao {  
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(Todo t) {
        Integer i = (Integer) hibernateTemplate.save(t);
        return i;
    }
    
    public List<Todo> getAll() {
        List<Todo> todos = this.hibernateTemplate.loadAll(Todo.class);
        return todos;
    }
}
