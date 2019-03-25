package com.example;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.joda.time.DateTime;

@DynamoDBTable(tableName = "ADL_Document_Saving")
public class ADL_Document {         

            public String id;
            public String NurseId;
            public String PatientId;
            public String activity;
            public String activityReportValue;
            public String SubActivity;
            public String SupportProvided;
            public String SupportProvidedReportValue;
            public String dateTime;

            public ADL_Document(){}
             public ADL_Document(String id, String activity, String  SupportProvided,String SubActivity,String activityReportValue,String SupportProvidedReportValue,
             String NurseId,String PatientId,String dateTime) {
                 this.id = id;
                 this.NurseId = NurseId;
                 this.PatientId = PatientId;
                 this.activity = activity;
                 this.SupportProvidedReportValue = SupportProvidedReportValue;
                 this.SupportProvided = SupportProvided;
                 this.activityReportValue = activityReportValue;
                 this.SubActivity=SubActivity;
                 this.dateTime=dateTime;
            }          

            public String getId() {
                return id;
            }      
            @DynamoDBHashKey
            public String getNurseId() {
                return NurseId;
            }
            @DynamoDBRangeKey
            public String getPatientId() {
                return PatientId;
            }     
            @DynamoDBAttribute
            public String getActivity() {
                return activity;
            }          
            @DynamoDBAttribute
            public String getSupportProvided() {
                return SupportProvided;
            }
            @DynamoDBAttribute
            public String getSubActivity() {
                return SubActivity;
            }
            @DynamoDBAttribute
            public String getSupportProvidedReportValue() {
                return SupportProvidedReportValue;
            }
            @DynamoDBAttribute
            public String getActivityReportValue() {
                return activityReportValue;
            }
            @DynamoDBAttribute
            public String getDateTime() {
                return dateTime;
            }
        }
