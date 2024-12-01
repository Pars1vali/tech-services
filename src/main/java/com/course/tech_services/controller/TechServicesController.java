package com.course.tech_services.controller;


import com.course.tech_services.dto.ServiceDTO;
import com.course.tech_services.service.ServiceDispatcher;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api/v1/tech-services")
@RestController
@Validated
public class TechServicesController {

    private ServiceDispatcher serviceDispatcher;

    @Autowired
    public TechServicesController(ServiceDispatcher serviceDispatcher) {
        this.serviceDispatcher = serviceDispatcher;
    }

    //Получение услуги по индитификатору
    @GetMapping("/{id}")
    public ServiceDTO getServiceByID(@PathVariable @Positive long id){
        return serviceDispatcher.getServiceByID(id);
    }

    //Получение списка услуг
    @GetMapping
    public @ResponseBody List<ServiceDTO> getListServices(){
        return serviceDispatcher.getServiceList();
    }

    //Создание услуги
    @PostMapping
    public void createService(@RequestBody ServiceDTO serviceDTO){
        serviceDispatcher.addService(serviceDTO);
    }

    //Редактирование услуги
    @PutMapping
    public void editServiceByID(@RequestBody ServiceDTO serviceDTO){

        serviceDispatcher.editService(serviceDTO);

    }

}
