package com.codingjourney.backend.basic.springbootStartJourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
// through  @Autowired annotation way inject the beans in the application.
//    @Autowired
//   private DB db;

    // through constructor way inject the beans in the application.
    // we should use the constructor injection, bcz it gives the flexibility to make 'private DB db' as final
    final private DB db;

    public DBService(DB db){
        // by making private DB db , as final no one will update it or reassign it.
        // bcz, on making it as final, it can't be reassigned.this is benefit of making it as final.
        // eg.  db = new DevDB();

        this.db = db;
    }

    String getData(){
        return db.getData();
    }
}
