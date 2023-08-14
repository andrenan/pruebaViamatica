package com.example.demo.services;

import com.example.demo.model.Sessions;
import com.example.demo.repository.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SessionService {
    @Autowired
    SessionsRepository placeRepository;

    List<Sessions> list() {
        /*
        * try
        * */
        return placeRepository.findAll();
    }


}
