package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories({"es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository"})
@EnableTransactionManagement
public class PersistanceConfig {

}
