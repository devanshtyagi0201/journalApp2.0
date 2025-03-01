package com.dev.journalApp.repository;
import com.dev.journalApp.entity.JournalEntry;
import com.dev.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);

}