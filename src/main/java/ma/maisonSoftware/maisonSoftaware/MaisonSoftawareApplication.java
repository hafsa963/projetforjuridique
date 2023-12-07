package ma.maisonSoftware.maisonSoftaware;

import ma.maisonSoftware.maisonSoftaware.dao.EtapeRepository;
import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
//import ma.maisonSoftware.maisonSoftaware.service.EtapeService;
import ma.maisonSoftware.maisonSoftaware.mapper.PrivilegeVo;
import ma.maisonSoftware.maisonSoftaware.mapper.RoleVo;
import ma.maisonSoftware.maisonSoftaware.mapper.UserVo;
import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.service.IPrestationService;
import ma.maisonSoftware.maisonSoftaware.service.ISocieteService;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@SpringBootApplication
@EnableWebMvc

public class MaisonSoftawareApplication implements CommandLineRunner {
	@Autowired
	private IUserService userService;

	@Autowired
	private ISocieteService iSocieteService;



//	@Autowired
//	private IPrestationService iPrestationService;

//	@Autowired
//	private PrestationRepository prestationRepository;

//	@Autowired
//	private EtapeRepository etapeRepository;


	private final static Logger LOGGER= LoggerFactory.getLogger(MaisonSoftawareApplication.class);

	@Autowired
	private Environment env;

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app=new SpringApplication(MaisonSoftawareApplication.class);

		Environment env = app.run(args).getEnvironment();
		LOGGER.info("Access URLs:\n----------------------------------------------------------\n\t" +
						"Local: \t\thttp://127.0.0.1:{}/swagger-ui/#/\n\t" +
						"External: \thttp://{}:{}/swagger-ui/#/\n----------------------------------------------------------",
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port")
		);
	}

	@Override
	public void run(String... args) throws Exception {
		PrivilegeVo privilege1 = new PrivilegeVo("create_users");
		PrivilegeVo privilege2 = new PrivilegeVo("delete_users");
		PrivilegeVo privilege3 = new PrivilegeVo("update_users");
		PrivilegeVo privilege4 = new PrivilegeVo("view");
		PrivilegeVo privilege5 = new PrivilegeVo("pagination_users");
		PrivilegeVo privilege6 = new PrivilegeVo("sort_users");



		RoleVo roleSuperAdmin = new RoleVo("SUPERADMIN");
		RoleVo roleAdmin = new RoleVo("ADMIN");
		RoleVo roleChef = new RoleVo("ROLE_USER");
//

		roleSuperAdmin.setPrivileges(Arrays.asList(privilege1, privilege2, privilege3, privilege4, privilege5, privilege6));
		roleAdmin.setPrivileges(Arrays.asList(privilege1, privilege2, privilege3, privilege4, privilege5, privilege6));
		roleChef.setPrivileges(Arrays.asList(privilege4));
		userService.save(privilege1);
		userService.save(privilege2);
		userService.save(privilege3);
		userService.save(privilege4);
		userService.save(privilege5);
		userService.save(privilege6);
		userService.save(roleSuperAdmin);
		userService.save(roleAdmin);
		userService.save(roleChef);
		UserVo admin = new UserVo("adminbenis","beniss","reda","beniss@gmail","directeur","adminadmin","adminadmin",Arrays.asList(roleAdmin),true,true,true,true);
		userService.save(admin);



 	}
}
