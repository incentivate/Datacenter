package com.amco.Datacenter.controller;

import com.amco.Datacenter.dao.FisicHostDao;
import com.amco.Datacenter.model.Credential;
import com.amco.Datacenter.model.FisicHost;
import com.amco.Datacenter.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class CredentialController {

    @Autowired
    private FisicHostDao fisicHostDao;
    @Autowired
    private CredentialService credentialService;

    // Get credenciales para cada FisicHost
    @RequestMapping(value = "/fisicHost/{id}/credentials", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Credential> credentialsByFisicHost(@PathVariable(value = "id") final int fisicHostId, ModelMap modelMap){
        FisicHost optionalFisicHost = fisicHostDao.findById(fisicHostId);

        if (optionalFisicHost == null) {
            // Responder con 404
        }
        FisicHost fisicHost = optionalFisicHost;
        return fisicHost.getCredentials();
    }

    // Método para agregar credenciales
    @RequestMapping(value = "/fisicHost/{id}/credentials/add", method = RequestMethod.POST)
    public void addCredential(@PathVariable(value = "id") int fisicHostId, @RequestParam(value = "User") String user,
                              @RequestParam(value = "Password") String password, @RequestParam(value = "Notes") String notes){
        FisicHost fisicHost = fisicHostDao.findById(fisicHostId);
        List<Credential> allCredentials = fisicHost.getCredentials();
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setPassword(password);
        credential.setNotes(notes);
        credential.setFisicHost(fisicHost);
        credentialService.save(credential);
    }

    // Método para borrar credenciales
    @RequestMapping(value = "/fisicHost/{id}/credentials/delete", method = RequestMethod.POST)
    public void deleteCredential(@PathVariable(value = "id") String credId){
        String[] parts = credId.split("-");
        int id = Integer.parseInt(parts[1]);
        Credential credential = credentialService.getCredentialById(id);
        credentialService.delete(credential);
    }

    // Método para actualizar credenciales
    @RequestMapping(value = "/fisicHost/{id}/credentials/update", method = RequestMethod.POST)
    public void updateCredential(@PathVariable(value = "id") String credId, @RequestParam(value = "User") String user,
                                 @RequestParam(value = "Password") String password, @RequestParam(value = "Notes") String notes){
        String[] parts = credId.split("-");
        int id = Integer.parseInt(parts[1]);
        Credential credential = credentialService.getCredentialById(id);
        if(!(user.equals(null))){
            credential.setUser(user);
        }
        if((!password.equals(null))){
            credential.setPassword(password);
        }
        if(!(notes.equals(null))){
            credential.setNotes(notes);
        }

        credentialService.update(credential);
    }
}
