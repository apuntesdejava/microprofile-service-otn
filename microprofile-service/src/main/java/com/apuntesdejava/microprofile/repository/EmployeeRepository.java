package com.apuntesdejava.microprofile.repository;

import com.apuntesdejava.microprofile.entity.Employee;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class EmployeeRepository {

    @Inject
    private EntityManager em;

    public List<Employee> findAll() {
        return em.createQuery("select a from Employee a", Employee.class)
                .getResultList();
    }

    public List<Employee> findRange(int firstResult, int maxResults) {
        return em.createQuery("select a from Employee a", Employee.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList();
    }
}
