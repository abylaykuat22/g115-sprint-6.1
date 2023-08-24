package kz.bitlab.G115sprinttask61.service;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.ApplicationRequest;
import kz.bitlab.G115sprinttask61.exception.AppReqNotFoundException;
import kz.bitlab.G115sprinttask61.repository.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationRequestService {

  @Autowired
  private ApplicationRequestRepository appReqRepository;

  public void addAppReq(ApplicationRequest appReq) {
    appReq.setHandled(false);
    appReqRepository.save(appReq);
  }

  public List<ApplicationRequest> getAppRequests() {
    return appReqRepository.findAll();
  }

  public ApplicationRequest getAppReqById(Long id) {
    return appReqRepository.findById(id)
        .orElseThrow(() -> new AppReqNotFoundException("Application Request not found!"));
  }
}
