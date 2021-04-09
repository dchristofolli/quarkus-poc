package com.dchristofolli;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    MongoClient mongoClient;

    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        try (MongoCursor<User> cursor = getCollection().find().iterator()) {
            while (cursor.hasNext()) {
                list.add(cursor.next());
            }
        }
        return list;
    }

    public void create(User user) {
        getCollection().insertOne(user);
    }

    private MongoCollection<User> getCollection() {
        return mongoClient.getDatabase("quarkus").getCollection("users", User.class);
    }
}
