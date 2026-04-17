package com.crucible.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("project", "Crucible");
        response.put("status", "operational");
        response.put("version", System.getProperty("app.version", "1.0.0"));
        return response;
    }

    @GetMapping("/pipeline")
    public Map<String, String> pipeline() {
        Map<String, String> response = new HashMap<>();
        response.put("pipeline", "active");
        response.put("stages", "checkout → build → quality-gate → scan → publish → deploy");
        response.put("tools", "Jenkins · Maven · SonarQube · Trivy · Nexus · Docker · Tomcat");
        return response;
    }
}
