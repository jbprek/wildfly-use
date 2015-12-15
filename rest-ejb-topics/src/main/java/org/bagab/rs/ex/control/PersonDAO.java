package org.bagab.rs.ex.control;

import org.bagab.rs.ex.model.MyApplicationException;
import org.bagab.rs.ex.model.Person;

import javax.ejb.Singleton;
import java.util.*;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author prekezes.
 */
@Singleton
public class PersonDAO {
    private AtomicLong idSequence = new AtomicLong(0);

    // Storage
    private Map<Long, Person> storage = new HashMap<>();

    private Set<String> existingNames  = new HashSet<>();

    /** Create */
    public Person addPerson(String name)    {
        Objects.requireNonNull(name);
        Person person = new Person();
        if ( existingNames.contains(name))
            throw new MyApplicationException("Name " + name + " exists");
        person.setId(idSequence.incrementAndGet());
        person.setName(name);
        storage.put(person.getId(), person);
        existingNames.add(name);
        return person;
    }

    /** Read */
    public Person findPerson(Long id)    {
        Objects.requireNonNull(id);
        return storage.get(id);
    }

    /** Update */
    public Person updatePerson(Person newP)    {
        Objects.requireNonNull(newP);
        Objects.requireNonNull(newP.getId());

        Person old =  storage.get(newP.getId());
        if (old == null)
            throw new MyApplicationException("Not found id " + newP.getId() + "!");

        storage.replace(old.getId(), old, newP);
        return newP;
    }


    /** Delete */
    public Person deletePerson(Long id)    {
        Objects.requireNonNull(id);
        Person p =  storage.get(id);
        if (p == null)
            throw new MyApplicationException("Cannot delete. Not found id " + id + "!");
        return storage.get(id);
    }

    /** Report all */
    public List<Person>  displayAll() {
        List<Person>  r = new ArrayList<>();
        for (Person p : storage.values()) {
            r.add(p);
        }
        return r;
    }


}