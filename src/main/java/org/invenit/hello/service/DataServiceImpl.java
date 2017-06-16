package org.invenit.hello.service;

import org.invenit.hello.entity.Data;
import org.invenit.hello.repostiroty.DataRepository;
import org.invenit.hello.utils.registry.Registry;
import org.invenit.hello.utils.registry.config.EntityTypeLookupConfigurationLambda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    @Autowired
    @Qualifier("dataRespitory")
    private DataRepository<Data> dataRepository;

    private Registry<Function<String, String>> mapping = EntityTypeLookupConfigurationLambda.get();

    @Override
    public boolean persist(String problem) {
        try {
            dataRepository.persist(new Data(UUID.randomUUID(), problem));
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> randomData = dataRepository.getRandomData();
        return randomData.stream()
            .map((value) -> {
                Optional<Function<String, String>> mappedValue = mapping.find(value);
                return mappedValue.isPresent() ? mappedValue.get().apply(value) : value;
            })
            .collect(Collectors.toSet());
    }
}
