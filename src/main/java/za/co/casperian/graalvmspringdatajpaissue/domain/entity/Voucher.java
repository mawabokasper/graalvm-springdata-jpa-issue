package za.co.casperian.graalvmspringdatajpaissue.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Voucher {
    @Id
    private Integer id;
    private String msisdn;
    private int status;
    private Date dateCreated;
}
