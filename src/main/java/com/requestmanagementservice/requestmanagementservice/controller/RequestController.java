package com.requestmanagementservice.requestmanagementservice.controller;

import com.requestmanagementservice.requestmanagementservice.model.GitHubRequest;
import com.requestmanagementservice.requestmanagementservice.service.GitHubRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")
public class RequestController {

    private GitHubRequestService gitHubRequestService;

    @GetMapping("/requests")
    public ResponseEntity<List<GitHubRequest>> getGitHubRequests() {
        return ResponseEntity.ok(this.gitHubRequestService.getGitHubRequests());
    }

    @GetMapping("/requests/get-all")
    public ResponseEntity<List<GitHubRequest>> getAllRequests() {
        return ResponseEntity.ok(this.gitHubRequestService.getAllRequests());
    }
}
