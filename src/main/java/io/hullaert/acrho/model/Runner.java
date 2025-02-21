package io.hullaert.acrho.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@With
public class Runner {

    @Id @NotNull
    private long id;
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String category;
    @NotNull
    private String team;
    @NotNull @Size(min = 1)
    private int bib;
}
