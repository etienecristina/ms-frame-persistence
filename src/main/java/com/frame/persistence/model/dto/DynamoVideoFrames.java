package com.frame.persistence.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Setter
@ToString
@DynamoDbBean
public class DynamoVideoFrames {

  private String idProcessamento;
  @Getter private String username;
  @Getter private String videoName;
  @Getter private int frameId;
  @Getter private String frameByteAsString;

  @DynamoDbPartitionKey
  public String getIdProcessamento() {
    return this.idProcessamento;
  }

}
