package com.requestmanagementservice.requestmanagementservice.repository;

import com.requestmanagementservice.requestmanagementservice.model.GitHubRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubRequestRepository extends MongoRepository<GitHubRequest, String> {
}
