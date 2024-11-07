package org.example.dao;

import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        session = sessionFactory.getCurrentSession();

        // Здесь будет наш обычный Hibernate код
        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();

        return people;
    }

    // [new Person]
    // [null]
    @Transactional(readOnly = true)
    public Person show(int id) {
        session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);

        return person;
    }

    @Transactional
    public void save(Person person) {
        session = sessionFactory.getCurrentSession();
        session.save(person);

    }
    @Transactional
    public void update(int id, Person updatedPerson) {
        session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());

    }
    @Transactional
    public void delete(int id) {
        session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.delete(person);
    }
}
