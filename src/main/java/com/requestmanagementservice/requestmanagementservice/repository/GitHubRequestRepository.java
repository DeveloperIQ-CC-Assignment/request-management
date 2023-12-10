package com.requestmanagementservice.requestmanagementservice.repository;

import com.requestmanagementservice.requestmanagementservice.model.GitHubRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitHubRequestRepository extends MongoRepository<GitHubRequest, String> {
}
