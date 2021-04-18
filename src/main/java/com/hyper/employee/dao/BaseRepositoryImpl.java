package com.hyper.employee.dao;

import com.hyper.employee.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

public class BaseRepositoryImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super( entityInformation, entityManager );
        this.entityManager = entityManager;
    }

    @Override
    public T findOrThrowException(ID id) {
        Optional<T> entity = findById( id );
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException( "Resource with id " + id + " not found." );
        }

        return entity.get();
    }
}
