package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Boo yah!");

        System.out.println("Connect to MongoDB on local system - we're using port 27000...");
        MongoClient mongoClient = new MongoClient("mongo-dbserver");

        System.out.println("Get a database - will create when we use it...");
        MongoDatabase database = mongoClient.getDatabase("mydb");

        System.out.println("Get a collection from the database...");
        MongoCollection<Document> collection = database.getCollection("test");

        System.out.println("Create a document to store...");
        Document doc = new Document("name", "Kevin Chalmers")
                .append("class", "Software Engineering Methods")
                .append("year", "2018/19")
                .append("result", new Document("CW", 95).append("EX", 85));

        System.out.println("Add document to collection...");
        collection.insertOne(doc);

        System.out.println("Check document in collection...");
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}