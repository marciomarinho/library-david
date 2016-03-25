package com.library.domain;

import lombok.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

public class DomainObjectTests {

    private PhoneNumber phoneNumber1;

    private PhoneNumber phoneNumber2;

    private PhoneNumber phoneNumber3;

    private Person marcio;

    private Person david;

    private Person jonas;


    @Before
    public void setup() {

        phoneNumber1 = PhoneNumber.builder()
                .id(1)
                .number("11111")
                .build();

        phoneNumber2 = PhoneNumber.builder()
                .id(2)
                .number("22222")
                .build();

        phoneNumber3 = PhoneNumber.builder()
                .id(3)
                .number("33333")
                .build();

        marcio = Person.builder()
                .id(1)
                .name("Marcio")
                .build();

        david = Person.builder()
                .id(2)
                .name("David")
                .build();

        jonas = Person.builder()
                .id(3)
                .name("Jonas")
                .build();

    }

    @Test
    public void shouldEfficientlyRemovePhoneNumberWithNoLoopsAtAll() {

        Set<PhoneNumber> marcioPhones = new HashSet<PhoneNumber>() {{
            add(phoneNumber1);
            add(phoneNumber2);
        }};

        Set<Person> phonePeople = new HashSet<Person>() {{
            add(marcio);
            add(david);
        }};

        marcio.setPhoneNumbers(marcioPhones);
        phoneNumber1.setPeople(phonePeople);

        assertTrue(marcio.getPhoneNumbers().contains(phoneNumber1));
        assertThat(marcio.getPhoneNumbers().size(), is(2));

        marcio.getPhoneNumbers().remove(phoneNumber1);

        assertThat(marcio.getPhoneNumbers().size(), is(1));

    }


}


