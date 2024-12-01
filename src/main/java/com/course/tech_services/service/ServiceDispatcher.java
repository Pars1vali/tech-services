package com.course.tech_services.service;

import com.course.tech_services.dto.ServiceDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDispatcher {

    private List<ServiceDTO> serviceList;

    private List<ServiceDTO> loadServiceList(){
        List<ServiceDTO> serviceList = new ArrayList<>();
        serviceList.add(new ServiceDTO(1, "service_1", 100));
        serviceList.add(new ServiceDTO(2, "service_2", 200));
        serviceList.add(new ServiceDTO(3, "service_3", 300));

        return serviceList;
    }

    public ServiceDispatcher() {
        serviceList = loadServiceList();
    }

    public void addService(ServiceDTO serviceDTO){
        serviceList.add(serviceDTO);
    }

    public void editService(ServiceDTO serviceDTO){
        for(ServiceDTO s: serviceList){
            if(s.getId() == serviceDTO.getId()){
                s.setName(serviceDTO.getName());
                s.setDescription(serviceDTO.getDescription());
                s.setPrice(serviceDTO.getPrice());
                break;
            }
        }

    }

    public List<ServiceDTO> getServiceList(){
        return serviceList;
    }

    public ServiceDTO getServiceByID(long id){
        ServiceDTO service = null;
        for(ServiceDTO serviceDTO: serviceList){
            if(serviceDTO.getId() == id){
                service = serviceDTO;
                break;
            }
        }

        return service;
    }

}
