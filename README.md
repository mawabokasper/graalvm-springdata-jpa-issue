# Spring Data GraalVM Issue

this code demonstrates **com.oracle.svm.core.jdk.UnsupportedFeatureError** with Spring Data JPA Query

## Steps to Reproduce

### 1. Check out the code

```agsl
git clone https://github.com/mawabokasper/graalvm-springdata-jpa-issue.git
```

### 2. Build an image

```agsl
 mvn clean -Pnative native:compile
```

### 3. Run the image
```agsl
./target/graalvm-springdata-jpa-issue
```

## Workaround 

### 1. Run the jar with the native-image-agent (or just copy the META-INF folder at the root to src/main/resources)
```agsl
$JAVA_HOME/bin/java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar target/graalvm-springdata-jpa-issue-0.0.1-SNAPSHOT.jar
```

### 2. Rebuild the image
```agsl
 mvn clean -Pnative native:compile
```

### 3. Run the image
```agsl
./target/graalvm-springdata-jpa-issue
```


## Code Overview

### Database table

```create table voucher(id integer not null primary key auto_increment, msisdn varchar(10) not null, status integer not null,date_created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP);```

### Data (loaded on startup)

```agsl
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);
insert into voucher(msisdn,status) values ('0810000000',0);

```
### Entity
```agsl
@Entity
@Data
public class Voucher {
@Id
private Integer id;
private String msisdn;
private int status;
private Date dateCreated;
}
```

### Repository 

```agsl
@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Integer> {
List<Voucher> findByMsisdn(String msisdn);
}
```





