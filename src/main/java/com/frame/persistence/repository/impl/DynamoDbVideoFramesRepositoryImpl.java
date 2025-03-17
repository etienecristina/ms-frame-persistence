package com.frame.persistence.repository.impl;

import com.frame.persistence.model.dto.DynamoVideoFrames;
import com.frame.persistence.repository.DynamoDbVideoFramesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class DynamoDbVideoFramesRepositoryImpl implements DynamoDbVideoFramesRepository {

  @Autowired private DynamoDbEnhancedClient enhancedClient;

  @Override
  public DynamoVideoFrames findByKey(String idProcessamento) {
    DynamoDbTable<DynamoVideoFrames> dynamoDbVideoFramesTable =
        enhancedClient.table("DynamoVideoFrames", TableSchema.fromBean(DynamoVideoFrames.class));
    return dynamoDbVideoFramesTable.getItem(Key.builder().partitionValue(idProcessamento).build());
  }

  @Override
  public void save(DynamoVideoFrames videoFrames) {
    DynamoDbTable<DynamoVideoFrames> dynamoDbVideoFramesTable =
        enhancedClient.table("DynamoVideoFrames", TableSchema.fromBean(DynamoVideoFrames.class));
    dynamoDbVideoFramesTable.putItem(videoFrames);
  }
}
