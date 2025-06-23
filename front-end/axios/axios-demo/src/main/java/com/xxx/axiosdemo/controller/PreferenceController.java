package com.xxx.axiosdemo.controller;

import com.xxx.axiosdemo.pojo.Preference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/preferences")
@CrossOrigin
public class PreferenceController {

  @GetMapping
  public List<Preference> list() {
    ArrayList<Preference> preferences = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      preferences.add(new Preference("prefer" + i));
    }
    return preferences;
  }
}
