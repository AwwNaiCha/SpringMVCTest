package com.sjsu.cmpe275.lab2;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

/**
 * Created by huimin on 3/24/16.
 */

@Controller
public class ProfileController {

    @Autowired
    ProfileDao profileDao;

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView emptyProfile() {
        Profile profile = new Profile();
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("profile",profile);
        return mav;
    }

    @RequestMapping(value="/profile", method = RequestMethod.DELETE)
    public ModelAndView profileDelete() {
        Profile profile = new Profile();
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("profile",profile);
        return mav;
    }
    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView createProfile(@ModelAttribute Profile profile, final RedirectAttributes redirectAttributes) {
        if(profile.getId() == null || profile.getId().equals("")) {
            ModelAndView mav = new ModelAndView("redirect:/profile");
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:/profile/" + profile.getId());
        if(profileDao.findById(profile.getId()) != null) {
            profileDao.update(profile);
        }
        else {
            profileDao.create(profile);
        }
        return mav;
    }



    @RequestMapping(value = {"/profile/{id}"}, method = RequestMethod.GET)
    public String showProfile(@PathVariable String id, @RequestParam Map<String,String> allRequestParams, Model model){
        System.out.println("" + profileDao.findById(id) );
        if(profileDao.findById(id) == null ) throw new NotFoundExcp(id);
        model.addAttribute("profile", profileDao.findById(id));
        if(allRequestParams.containsKey("brief")) {
            if(allRequestParams.get("brief").equals("true")){
                return "brief";
            }
        }
        return "detail";
    }

    @RequestMapping(value={"/profile/{id}"}, method = RequestMethod.POST)
    public ModelAndView postProfile(@ModelAttribute Profile profile, @RequestParam(value="action") String action,
                                    @PathVariable String id, final RedirectAttributes redirectAttributes) {
        if(action.equals("delete")) {
            ModelAndView modelAndView = new ModelAndView("redirect:/redirectdelete");
            profile = profileDao.delete(String.valueOf(id));
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/profile/" + id);
        if(profileDao.findById(String.valueOf(id)) != null) {
            profileDao.update(profile);
        }
        else {
            profileDao.create(profile);
        }
        return modelAndView;
    }


    @RequestMapping(value={"/profile/{id}"}, method = RequestMethod.DELETE)
    public ModelAndView deleteProfile(@PathVariable String id, final RedirectAttributes redirectAttributes) {
        if(profileDao.findById(id) == null ) throw new NotFoundExcp(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/redirectdelete");
        Profile profile = profileDao.delete(id);
        //redirectAttributes.addFlashAttribute("message", "profile" + id + "was deleted!");
        return modelAndView;
    }

    @RequestMapping(value="/redirectdelete")
    public View redirectDelete(final RedirectAttributes redirectAttributes) {
        RedirectView redirect = new RedirectView("/profile");
        redirect.setExposeModelAttributes(false);
        return redirect;
    }


//    @RequestMapping(value="/profile/{id}", method = RequestMethod.GET)
//    public ModelAndView showPage(@PathVariable String id) {
//        ModelAndView mav = new ModelAndView("detail");
//        Profile profile = profileDao.findById(id);
//        mav.addObject("profile", profile);
//        return mav;
//    }
//
//    @RequestMapping(value="/profile/{id}/post", method=RequestMethod.POST)
//    public ModelAndView editShopPage(@ModelAttribute Profile profile, @PathVariable String id) {
//        ModelAndView mav = new ModelAndView("editable");
//        profileDao.update(profile);
//        return mav;
//    }

    @ExceptionHandler(NotFoundExcp.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound() throws Exception {
        return "404";
    }




}
