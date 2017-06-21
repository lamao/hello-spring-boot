package org.invenit.hello.repostiroty;

import org.invenit.hello.entity.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author Vycheslav Mischeryakov (vmischeryakov@gmail.com)
 */
@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

    Page<Data> findAll(Pageable pageable);

}
