package com.library.services;

import com.library.domain.Member;
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

    public Member findOne(long id) {
        Member findMember = readerRepository.findOne(id);
        return findMember;
    }

    public Member addReader(Member member) {
        Member addReaders = readerRepository.saveAndFlush(member);
        return addReaders;
    }

    public void delete(long id) {
        readerRepository.delete(id);
    }

    public Member editReader(Member member) {
        Member editReaders = readerRepository.saveAndFlush(member);
        return editReaders;
    }

    public List<Member> getAll() {
        return readerRepository.findAll();
    }
}
