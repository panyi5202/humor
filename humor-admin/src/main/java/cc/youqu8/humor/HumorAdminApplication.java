package cc.youqu8.humor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class HumorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumorAdminApplication.class, args);
	}
}
