package com.amco.Datacenter.model;

import com.amco.Datacenter.service.DatacenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Locale;

@Component
public class DatacenterFormatter implements Formatter<Datacenter> {

    @Autowired
    DatacenterService datacenterService;

    @Override
    public Datacenter parse(String name, Locale locale) throws ParseException {
        int id = Integer.parseInt(name);
        return datacenterService.getDatacenterById(id);
    }

    @Override
    public String print(Datacenter datacenter, Locale locale) {
        return datacenter.getName();
    }
}
