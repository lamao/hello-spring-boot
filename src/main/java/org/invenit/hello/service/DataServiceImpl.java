package org.invenit.hello.service;

import java.sql.Date;
import java.util.function.Function;

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
    public void persist(Data data) {
        data.setTime(new Date(System.currentTimeMillis()));
        dataRepository.save(data);
    }

    @Override
    public Page<Data> getRandomData() {
        return dataRepository.findAll(new PageRequest(0, 50));
    }
}
