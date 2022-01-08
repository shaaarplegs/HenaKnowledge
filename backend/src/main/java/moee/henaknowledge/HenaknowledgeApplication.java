package moee.henaknowledge;



import moee.henaknowledge.dto.AdminDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.service_interfaces.IAdminService;
import moee.henaknowledge.util.constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.Date;
import java.time.LocalDate;


@SpringBootApplication
@EnableAsync
public class HenaknowledgeApplication  {


    public static void main(String[] args) {

        SpringApplication.run(HenaknowledgeApplication.class, args);
    }
}
