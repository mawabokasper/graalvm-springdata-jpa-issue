package za.co.casperian.graalvmspringdatajpaissue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.co.casperian.graalvmspringdatajpaissue.domain.entity.Voucher;
import za.co.casperian.graalvmspringdatajpaissue.domain.repository.VoucherRepository;

import java.util.List;

@SpringBootApplication
@Slf4j
public class GraalvmSpringdataJpaIssueApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraalvmSpringdataJpaIssueApplication.class, args);
	}

	@Bean
	CommandLineRunner queryTop1(VoucherRepository voucherRepository){
		java.lang.reflect.InvocationHandler a;
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				// count method works fine
				log.debug("There are [{}] records in the table", voucherRepository.count());

				// Normal findByMsisdn also works
				List<Voucher> voucherList = voucherRepository.findByMsisdn("0810000000");
				log.debug("Here's the list of MSISDN " + voucherList);
			}
		};
	}
}
