package com.nw.nw.repo;

import com.nw.nw.models.Sweets;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SweetsRepo extends CrudRepository<Sweets,Long>  {


}
