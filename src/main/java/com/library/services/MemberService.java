package com.library.services;

import com.library.domain.Member;
import com.library.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    @Qualifier("memberRepository")
    private MemberRepository readerRepository;

    public Member findOne(long id) {
        Member findReader = readerRepository.findOne(id);
        return findReader;
    }

    public Member addReader(Member reader) {
        Member addReaders = readerRepository.saveAndFlush(reader);
        return addReaders;
    }

    public void delete(long id) {
        readerRepository.delete(id);
    }

    public Member editReader(Member reader) {
        Member editReaders = readerRepository.saveAndFlush(reader);
        return editReaders;
    }

    public List<Member> getAll() {
        return readerRepository.findAll();
    }
}
