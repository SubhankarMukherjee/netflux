package com.connecttosubh.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String movieId;
    @NonNull
    private String title;
}
