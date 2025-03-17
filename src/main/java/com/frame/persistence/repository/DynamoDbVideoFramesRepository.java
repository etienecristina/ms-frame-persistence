package com.frame.persistence.repository;

import com.frame.persistence.model.dto.DynamoVideoFrames;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamoDbVideoFramesRepository {
  DynamoVideoFrames findByKey(String idProcessamento);
  void save(DynamoVideoFrames videoFrames);
}
