package com.jdev.eduportal.service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class DbSecureRemover<T, R extends CrudRepository<T, Long>> {

    private R repository;

    public DbSecureRemover(R repository) {
        this.repository = repository;
    }

    public boolean removeElementById(Long elementId) {
        Optional<T> elementOptional = repository.findById(elementId);
        if (elementOptional.isPresent()) {
            repository.delete(elementOptional.get());
            return true;
        }
        return false;
    }

}
