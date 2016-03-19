package com.library.services;

import com.library.domain.entities.Reader;
import com.library.domain.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    @Qualifier("readerRepository")
    private ReaderRepository readerRepository;

    public Reader findOne(long id) {
        Reader findReader = readerRepository.findOne(id);
        return findReader;
    }

    public Reader addReader(Reader reader) {
        Reader addReaders = readerRepository.saveAndFlush(reader);
        return addReaders;
    }

    public void delete(long id) {
        readerRepository.delete(id);
    }

    public Reader editReader(Reader reader) {
        Reader editReaders = readerRepository.saveAndFlush(reader);
        return editReaders;
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }
}
