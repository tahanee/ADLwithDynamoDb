package com.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.regions.Regions;

/**
 * Hello world!
 * 
 * @param <IAmazonDynamoDB>
 *
 */
@SpringBootApplication
public class App
{
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        .withRegion(Regions.AP_SOUTH_1)
        .build();  
       /* DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("RequestRequisition");

        //int year = 2015;
        //String title = "The Big New Movie";

        GetItemSpec spec = new GetItemSpec().withPrimaryKey();

        try {
            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);

        }
        catch (Exception e) {
            System.err.println("Unable to read item");
            System.err.println(e.getMessage());
        } */

        SpringApplication.run(App.class, args);
        
    }
}
