package epicare_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public Map<String, String> getStatus() {
        return Map.of(
            "aplikasi", "EpiCare+ Web API",
            "status", "berjalan"
        );
    }
}
