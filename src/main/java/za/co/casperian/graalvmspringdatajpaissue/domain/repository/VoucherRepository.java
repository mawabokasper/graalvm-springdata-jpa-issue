package za.co.casperian.graalvmspringdatajpaissue.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.casperian.graalvmspringdatajpaissue.domain.entity.Voucher;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Integer> {
    List<Voucher> findByMsisdn(String msisdn);
}
