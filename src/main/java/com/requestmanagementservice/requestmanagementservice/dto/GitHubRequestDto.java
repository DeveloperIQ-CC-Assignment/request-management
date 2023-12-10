package com.requestmanagementservice.requestmanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubRequestDto {

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("number")
    private int number;

    @JsonProperty("body")
    private String body;

    @JsonProperty("login")
    private UserDto userDto;



}
