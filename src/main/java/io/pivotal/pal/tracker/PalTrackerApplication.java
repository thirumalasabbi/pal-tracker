package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    @Autowired
    DataSource dataSouce;

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
    @Bean
    public TimeEntryRepository createTimeEntryRepository(){
        return new JdbcTimeEntryRepository(dataSouce);
    }


}
