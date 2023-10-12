//package ma.maisonSoftware.maisonSoftaware.controller.rest;
//
//import ma.maisonSoftware.maisonSoftaware.mapper.EtapeVo;
//import ma.maisonSoftware.maisonSoftaware.mapper.PrestationVo;
//import ma.maisonSoftware.maisonSoftaware.mapper.SocieteVo;
//import ma.maisonSoftware.maisonSoftaware.service.EtapeService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/admin")
//@RestController
//public class EtapeController {
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(EtapeController.class);
//
//    @Autowired
//    private EtapeService etapeService;
//
//    @PostMapping("/createEtape")
//    public String createEtape(@RequestBody EtapeVo dto){
//        LOGGER.debug("start method create Etape dto : {}", dto);
//        return etapeService.saveEtape(dto);
//    }
//
//    @GetMapping(value = "/etape", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
//    public List<EtapeVo> getAll() {
//        return etapeService.getAllEtape();
//    }
//
//
//    @GetMapping("/getEtapeByPrestation/{id}")
//    public List<EtapeVo> getEtapeByIdService(@PathVariable("id") long id){
//        LOGGER.debug("start method get etape by id service : {}", id);
//        return  etapeService.getEtapeByidService(id);
//    }
//
//  /*  @PostMapping("/createEtape")
//    public ResponseEntity<String> createEtape(@RequestBody EtapeDto dto) {
//        LOGGER.debug("start method create Etape dto : {}", dto);
//        if (dto == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'objet EtapeDto est null");
//
//        } else {
//            return ResponseEntity.ok(etapeService.saveEtape(dto));
//        }
//    }*/
//
//
//    @PutMapping("/updateEtape")
//    public String updateEtape(@RequestBody EtapeVo dto){
//        LOGGER.debug("start method update Etape dto : {}", dto);
//        return  etapeService.updateEtape(dto);
//    }
//
//
//}
