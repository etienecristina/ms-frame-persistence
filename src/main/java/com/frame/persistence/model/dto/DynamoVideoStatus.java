package com.frame.persistence.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Setter
@ToString
@DynamoDbBean
public class DynamoVideoStatus {

  private String idProcessamento;
  @Getter private String username;
  @Getter private String videoName;
  @Getter private String status;

  @DynamoDbPartitionKey
  public String getIdProcessamento() {
    return this.idProcessamento;
  }

}
