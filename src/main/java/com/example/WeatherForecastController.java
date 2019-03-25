package com.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherForecastController<IAmazonDynamoDB> {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
    .withRegion(Regions.AP_SOUTH_1)
    .build();  
    DynamoDB dynamoDB = new DynamoDB(client);
    @CrossOrigin(origins = "*")
        @RequestMapping("/api/SampleData/WeatherForecasts")
        public ArrayList greeting() {

            Table table = dynamoDB.getTable("ADL_Documentation");
            System.out.println(table.getTableName());
            ScanRequest scanRequest = new ScanRequest()
            .withTableName("ADL_Documentation");
            ScanResult result = client.scan(scanRequest);
            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":pr", "ADL50");

            ItemCollection<ScanOutcome> items = table.scan("id < :pr","id, imgURL, activity,SubActivity",null,expressionAttributeValues);
            Iterator<Item> iterator = items.iterator();
            ArrayList allItems=new ArrayList<String>();
            while (iterator.hasNext()) {
            allItems.add(iterator.next().toJSONPretty());
        }

        try {
            System.out.println("Attempting to read the item...");
            System.out.println("GetItem succeeded getting full list: " + allItems);
        }
        catch (Exception e) {
            System.err.println("Unable to read item");
            System.err.println(e.getMessage());
        }
            System.out.println("GetItem succeeded getting full list: " + allItems);
        return allItems;
    }
    @RequestMapping(value="/api/postAdl", method = RequestMethod.POST)
    public void postRequest(@RequestBody ADL_Document adlData) {
        Table table = dynamoDB.getTable("ADL_Document_Saving");
        System.out.println(table.getTableName());
        table.putItem(new Item()
        .withPrimaryKey("NurseId", adlData.NurseId,"PatientId",adlData.PatientId)
        .withString("id", adlData.getId())
        .withString("activity", adlData.getActivity())
        .withString("activityReportValue", adlData.getActivityReportValue())
        .withString("SubActivity", adlData.getSubActivity()).base64Decode()
        .withString("SupportProvided", adlData.getSupportProvided())
        .withString("SupportProvidedReportValue", adlData.getSupportProvidedReportValue())
        .withString("dateTime", adlData.getDateTime()));
}
}
