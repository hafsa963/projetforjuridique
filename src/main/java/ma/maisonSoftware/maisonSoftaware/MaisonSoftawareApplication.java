package ma.maisonSoftware.maisonSoftaware;

import javafx.scene.input.KeyCode;
import ma.maisonSoftware.maisonSoftaware.dao.EtapeRepository;
import ma.maisonSoftware.maisonSoftaware.dao.PrestationRepository;

import ma.maisonSoftware.maisonSoftaware.mapper.*;
import ma.maisonSoftware.maisonSoftaware.service.*;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableWebMvc

public class MaisonSoftawareApplication implements CommandLineRunner {
	@Autowired
	private IUserService userService;

	@Autowired
	private ITypesocieteService iTypesocieteService;




	@Autowired
	private IPrestationService iPrestationService;

	@Autowired
	private PrestationRepository prestationRepository;

	@Autowired
	private IClientService  iClientService;

	@Autowired
	private EtapeRepository etapeRepository;


	@Autowired
	private  AttachmentService attachmentService;

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

		//typeSociete TypesName:
		TypeSocieteVo typeSocieteVo1 = new TypeSocieteVo( "SARL");
		TypeSocieteVo typeSocieteVo2 = new TypeSocieteVo( "SARLAU");
		TypeSocieteVo typeSocieteVo3 = new TypeSocieteVo( "SA");
		TypeSocieteVo typeSocieteVo4 = new TypeSocieteVo( "Auto Entrepreneur");
		TypeSocieteVo typeSocieteVo5 = new TypeSocieteVo( "personne phisique");
		TypeSocieteVo typeSocieteVo6 = new TypeSocieteVo( "personne morale");

		iTypesocieteService.save(typeSocieteVo1);
		iTypesocieteService.save(typeSocieteVo2);
		iTypesocieteService.save(typeSocieteVo3);
		iTypesocieteService.save(typeSocieteVo4);
		iTypesocieteService.save(typeSocieteVo5);
		iTypesocieteService.save(typeSocieteVo6);

		/*AttachmentVo attachmentVo1 = new AttachmentVo("");
		attachmentService.uploadFile(attachmentVo1);*/

		  ClientVo clientVo = new ClientVo("IBM", "JURIDIQUE", "500000", "Casablanca", 12345L, 29945677L, 223770L, 236561L, 5996561L, "riham", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","SARL",true);
	     ClientVo clientVo1 = new ClientVo("DELOITE", "JURIDIQUE", "500000", "Rabat", 12225L, 2323677L, 293370L, 334561L, 9956561L, "AYA", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","SA",true);
		ClientVo clientVo2 = new ClientVo("INSIDE", "JURIDIQUE", "6600000", "Tanger", 98984L, 2308677L, 293470L, 335561L, 9966561L, "REDA", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","Auto Entrepreneur",true);
		ClientVo clientVo3 = new ClientVo("FOREN", "JURIDIQUE", "500000", "titouan", 56645L, 2312677L, 293470L, 334561L, 9986561L, "SAMI", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","personne phisique",true);
		ClientVo clientVo4 = new ClientVo("SHOP", "JURIDIQUE", "400000", "Tanger", 11945L, 2386677L, 293775L, 336531L, 9996961L, "MOAD", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","personne phisique",true);
		ClientVo clientVo5 = new ClientVo("SHOPFORME", "JURIDIQUE", "230000", "Rabat", 12568L, 2995677L, 263770L, 236561L, 996561L, "HAFSA", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","SA",true);
		ClientVo clientVo6 = new ClientVo("SHOP4Y", "JURIDIQUE", "30000", "Casablanca", 22245L, 1245677L, 793770L, 836561L, 9996561L, "REINA", "123345", "qualité1", "Casa Anfa", "cal", "20200", "Casablanca", "700", "Maroc", "068896247532","068896247532", "ria@gmail.com","h", "en cours","SARL",true);



		iClientService.save(clientVo);
		iClientService.save(clientVo1);
		iClientService.save(clientVo2);
		iClientService.save(clientVo3);
		iClientService.save(clientVo4);
		iClientService.save(clientVo5);
		iClientService.save(clientVo6);

		 EtapeVo etape1 = new EtapeVo(1,"demande registre comerce");
		EtapeVo etape2 = new EtapeVo(2,"demande Certificat negatif");
		EtapeVo etape3 = new EtapeVo(3,"demande Rib");

		List<EtapeVo> etapeDtoList = new ArrayList<>();
		etapeDtoList.add(etape1);
		etapeDtoList.add(etape2);
		etapeDtoList.add(etape3);

		PrestationVo prestationVo  = new PrestationVo ("Creation société","null",etapeDtoList);
		PrestationVo prestationVo1  = new PrestationVo ("Creation société1","null",etapeDtoList);
		PrestationVo prestationVo2  = new PrestationVo ("Creation société2","null",etapeDtoList);
		iPrestationService.save(prestationVo);
		iPrestationService.save(prestationVo1);
		iPrestationService.save(prestationVo2);



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



//		UserVo admin = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin), true, true, true, true);
		UserVo admin = new UserVo("adminbenis","beniss","reda","beniss@gmail","directeur","adminadmin","adminadmin",Arrays.asList(roleAdmin),true,true,true,true);
		UserVo admin1 = new UserVo("salmalayli","layli","salma","salma@gmail","gestionnaire","salma123","salma123",Arrays.asList(roleAdmin),true,true,true,true);
		UserVo admin2 = new UserVo("yara1","yarati","yara","yara@gmail","Comptable","yara123","yara123",Arrays.asList(roleChef),true,true,true,true);
		UserVo admin3 = new UserVo("mohamed1","RADI","mohamed","mohamed@gmail","gestionnaire","mohamed123","mohamed123",Arrays.asList(roleAdmin),true,true,true,true);

		userService.save(admin);
		userService.save(admin1);
		userService.save(admin2);
		userService.save(admin3);








	}
}
