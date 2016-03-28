package com.sjsu.cmpe275.lab2.controller;

import com.sjsu.cmpe275.lab2.domain.Profile;
import com.sjsu.cmpe275.lab2.configuration.ProfileConfi;
import com.sjsu.cmpe275.lab2.service.ProfileDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by huimin on 3/24/16.
 */

@Controller
public class ProfileController {

    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    ApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfi.class);
    //CourseDao courseDao = context.getBean(CourseDao.class);

    ProfileDao profileDao = context.getBean(ProfileDao.class);

//    @RequestMapping("/profile")
//    public String profile() {
//
//
//        List<Profile> profiles = profileDao.findAll();
//        String profile = profiles.get(0).toString();
//
//        return profile;
//    }

//    @Autowired
//    private ProfileDao profileDao;
//
//    @RequestMapping("/guest")
//    public ModelAndView handleRequest(HttpServletRequest arg0,
//                                      HttpServletResponse arg1) throws Exception {
//        //List<Profile> profiles = profileDao.findAll();
//        //String profile = profiles.get(0).toString();
//
//        // Prepare the result view (guest.jsp):
////        ModelAndView a = new ModelAndView("index.jsp","",);
////        return new ModelAndView("index.jsp", "guestDao", guestDao);
//
//        //name of jsp
//        logger.debug("哈喽 guest 进入啦");
//        ModelAndView modelAndView = new ModelAndView("index");
//        //match objects in jsp
//        logger.debug("找到东西啦", profileDao.findAll().toString());
//        modelAndView.addObject("profileList", profileDao.findAll());
//
//        return modelAndView;
//    }

//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public void listAll(Model model) {
//        model.addAttribute("persons", profileDao.findAll());
//
//    }

//    @RequestMapping(value="/profile", method= RequestMethod.GET)
//    public ModelAndView ProfileListPage() {
//        ModelAndView mav = new ModelAndView("profile");
//        List<Profile> profileList = profileDao.findAll();
//        mav.addObject("profileList", profileList);
//        return mav;
//    }


    @RequestMapping("/profile")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("create");
        return mav;
    }


    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView createProfile(@ModelAttribute Profile profile) {
        ModelAndView mav = new ModelAndView("create");
        profileDao.store(profile);
        return mav;
    }

    @RequestMapping(value="/profile/{id}")
    public ModelAndView showPage(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("detail");
        Profile profile = profileDao.findById(id);
        mav.addObject("profile", profile);
        return mav;
    }

    @RequestMapping(value="/profile/{id}/post", method=RequestMethod.POST)
    public ModelAndView editShopPage(@ModelAttribute Profile profile, @PathVariable String id) {
        ModelAndView mav = new ModelAndView("editable");
        profileDao.update(profile);
        return mav;
    }



//    @RequestMapping(value = "message", method = RequestMethod.GET)
//    public ModelAndView messages() {
//        ModelAndView mav = new ModelAndView("message/list");
//        mav.addObject("messages", messageRepository.findAll());
//        return mav;
//    }

    @RequestMapping("/list")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "list";
    }



}
