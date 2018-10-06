package com.apuntesdejava.microprofile.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JPAProducer {

    @Produces //productor para inyección
    @PersistenceContext 
    private EntityManager em;
}

