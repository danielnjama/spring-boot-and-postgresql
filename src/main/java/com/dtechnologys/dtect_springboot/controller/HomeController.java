// package com.dtechnologys.dtect_springboot.controller;
package com.dtechnologys.dtect_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtechnologys.dtect_springboot.model.TestRecord;
import com.dtechnologys.dtect_springboot.repository.TestRecordRepository;

@Controller
public class HomeController {

    @Autowired
    private TestRecordRepository testRecordRepository;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        return "home"; // This maps to home.html in templates
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("title", "Contacts Page");
        return "contacts"; // This maps to contacts.html in templates
    }

    @GetMapping("/db-test")
    @ResponseBody
    public String testDatabaseConnection() {
        TestRecord record = new TestRecord("Testing DB connection");
        testRecordRepository.save(record);

        long totalRecords = testRecordRepository.count();
        return "DB connection successful! Total records: " + totalRecords;
    }

    @GetMapping("/db-test-page")
    public String testDatabasePage(Model model) {
        TestRecord record = new TestRecord("Test from template");
        testRecordRepository.save(record);

        long totalRecords = testRecordRepository.count();
        model.addAttribute("message", "DB connected! Total records: " + totalRecords);
        return "db-test";
    }

}
