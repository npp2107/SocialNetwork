package npp.socialnetwork.postserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "npp.socialnetwork.postserver.repository")
@EnableMongoAuditing
public class MongoDBConfig {
//    private static final String MONGO_DB_URL = "mongodb+srv://fashion_ecommerce:fashionecommerce@fashionecommercecluster.arypbfs.mongodb.net/fashion_ecommerce?retryWrites=true&w=majority";
    private static final String MONGO_DB_URL = "mongodb://localhost:27017/PostDatabaseServer";

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(MONGO_DB_URL);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}