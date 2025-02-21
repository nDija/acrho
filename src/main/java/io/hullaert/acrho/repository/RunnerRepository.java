package io.hullaert.acrho.repository;


import io.hullaert.acrho.model.Runner;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RunnerRepository extends MongoRepository<Runner, String> {

    @NonNull
    Optional<Runner> findById(long s);

    void deleteById(long id);
}

