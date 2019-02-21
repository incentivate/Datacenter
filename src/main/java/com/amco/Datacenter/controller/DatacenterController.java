package com.amco.Datacenter.controller;

import com.amco.Datacenter.dao.DatacenterDao;
import com.amco.Datacenter.model.Datacenter;
import com.amco.Datacenter.model.FisicHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DatacenterController {

    @Autowired
    private DatacenterDao datacenterDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(ModelMap modelMap){
        modelMap.put("allDatacenters", datacenterDao.getAllDatacenters());
        return "datacenter";
    }

    @RequestMapping(value = "/addDatacenter", method = RequestMethod.POST)
    public String addDatacenter(@RequestParam(value = "Name") String name){
        Datacenter datacenter = new Datacenter();
        datacenter.setName(name);
        datacenterDao.save(datacenter);
        return "datacenter";
    }


    @RequestMapping(value = "/chosenDatacenter", method = RequestMethod.POST)
    public String datacenterPostHandler(@RequestParam("datacenterList") String name, ModelMap modelMap){
        List<Datacenter> allDatacenters = datacenterDao.getAllDatacenters();
        for (Datacenter dc : allDatacenters) {
            if (dc.getName().equals(name)) {
                modelMap.put("datacenter", dc);

                List<FisicHost> datacenterFisicHosts = dc.getFisicHostList();
                modelMap.put("datacenterFisicHosts", datacenterFisicHosts);

                return "chosenDatacenter";
            }
        }
        return null;
    }


}
