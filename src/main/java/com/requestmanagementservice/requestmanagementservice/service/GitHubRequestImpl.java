package com.requestmanagementservice.requestmanagementservice.service;

import com.requestmanagementservice.requestmanagementservice.dto.GitHubRequestDto;
import com.requestmanagementservice.requestmanagementservice.model.GitHubRequest;
import com.requestmanagementservice.requestmanagementservice.repository.GitHubRequestRepository;
import com.requestmanagementservice.requestmanagementservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubRequestImpl implements GitHubRequestService{

    private final GitHubExternalClient githubExternalClient;
    private final GitHubRequestRepository gitHubRequestRepository;


    @Override
    public List<GitHubRequest> getGitHubRequests() {
        List<GitHubRequest> gitHubRequests = new ArrayList<>();

        List<GitHubRequestDto> gitHubRequestDtoList = this.githubExternalClient.getRequestDetails();

        gitHubRequestDtoList.forEach(gitHubRequestDto -> {
            GitHubRequest gitHubRequest = this.generateGitHubRequestObject(gitHubRequestDto);
            gitHubRequests.add(gitHubRequest);
        });

        this.gitHubRequestRepository.saveAll(gitHubRequests);

        return gitHubRequests;
    }

    @Override
    public List<GitHubRequest> getAllRequests() {
        return this.gitHubRequestRepository.findAll();
    }



    private GitHubRequest generateGitHubRequestObject(GitHubRequestDto gitHubRequestDto) {
        return GitHubRequest.builder()
                .node_id(gitHubRequestDto.getNodeId())
                .number(gitHubRequestDto.getNumber())
                .login(gitHubRequestDto.getUserDto().getLogin())
                .body(gitHubRequestDto.getBody())
                .build();
    }
}
