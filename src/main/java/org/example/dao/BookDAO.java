package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    private final EntityManager entityManager;

    @Autowired
    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void assign(int bookId, Person selectedPerson) {
        entityManager.createNativeQuery("UPDATE book SET person_id = ? WHERE id = ?")
                .setParameter(1, selectedPerson.getId())
                .setParameter(2, bookId)
                .executeUpdate();
    }

    public void release(int id) {
        entityManager.createNativeQuery("UPDATE book SET person_id = NULL WHERE id = ?")
                .setParameter(1, id)
                .executeUpdate();
    }
}
