package za.co.casperian.graalvmspringdatajpaissue.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.casperian.graalvmspringdatajpaissue.domain.entity.Voucher;
import java.util.Optional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    public Optional<Voucher> findTop1ByMsisdnAndStatusIsOrderByDateCreatedAsc(
            String msisdn, int status);
}
