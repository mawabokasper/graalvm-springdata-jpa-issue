package za.co.casperian.graalvmspringdatajpaissue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.co.casperian.graalvmspringdatajpaissue.domain.entity.Voucher;
import za.co.casperian.graalvmspringdatajpaissue.domain.repository.VoucherRepository;

@SpringBootApplication
@Slf4j
public class GraalvmSpringdataJpaIssueApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraalvmSpringdataJpaIssueApplication.class, args);
	}

	@Bean
	CommandLineRunner queryTop1(VoucherRepository voucherRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.debug("There are [{}] records in the table", voucherRepository.count());
				Voucher voucher = voucherRepository.findTop1ByMsisdnAndStatusIsOrderByDateCreatedAsc("0810000000",0).orElse(null);
				log.debug("We found the voucher - {}",voucher);
			}
		};
	}
}
