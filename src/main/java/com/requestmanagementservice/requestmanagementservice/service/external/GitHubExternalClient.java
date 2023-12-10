package com.requestmanagementservice.requestmanagementservice.service.external;

import com.requestmanagementservice.requestmanagementservice.dto.GitHubRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalClient {
    private final RestTemplate restTemplate;

    @Value("${github.request-detail-url}")
    private String gitHubRequestDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<GitHubRequestDto> getRequestDetails() {
        ResponseEntity<List<GitHubRequestDto>> response = restTemplate.exchange(gitHubRequestDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

    
}

