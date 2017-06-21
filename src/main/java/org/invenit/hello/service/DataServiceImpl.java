package org.invenit.hello.service;

import org.invenit.hello.entity.Data;
import org.invenit.hello.repostiroty.DataRepository;
import org.invenit.hello.utils.registry.Registry;
import org.invenit.hello.utils.registry.config.EntityTypeLookupConfigurationLambda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    private DataRepository dataRepository;

    private Registry<Function<String, String>> mapping = EntityTypeLookupConfigurationLambda.get();

    @Override
    public void persist(String problem) {
        dataRepository.save(new Data(problem));
    }

    @Override
    public Set<String> getRandomData() {
        Page<Data> randomData = dataRepository.findAll(new PageRequest(0, 50));
        return randomData.getContent().stream()
            .map(Data::getDescription)
            .map((value) -> {
                Optional<Function<String, String>> mappedValue = mapping.find(value);
                return mappedValue.isPresent() ? mappedValue.get().apply(value) : value;
            })
            .collect(Collectors.toSet());
    }
}
