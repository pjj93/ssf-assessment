package ibf2021.ssf.ssfassessment.repository;

import static ibf2021.ssf.ssfassessment.Constants.BEAN_BOOK_CACHE;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    
    @Autowired
    @Qualifier(BEAN_BOOK_CACHE)
    private RedisTemplate<String, String> template;

    public void cache(String key, String book) {
        template.opsForValue().set(key, book, 10, TimeUnit.MINUTES);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(template.opsForValue().get(key));
    }
}
