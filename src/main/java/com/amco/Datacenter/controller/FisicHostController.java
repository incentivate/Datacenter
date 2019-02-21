package com.amco.Datacenter.controller;

import com.amco.Datacenter.model.FisicHost;
import com.amco.Datacenter.service.DatacenterService;
import com.amco.Datacenter.service.FisicHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FisicHostController {

    @Autowired
    FisicHostService fisicHostService;

    @Autowired
    DatacenterService datacenterService;

    // Lista todos los Host Fisicos
    @RequestMapping(value = "/hostFisicos")
        public String getFisicHost(ModelMap modelMap){
        List<FisicHost> allFisicHosts = fisicHostService.getAllFisicHosts();
        modelMap.put("hostFisicos", allFisicHosts);
        return "hostFisicos";
    }

    // Formulario para agregar un Host Fisico
    @RequestMapping(value = "/agregarHostFisico")
        public String addFisicHost(ModelMap modelMap){
        modelMap.put("fisicHost", new FisicHost());
        modelMap.put("allDatacenters", datacenterService.getAllDatacenters());
        return "agregarHostFisico";
    }

    // Método para borrar un Host Fisico y todas sus credenciales
    @RequestMapping(value = "/hostFisicos/{id}/delete", method = RequestMethod.POST)
    public String deleteFisicHost(@PathVariable(value="id") int id){
        FisicHost fisicHost = fisicHostService.getFisicHostById(id);
        fisicHostService.deleteAllCredentialsByFisicHost(fisicHost);
        fisicHostService.delete(fisicHost);
        return "chosenDatacenter";
    }

    // Metodo que recibe el POST del formulario y guarda el Objeto en BD
    @RequestMapping(value = "/hostFisicos", method = RequestMethod.POST)
        public String guardarHostFisico(@ModelAttribute("fisicHost") @Valid FisicHost fisicHost){
        fisicHostService.save(fisicHost);
        return "redirect:/hostFisicos";
    }

//    @RequestMapping(value = "/hostFisicos/{nombre}", method = RequestMethod.POST)
//    public String seleccionarHostFisico(@RequestParam("datacenterList") FisicHost fisicHost, @PathVariable String nombre){
//        if(fisicHost.getName().equals(nombre)){
//            return "hostFisicos";
//        }
//        return null;
//    }



}
