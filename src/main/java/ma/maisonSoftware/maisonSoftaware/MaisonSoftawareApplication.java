package ma.maisonSoftware.maisonSoftaware;

import ma.maisonSoftware.maisonSoftaware.dao.EtapeRepository;
import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.model.Etape;
import ma.maisonSoftware.maisonSoftaware.model.Prestation;
//import ma.maisonSoftware.maisonSoftaware.service.EtapeService;
import ma.maisonSoftware.maisonSoftaware.service.IPrestationService;
import ma.maisonSoftware.maisonSoftaware.service.ISocieteService;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class MaisonSoftawareApplication implements CommandLineRunner {
	@Autowired
	private IUserService userService;

	@Autowired
	private ISocieteService iSocieteService;

//	@Autowired
//	private EtapeService etapeService;

	@Autowired
	private IPrestationService iPrestationService;

	@Autowired
	private PrestationRepository prestationRepository;

	@Autowired
	private EtapeRepository etapeRepository;


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
//		PrivilegeVo privilege1 = new PrivilegeVo("create_users");
//		PrivilegeVo privilege2 = new PrivilegeVo("delete_users");
//		PrivilegeVo privilege3 = new PrivilegeVo("update_users");
//		PrivilegeVo privilege4 = new PrivilegeVo("view");
//		PrivilegeVo privilege5 = new PrivilegeVo("pagination_users");
//		PrivilegeVo privilege6 = new PrivilegeVo("sort_users");
//
//
//
//		RoleVo roleSuperAdmin = new RoleVo("SUPERADMIN");
//		RoleVo roleAdmin = new RoleVo("ADMIN");
//		RoleVo roleChef = new RoleVo("ROLE_USER");
//
//
//		roleSuperAdmin.setPrivileges(Arrays.asList(privilege1, privilege2, privilege3, privilege4, privilege5, privilege6));
//		roleAdmin.setPrivileges(Arrays.asList(privilege1, privilege2, privilege3, privilege4, privilege5, privilege6));
//		roleChef.setPrivileges(Arrays.asList(privilege4));
//		userService.save(privilege1);
//		userService.save(privilege2);
//		userService.save(privilege3);
//		userService.save(privilege4);
//		userService.save(privilege5);
//		userService.save(privilege6);
//		userService.save(roleSuperAdmin);
//		userService.save(roleAdmin);
//		userService.save(roleChef);
//		UserVo admin = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin), true, true, true, true);
//		UserVo superadmin = new UserVo("superadmin1", "superadmin1", Arrays.asList(roleSuperAdmin), true, true, true, true);
//		UserVo chef = new UserVo("chef1", "chef1", Arrays.asList(roleChef), true, true, true, true);
//		userService.save(admin);
//		userService.save(chef);
//		userService.save(superadmin);
//		ManagerVo managerVo = new ManagerVo("manager1");
//		ManagerVo managerVo1 = new ManagerVo("manager2");
//
//		iSocieteService.save(new SocieteVo("nom1", "form1", "10000dh", "seige1", 877l, 87L, 99l, 87L, 77L, "propriete2",Arrays.asList(managerVo,managerVo1)));
//
//		iSocieteService.save(new SocieteVo("nom2", "form2", "10000dh", "seige2", 8777l, 8777L, 9976l, 87L, 77L, "propriete3",Arrays.asList(managerVo)));
//
//        SocieteVo societeVo = new SocieteVo("nom3","forme3","10000dh","seige3",7666l,87555l,766l,66556l,877l,"prop44",Arrays.asList(managerVo));
//
//       iSocieteService.save(societeVo);
//
//		PrestationVo prestationVo = new PrestationVo("test");
//	iPrestationService.save(prestationVo);

 	}
}
