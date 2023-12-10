package com.requestmanagementservice.requestmanagementservice.service;

import com.requestmanagementservice.requestmanagementservice.model.GitHubRequest;

import java.util.List;

public interface GitHubRequestService {
    List<GitHubRequest> getGitHubRequests();
    List<GitHubRequest> getAllRequests();
}
